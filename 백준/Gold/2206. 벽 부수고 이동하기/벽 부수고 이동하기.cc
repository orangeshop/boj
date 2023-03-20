
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
#define MAX 1000
char board[MAX+1][MAX+1];
int dist1[MAX+1][MAX+1];
int dist2[MAX+1][MAX+1];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int n,m;

bool IsOutBound(int x, int y)
{
    return 0 > x || x >= n || 0 > y || y >= m;
        
}


int main()
{
    cin >> n >> m;
    
    for(int i=0; i<n; i++)
    {
        cin >> board[i];
    }
    
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            dist1[i][k] = dist2[i][k] = -1;
        }
    }
    
    queue<pair<int,int>> Q;
    Q.push({0,0});
    dist1[0][0] = 1;
    while (!Q.empty())
    {
        pair<int,int> cur = Q.front(); Q.pop();
        
        for(int dir =0; dir <4; dir++)
        {
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];
            
            if(IsOutBound(nx,ny) == 1 || board[nx][ny] == '1' || dist1[nx][ny] != -1) continue;
            
            dist1[nx][ny] = dist1[cur.first][cur.second] +1;
            Q.push({nx,ny});
        }
    }
    
    Q.push({n-1,m-1});
    dist2[n-1][m-1] = 1;
    while (!Q.empty())
    {
        pair<int,int> cur = Q.front(); Q.pop();
        
        for(int dir =0; dir <4; dir++)
        {
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];
            
            if(IsOutBound(nx,ny) || board[nx][ny] == '1' || dist2[nx][ny] != -1) continue;
            
            dist2[nx][ny] = dist2[cur.first][cur.second] +1;
            Q.push({nx,ny});
        }
    }
    
    int min_num = 0x7fffff;
    if(dist2[0][0] >= 0)
        min_num = dist2[0][0];
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            if(board[i][k] == '0')
                continue;
            
            int min_dist1 = 0x7fffff;
            int min_dist2 = 0x7fffff;
            
            for(int dir =0; dir <4; dir++)
            {
                int nx = i + dx[dir];
                int ny = k + dy[dir];
                
                if(IsOutBound(nx, ny))
                    continue;
                if(dist1[nx][ny] >= 0)
                    min_dist1 = min(min_dist1,dist1[nx][ny]);
                if(dist2[nx][ny] >= 0)
                    min_dist2 = min(min_dist2,dist2[nx][ny]);
                
            }
            min_num = min(min_num, min_dist1+min_dist2+1);
            
        }
    }
    
    if(min_num == 0x7fffff)
    {
        cout << "-1" << endl;
    }
    else{
        cout << min_num << endl;
    }
    
    
    
}