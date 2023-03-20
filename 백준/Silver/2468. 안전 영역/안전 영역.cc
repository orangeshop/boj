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
int max_result =1;
int n;
int board[105][105];
int dp[105][105];
bool vis[105][105];
void see()
{
    //cout << "-------------" << endl;
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<n; k++)
        {
            //cout << vis[i][k] << " ";
            //cout << dp[i][k] << " ";
            max_result = max(max_result,dp[i][k]);
            dp[i][k] = 0;
            vis[i][k] = 0;
        }
        //cout << endl;
    }
}
int main()
{
    cin >> n;
    int max_cunt =0;
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<n; k++)
        {
            cin >> board[i][k];
            if(board[i][k] > max_cunt)
            {
                max_cunt = board[i][k];
            }
        }
    }
    
    queue<pair<int,int>> Q;
    
    for(int i=1; i<max_cunt; i++)
    {
        for(int j=0; j<n; j++)
        {
            for(int k=0; k<n; k++)
            {
                if(i>=board[j][k])
                {
                    vis[j][k] = 1;
                }
            }
        }
        int check = 1;
        
        for(int j=0; j<n; j++)
        {
            for(int k=0; k<n; k++)
            {
                if(vis[j][k] == 1) continue;
                
                Q.push(make_pair(j, k));
                vis[j][k] = 1;
                dp[j][k] = check;
                while(!Q.empty())
                {
                    
                    pair<int,int> cur = Q.front(); Q.pop();
                    for(int dir =0; dir<4; dir++)
                    {
                        int nx = dx[dir] + cur.F;
                        int ny = dy[dir] + cur.S;
                        
                        if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                        if(vis[nx][ny] == 1) continue;
                        dp[nx][ny] = check;
                        vis[nx][ny] = 1;
                        Q.push(make_pair(nx, ny));
                    }
                    
                }
                check++;
            }
        }
        see();
    }
    
    cout << max_result << endl;
}