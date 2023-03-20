
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


int board[501][501];
int dp[501][501];
int n;


int main(){
    
    cin >> n;
    
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<=i; k++)
        {
            cin >> board[i][k];
        }
    }
    
    
    dp[0][0] = board[0][0];
    
    for(int i=1; i<n; i++)
    {
        for(int k=0; k<=i; k++)
        {
            dp[i][k] = max(dp[i-1][k] + board[i][k], dp[i-1][k-1] + board[i][k]);
        }
        
    }
    
    
    int max_num = 0;
    
    for(int i=0; i<n; i++)
    {
        max_num = max(max_num,dp[n-1][i]);
    }
    
    cout << max_num << endl;
}
