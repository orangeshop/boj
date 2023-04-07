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

//cin.tie(NULL);
//ios::sync_with_stdio(false);

int board[1005][1005];
int dp[1005][1005];
int n,m;

int main()
{
    cin >> n >> m;
    
    for(int i=1; i<=n; i++)
    {
        for(int k=1; k<=m; k++)
        {
            cin >> board[i][k];
        }
    }
    
    for(int i=1; i<=n; i++)
    {
        for(int k=1; k<=m; k++)
        {
        
            dp[i][k] = max({board[i-1][k],board[i][k-1],board[i-1][k-1]}) + board[i][k];
            board[i][k] = dp[i][k];
        }
    }
    
    
    
    cout << dp[n][m] << endl;
}