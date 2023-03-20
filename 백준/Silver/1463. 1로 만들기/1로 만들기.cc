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


int n;
int dp[10000001];

int main(){
    cin >> n;
    
    
    memset(dp,10000,sizeof(int)*10000001);
    dp[n] = 0;
    for(int i=n; i>=1; i--)
    {
        
        
        if(i % 3 == 0)
        {
            dp[i/3] = min(dp[i]+1,dp[i/3]);
            
        }
        
        if(i % 2 == 0)
        {
            dp[i/2] = min(dp[i]+1,dp[i/2]);
            
        }
        
        dp[i-1] = min(dp[i]+1,dp[i-1]);
        
        
    }

    cout << dp[1] << endl;

}