
#include <iostream>
#include <string>
#include<cstring>
#include <vector>
#include <stack>
#include <memory.h>
#include <algorithm>
#include <queue>
#include <tuple>
#include <math.h>
#include <set>
#include <map>
using namespace std;
//cin.tie(NULL);
//ios::sync_with_stdio(false);
vector<pair<int,int>> V;
int n,m;
int board[10][10];
bool vis[10][10];

int copy_board[10][10];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int max_count = -1;
void see(){
    for(int i=0; i< n; i++)
    {
        for(int k=0; k<m; k++)
        {
            cout << vis[i][k] << " ";
        }
        cout << endl;
    }
    cout <<"-----------------" <<endl;
}

void bfs(){
    
    queue<pair<int,int>> Q;
    
    for(int i=0; i< V.size(); i++)
    {
        int x = V[i].first;
        int y = V[i].second;
        
        Q.push({x,y});
        vis[x][y] = 1;
        
    }
    
    while(!Q.empty())
    {
        pair<int,int> cur = Q.front(); Q.pop();
        for(int dir =0; dir< 4; dir++)
        {
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];
           
            
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(board[nx][ny] == 1 || vis[nx][ny] == 1) continue;
            
            Q.push({nx,ny});
            vis[nx][ny] = 1;
        }
    }
        
    int count = 0;
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            
            if(board[i][k] == 0 &&vis[i][k] == 0)
            {
                count++;
            }
            vis[i][k] = 0;
        }
    }
        
        
    max_count = max(max_count,count);
        
    
    
}

int main()
{
    cin >> n >> m;
    
    for(int i=0; i< n; i++)
    {
        for(int k=0; k<m; k++)
        {
            cin >> board[i][k];
            if(board[i][k] == 2)
            {
                V.push_back({i,k});
            }
        }
    }
    
    
    
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            
            if(board[i][k] == 1 || board[i][k] == 2) continue;
            
            
            board[i][k] = 1;
            
            for(int i_1 = 0; i_1 < n; i_1++)
            {
                for(int k_1 = 0; k_1 < m; k_1++)
                {
                    if(board[i_1][k_1] == 1 || board[i_1][k_1] == 2) continue;
                    
                    board[i_1][k_1] = 1;
                    
                    for(int i_2 = 0; i_2 < n; i_2++)
                    {
                        for(int k_2 = 0; k_2 <m; k_2++)
                        {
                            if(board[i_2][k_2] == 1 || board[i_2][k_2] == 2) continue;
                            board[i_2][k_2] = 1;
                            
                            
                           
                            //see();
                            bfs();
                            
                            
                            board[i_2][k_2] = 0;
                        } // k_2
                    }//i_2
                    
                    board[i_1][k_1] = 0;
                } // k_1
            }// i_1
            
            
            board[i][k] = 0;
            
        }// k
    }// i*/
    
    
    
    cout << max_count << endl;
    
}