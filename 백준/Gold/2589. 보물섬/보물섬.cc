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
#define S second
#define F first
#define l long
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
//cin.tie(NULL);
//ios::sync_with_stdio(false);


int n;
int m;
char board[55][55];
bool vis[55][55];
int dp[55][55];
queue<pair<int,int>> Q;
queue<pair<int,int>> sub_Q;
int result;
void bfs(int x, int y)
{
    Q.push(make_pair(x, y));
    vis[x][y] = 1;
    
    while(!Q.empty())
    {
        pair<int,int> cur = Q.front(); Q.pop();
        for(int dir=0; dir<4; dir++)
        {
            int nx = dx[dir] + cur.F;
            int ny = dy[dir] + cur.S;
            
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            //cout << nx << " " << ny << endl;
            if(board[nx][ny] == 'W') continue;
            if(vis[nx][ny] == 1) continue;
            
            dp[nx][ny] = dp[cur.F][cur.S] + 1;
            
            Q.push(make_pair(nx, ny));
            vis[nx][ny] = 1;
        }
    }
}
void see()
{
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            result = max(result,dp[i][k]);
            vis[i][k] = 0;
            dp[i][k] = 0;
        }
    }
}
int main()
{
    cin >> n >> m;
    
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            cin>> board[i][k];
            if(board[i][k] == 'L')
            {
                sub_Q.push(make_pair(i, k));
            }
        }
    }
    sub_Q.push(make_pair(3, 0));
    while(!sub_Q.empty())
    {
       
        bfs(sub_Q.front().F, sub_Q.front().S);
        sub_Q.pop();
        see();
    }
    cout << result << endl;
    
}