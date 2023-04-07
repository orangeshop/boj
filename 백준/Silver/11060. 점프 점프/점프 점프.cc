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

int n;
int dp[1001];
int board[1001];

int main(){
    
    cin >> n;
    
    for(int i=0; i<n; i++)
    {
        cin >> board[i];
        dp[i] = 1001;
    }
    dp[0] = 0;
    for(int i=0; i<n; i++)
    {
        for(int k=1; k<=board[i]; k++)
        {
            if(board[i] == 0) break;
            dp[i+k] = min(dp[i+k],dp[i]+1);
            
        }
        
    }
    
    
    if(dp[n-1]==1001)
    {
        cout << "-1" << endl;
    }
    else{
        cout << dp[n-1] << endl;
    }
}