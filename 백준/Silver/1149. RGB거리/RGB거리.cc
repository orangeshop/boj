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


int board[1001][4];
int dp[1001][4];
int n;


int main(){
    
    cin >> n;
    
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<3; k++)
        {
            cin >> board[i][k];
        }
    }
    
    dp[0][0] = board[0][0];
    dp[0][1] = board[0][1];
    dp[0][2] = board[0][2];
    
    
    for(int i=1; i<n; i++)
    {
        
        dp[i][0] = min(dp[i-1][1] + board[i][0] , dp[i-1][2] + board[i][0]);
        dp[i][1] = min(dp[i-1][0] + board[i][1] , dp[i-1][2] + board[i][1]);
        dp[i][2] = min(dp[i-1][0] + board[i][2] , dp[i-1][1] + board[i][2]);
    }
    int number = 0;
    number = min(dp[n-1][0],dp[n-1][1]);
    
    cout << min(number,dp[n-1][2]);
}