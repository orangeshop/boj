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
int board[505][505];
int dp[505][505];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int n,m;

int main()
{
    vector<pair<int,pair<int,int>>> V;
    cin >> n >> m;
    //memset(dp,-1, 505*(505 * sizeof(int)));
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            cin >> board[i][k];
            V.push_back({board[i][k], pair(i,k)});
        }
    }
    dp[0][0] = 1;
    sort(V.rbegin(),V.rend());
    
    for(int i=0; i< n*m; i++)
    {
        
        for(int dir =0; dir<4; dir++)
        {
            int nx = dx[dir] + V[i].second.first;
            int ny = dy[dir] + V[i].second.second;
            
            
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(board[V[i].second.first][V[i].second.second] <= board[nx][ny]) continue;
            
            dp[nx][ny] += dp[V[i].second.first][V[i].second.second];
        }
    }
    
    cout << dp[n-1][m-1] << endl;
}