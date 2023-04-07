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
queue<pair<pair<int,int>,pair<int,int>>> Q;
int min_result = MAX;
char board[1005][1005];
bool vis[1005][1005][11][2];
int dp[1005][1005][11][2];

void see()
{
    for(int i=0; i<N; i++)
    {
        for(int k=0; k<M; k++)
        {
            cout << dp[i][k] << " ";
        }
        cout << endl;
    }
}

void bfs(int x, int y,int c , int day)
{
    Q.push(make_pair(make_pair(x,y), make_pair(c,day)));
    vis[x][y][c][day] = 1;
    dp[x][y][c][day] = 1;
    while(!Q.empty())
    {
        pair<pair<int,int>,pair<int,int>> cur = Q.front(); Q.pop();
        for(int dir = 0; dir<4; dir++)
        {
            int nx = dx[dir] + cur.F.F;
            int ny = dy[dir] + cur.F.S;
            
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(vis[nx][ny][cur.S.F][0] == 1 || vis[nx][ny][cur.S.F-1][0] == 1) continue;
            if(vis[nx][ny][cur.S.F][1] == 1 || vis[nx][ny][cur.S.F-1][1] == 1) continue;
            
            if(board[nx][ny] == '1' && cur.S.F < K)
            {
                if(cur.S.S == 1)
                {
                    dp[cur.F.F][cur.F.S][cur.S.F][0] = dp[cur.F.F][cur.F.S][cur.S.F][cur.S.S] + 1;
                    Q.push(make_pair(make_pair(cur.F.F,cur.F.S), make_pair(cur.S.F,0)));
                    //vis[nx][ny][cur.S.F][cur.S.S] = 1;
                }
                
                if(cur.S.S == 0)
                {
                    dp[nx][ny][cur.S.F+1][1] = dp[cur.F.F][cur.F.S][cur.S.F][cur.S.S] + 1;
                    Q.push(make_pair(make_pair(nx,ny), make_pair(cur.S.F+1,1)));
                    vis[nx][ny][cur.S.F+1][1] = 1;
                }
            }
            
            if(board[nx][ny] == '0')
            {
                if(cur.S.S == 1)
                {
                    dp[nx][ny][cur.S.F][0] = dp[cur.F.F][cur.F.S][cur.S.F][cur.S.S] + 1;
                    Q.push(make_pair(make_pair(nx,ny), make_pair(cur.S.F,0)));
                    vis[nx][ny][cur.S.F][0] = 1;
                }
                
                if(cur.S.S == 0)
                {
                    dp[nx][ny][cur.S.F][1] = dp[cur.F.F][cur.F.S][cur.S.F][cur.S.S] + 1;
                    Q.push(make_pair(make_pair(nx,ny), make_pair(cur.S.F,1)));
                    vis[nx][ny][cur.S.F][1] = 1;
                }
               
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
        dp[N-1][M-1][i][0] = MAX;
        dp[N-1][M-1][i][1] = MAX;
    }
    bfs(0,0,0,0);
   
    //see();
    
    
    for(int i=0; i<=K; i++)
    {
        min_result = min(dp[N-1][M-1][i][0],min_result);
        min_result = min(dp[N-1][M-1][i][1],min_result);
    }
    
    
    if(min_result == MAX)
    {
        cout << "-1" << endl;
    }
    else{
        cout << min_result << endl;
    }
    
}