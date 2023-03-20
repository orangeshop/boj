//
//  main.cpp
//  test
//
//  Created by 최영호 on 2021/12/16.
//


#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
#include <tuple>
#include <math.h>
#include <set>
#include <map>
using namespace std;
//cin.tie(NULL);
//ios::sync_with_stdio(false);


int n,m;
int board[301][301];
int minuse[301][301];
int check_board[301][301];
bool vis[301][301];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int final_result = -1;
queue<pair<int,int>> Q;

void bfs(){
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            if(board[i][k] == 0) continue;
            
            Q.push({i,k});
            
            while(!Q.empty())
            {
        
                pair<int,int> cur = Q.front(); Q.pop();
        
                for(int dir =0; dir<4; dir++)
                {
                    int nx = dx[dir] + cur.first;
                    int ny = dy[dir] + cur.second;
            
                    if(nx< 0 || nx > n || ny< 0 || ny > m) continue;
            
                    if(board[nx][ny] == 0)
                    {
                        minuse[cur.first][cur.second] += 1;
                    }
                }
            }
        }
        
    }
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            board[i][k] -= minuse[i][k];
           
            minuse[i][k] = 0;
            if(board[i][k] < 0)
            {
                board[i][k] = 0;
            }
        }
       
    }
}

void check(){
    
    int count =1;
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            if(board[i][k] == 0) continue;
            if(vis[i][k] == 1) continue;
            
            Q.push({i,k});
            vis[i][k] = 1;
            check_board[i][k] = count;
            while(!Q.empty())
            {
                pair<int,int> cur = Q.front(); Q.pop();
        
                for(int dir =0; dir<4; dir++)
                {
                    int nx = dx[dir] + cur.first;
                    int ny = dy[dir] + cur.second;
            
                    if(nx< 0 || nx > n || ny< 0 || ny > m) continue;
                    if(vis[nx][ny] == 1 || board[nx][ny]==0) continue;
                    check_board[nx][ny] = count;
                    vis[nx][ny] = 1;
                    Q.push({nx,ny});
                }
            }
            count++;
            
        }
        
    }
    
    int target_2 = 2;
    int target_0 = 0;
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            if(i == n-1 && k == m-1){
                
                if(target_0 == 0)
                {
                    //cout << "한번에 다 녹음" << endl;
                    final_result = 1;
                    return;
                }
            }
            
            if(check_board[i][k] == 2)
            {
                //cout << "대륙 분리" << endl;
                final_result = 2;
                return;
            }
            
            target_0 = max(target_0, check_board[i][k]);
            //cout << check_board[i][k] << " ";
            vis[i][k] = 0;
            check_board[i][k] = 0;
        }
        //cout << endl;
    }
    
    
    //cout <<target_0 << endl;
}

int main(){
    cin >> n >> m;
    
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            cin >> board[i][k];
        }
    }
    
    int count =0;
   
    
    while(true)
    {
        count++;
        bfs();
   
        check();
    
        if(final_result == 2)
        {
            cout <<count << endl;
            return 0;
        }
        
        if(final_result == 1)
        {
            cout << "0" << endl;
            return 0;
        }
       
    }

}