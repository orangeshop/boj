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
int N,M,K;
queue<pair<int,pair<int,int>>> Q;
int min_result = MAX;
char board[1005][1005];
bool vis[1005][1005][11];
int dp[1005][1005][11];

void see()
{
    for(int i=0; i<N; i++)
    {
        for(int k=0; k<M; k++)
        {
            cout << board[i][k] << " ";
        }
        cout << endl;
    }
}

void bfs(int x, int y,int c)
{
    Q.push(make_pair(x, make_pair(y,c)));
    vis[x][y][c] = 1;
    dp[x][y][c] = 1;
    while(!Q.empty())
    {
        pair<int,pair<int,int>> cur = Q.front(); Q.pop();
        for(int dir = 0; dir<4; dir++)
        {
            int nx = dx[dir] + cur.F;
            int ny = dy[dir] + cur.S.F;
            
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(vis[nx][ny][cur.S.S] == 1 || vis[nx][ny][cur.S.S-1] == 1) continue;
            
            if(board[nx][ny] == '1' && cur.S.S < K)
            {
                dp[nx][ny][cur.S.S+1] = dp[cur.F][cur.S.F][cur.S.S] + 1;
                Q.push(make_pair(nx, make_pair(ny, cur.S.S+1)));
                vis[nx][ny][cur.S.S+1] = 1;
            }
            
            if(board[nx][ny] == '0')
            {
                dp[nx][ny][cur.S.S] = dp[cur.F][cur.S.F][cur.S.S] + 1;
                Q.push(make_pair(nx, make_pair(ny, cur.S.S)));
                vis[nx][ny][cur.S.S] = 1;
            }
        }
    }
}

int main()
{
    cin >> N >> M >> K;
    
    for(int i=0; i<N; i++)
    {
        for(int k=0; k<M; k++)
        {
            cin >> board[i][k];
        }
    }

    for(int i=0; i<=K; i++)
    {
        dp[N-1][M-1][i] = MAX;
    }
    bfs(0,0,0);
   
    for(int i=0; i<=K; i++)
    {
        min_result = min(dp[N-1][M-1][i],min_result);
    }
    
    
    if(min_result == MAX)
    {
        cout << "-1" << endl;
    }
    else{
        cout << min_result << endl;
    }
    
}