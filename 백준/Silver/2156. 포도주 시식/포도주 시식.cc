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

int n;
int board[10005];
int dp[10005][3];

int main()
{
    cin >> n;
    
    for(int i=0; i<n; i++)
    {
        cin >> board[i];
    }
    
    dp[0][1] = board[0];
    
    for(int i=1; i<n; i++)
    {
        dp[i][0] = max({dp[i-1][0] ,dp[i-1][1]  ,dp[i-1][2]});
        dp[i][1] = dp[i-1][0] + board[i];
        dp[i][2] = dp[i-1][1] + board[i];
    }
    
    
    
    cout << max({dp[n-1][0] ,dp[n-1][1],dp[n-1][2]}) << endl;
    
    
}