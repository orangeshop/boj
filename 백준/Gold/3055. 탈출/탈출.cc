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
int n,m;
char board[55][55];
bool vis[55][55];
int dp[55][55];
queue<pair<int,pair<int,int>>> Q;
int stx,sty;
int bbx,bby;
int main()
{
    cin >> n >> m;
    
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            cin >> board[i][k];
            
            if(board[i][k] == 'X')
            {
                vis[i][k] = 1;
            }
            
            if(board[i][k] == '*')
            {
                Q.push({'W',{i,k}});
                vis[i][k] = 1;
                dp[i][k] = 1;
            }
            
            if(board[i][k] == 'S')
            {
                stx = i;
                sty = k;
                vis[i][k] = 1;
            }
            
            if(board[i][k] == 'D')
            {
                bbx = i;
                bby =k;
            }
        }
    }
    
    Q.push({'S',{stx,sty}});
    
    while(!Q.empty())
    {
        pair<int,pair<int,int>> cur = Q.front();
        Q.pop();
        
        for(int dir =0; dir<4; dir++)
        {
            int nx = dx[dir] + cur.S.F;
            int ny = dy[dir] + cur.S.S;
            
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(board[nx][ny] == 'X' || vis[nx][ny] == 1) continue;
            if(cur.F == 'W' && nx == bbx && ny == bby) continue;
            if(cur.F == 'S')
            {
                dp[nx][ny] = dp[cur.S.F][cur.S.S] + 1;
            }
            
            Q.push({cur.F,{nx,ny}});
            vis[nx][ny] = 1;
            
        }
    }
    
    
    
    if(dp[bbx][bby] == 0)
    {
        cout << "KAKTUS" << endl;
    }
    else{
        cout << dp[bbx][bby] << endl;
    }
    
    
}