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
#define MAX 0x7ffffff
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int ddx[8] = {-1,-2,-2,-1,1,2,2,1};
int ddy[8] = {-2,-1,1,2,-2,-1,1,2};

//cin.tie(NULL);
//ios::sync_with_stdio(false);

int n,m;
char board[25][25];
bool vis[25][25];
int dp[25][25];
bool alpha[27];
stack<pair<int,int>> Q;
void see()
{
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            //cout << int(board[i][k]) << " ";
            //cout << dp[i][k] << " ";
        }
        //cout << endl;
    }
}
int result = 1;
int max_result = 1;
void dfs(int x, int y)
{
    //Q.push(make_pair(x, y));
    vis[x][y] = 1;
    
    for(int dir = 0; dir<4; dir++)
    {
        int nx = dx[dir] + x;
        int ny = dy[dir] + y;
        
        if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
        if(alpha[int(board[nx][ny])-65] != 0) continue;
        if(vis[nx][ny] == 1) continue;
        //cout << int(board[nx][ny])-65<<" " << board[nx][ny] << endl;
        //dp[nx][ny] = max(dp[nx][ny],dp[x][y] + 1);
        result+=1;
        max_result = max(max_result,result);
        vis[nx][ny] = 1;
        alpha[int(board[nx][ny])-65] = 1;
        dfs(nx, ny);
        result -= 1;
        //dp[nx][ny] = dp[x][y] - 1;
        vis[nx][ny] = 0;
        alpha[int(board[nx][ny])-65] = 0;
    }
    
    
    
}

int main()
{
    cin >> n >> m;
    
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            cin >> board[i][k];
        }
    }
    dp[0][0] = 1;
    alpha[int(board[0][0])-65] = 1;
    dfs(0, 0);
    see();
    cout << max_result << endl;
    
    
}