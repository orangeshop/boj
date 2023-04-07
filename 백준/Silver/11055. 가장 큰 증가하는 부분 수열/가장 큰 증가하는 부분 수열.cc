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
#define MAX 0x7fffffff
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
//cin.tie(NULL);
//ios::sync_with_stdio(false);

int board[1005];
int dp[1005];
int n;

int main()
{
    cin >> n;
    
    for(int i=0; i<n; i++)
    {
        cin >> board[i];
        dp[i] = board[i];
    }
    
    for(int i=0; i<n-1; i++)
    {
        for(int k=i+1; k<n; k++)
        {
            if(board[i] >= board[k]) continue;
            dp[k] = max(dp[i]+board[k], dp[k]);
        }
    }
    int result =0;
    for(int i=0; i<n; i++)
    {
        result = max(result,dp[i]);
    }
    
    cout << result << endl;
}