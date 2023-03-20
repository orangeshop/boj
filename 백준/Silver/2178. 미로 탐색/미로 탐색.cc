#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
#include <tuple>
using namespace std;

int board[100][100];
bool vis[100][100];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int n=0;
int m=0;

int main()
{
    
    cin >> n >> m;
    
    
    for(int i=0; i<n; i++)
    {
        string str;
        cin >> str;
        for(int k=0; k<m; k++)
        {
            board[i][k] = str[k]-48;
        }
    }

    queue<pair<int,int>> Q;
    Q.push({0,0});
    vis[0][0] =1;
    
    int cnt =0;
    
    while(!Q.empty())
    {
        pair<int,int> cur = Q.front(); Q.pop();
        //cout << cur.first <<"," << cur.second << "->";
        for(int i=0; i<4; i++)
        {
            int nx = dx[i] + cur.first;
            int ny = dy[i] + cur.second;
            
            if(board[nx][ny]==0) continue;
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(vis[nx][ny] == 1) continue;
    
            board[nx][ny] = board[cur.first][cur.second] +1;
            
            
            //cnt = board[nx][ny];
            
            Q.push({nx,ny});
            vis[nx][ny] =1;
        }
    }
    
    
    
    cout << board[n-1][m-1] << endl;
}