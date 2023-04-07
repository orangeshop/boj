
#include <iostream>
#include <string>
#include<cstring>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
#include <tuple>
#include <math.h>
#include <set>
#include <map>
using namespace std;
//cin.tie(NULL);
//ios::sync_with_stdio(false);

int board[16][3];
int dp[16];
int n;

int main()
{
    cin >> n;
    
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<2; k++)
        {
            cin >> board[i][k];
        }
    }
    
    for(int i=0; i<n; i++)
    {
        dp[i+board[i][0]] = max(dp[i+board[i][0]], dp[i]+board[i][1]);
        dp[i+1] = max(dp[i+1],dp[i]);
    }
    int max_num =0;
    for(int i=0; i<n+1; i++)
    {
        max_num = max(dp[i] ,max_num);
    }
    cout << max_num << endl;
   
}