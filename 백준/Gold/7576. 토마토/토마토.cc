#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
using namespace std;

int board[1000][1000];
bool vis[1000][1000];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int n=0;
int m=0;

int main()
{
    queue<pair<int,int>> Q;
    
    cin >> m >> n;
    
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            cin >> board[i][k];
            if(board[i][k]==1)
            {
                Q.push({i,k});
                vis[i][k] =1;
            }
            
        }
    }
    
    int cnt =0;
    

        //cout << A.first << " " << A.second << endl;
        
        
        while(!Q.empty())
        {
            pair<int,int> cur = Q.front(); Q.pop();
        
            //cout << cur.first <<"," << cur.second << "->";
            for(int i=0; i<4; i++)
            {
                int nx = dx[i] + cur.first;
                int ny = dy[i] + cur.second;
            
                if(board[nx][ny]==-1) continue;
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(vis[nx][ny] == 1) continue;
                
                board[nx][ny] = board[cur.first][cur.second]+1;
                cnt = board[nx][ny];
                Q.push({nx,ny});
                vis[nx][ny] =1;
            }
           
        
    }
    
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            //cout << board[i][k] << " ";
            if(board[i][k]==0)
            {
                cnt = -1;
            }
        }
        //cout << endl;
    }
    
    if(cnt<=0)
    {
        cout << cnt << endl;
    }
    else{
    cout << cnt-1 << endl;
    }
}
