#include <iostream>
#include <string>
#include <cstring>
#include <vector>
#include <stack>
#include <memory.h>
#include <algorithm>
#include <queue>
#include <tuple>
#include <math.h>
#include <list>
#include <set>
#include <map>
#include <iterator>

using namespace std;
#define S second
#define F first
#define l long
#define MAX 0x7ffffff
int dx[4] = {-1,0,1,0};
int dy[4] = {0,1,0,-1};
int ddx[8] = {-1,-2,-2,-1,1,2,2,1};
int ddy[8] = {-2,-1,1,2,-2,-1,1,2};
int cdx[8] = {-1,0,1,0,-1,-1,1,1};
int cdy[8] = {0,1,0,-1,-1,1,1,-1};

//cin.tie(NULL);
//ios::sync_with_stdio(false);
//cout.tie(NULL);

queue<pair<int,pair<int,int>>> Q;
int N;
int board[105][105];
int dp[105][105];
bool vis[105][105];
int land_num[105][105];
int answer =MAX;
void see()
{
    for(int i=0; i<N; i++)
    {
        for(int k=0; k<N; k++)
        {
            cout << dp[i][k] << " ";
        }
        cout << endl;
    }
}

void find()
{
    for(int i=0; i<N; i++)
    {
        for(int k=0; k<N; k++)
        {
            if(board[i][k] == 1)
            {
                for(int dir =0; dir<4; dir++)
                {
                    int nx = dx[dir] + i;
                    int ny = dy[dir] + k;
                    
                    if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if(board[nx][ny] == 0)
                    {
                        Q.push({land_num[i][k],{i,k}});
                        break;
                    }
                }
            }
        }
    }
}
void vis_dp_reset()
{
    for(int i=0; i<N; i++)
    {
        for(int k=0; k<N; k++)
        {
            vis[i][k] = 0;
            dp[i][k] = 0;
        }
    }
}
void land()
{
    queue<pair<int,int>> q;
    int count = 1;
    for(int i=0; i<N; i++)
    {
        for(int k=0; k<N; k++)
        {
            if(board[i][k] == 1 && vis[i][k] == 0)
            {
                
                q.push({i,k});
                vis[i][k] = 1;
                land_num[i][k] = count;
                while(!q.empty())
                {
                    pair<int,int> cur = q.front();
                    q.pop();
                    
                    for(int dir =0; dir<4; dir++)
                    {
                        int nx = dx[dir] + cur.F;
                        int ny = dy[dir] + cur.S;
                        
                        if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                        if(board[nx][ny] == 0 || vis[nx][ny] == 1) continue;
                        land_num[nx][ny] = count;
                        q.push({nx,ny});
                        vis[nx][ny] = 1;
                        
                    }
                }
                
                count++;
            }
        }
    }
    vis_dp_reset();
}

void bfs()
{
    queue<pair<int,pair<int,int>>> sub_Q;
    while(!Q.empty())
    {
        //cout << "start  x : " <<Q.front().S.F << " " << Q.front().S.S << endl;
        sub_Q.push(Q.front());
        Q.pop();
        
        while(!sub_Q.empty())
        {
            pair<int, pair<int,int>> cur = sub_Q.front();
            sub_Q.pop();
            
            for(int dir =0; dir<4; dir++)
            {
                int nx = dx[dir] + cur.S.F;
                int ny = dy[dir] + cur.S.S;
                
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(vis[nx][ny] == 1) continue;
                
                if(land_num[nx][ny] != 0)
                {
                    if(land_num[nx][ny] != cur.F)
                    {
                        answer = min(answer,dp[cur.S.F][cur.S.S]);
                    }
                }
                if(board[nx][ny] == 1) continue;
                
                dp[nx][ny] = dp[cur.S.F][cur.S.S] + 1;
                sub_Q.push({cur.F,{nx,ny}});
                vis[nx][ny] = 1;
                
            }
        }
        //see();
        vis_dp_reset();
    }
}

int main()
{
    cin >> N;
    
    for(int i=0; i<N; i++)
    {
        for(int k=0; k<N; k++)
        {
            cin >> board[i][k];
        }
    }
    
    land();
    find();
    bfs();
    //see();
    
    cout << answer << endl;
    
}