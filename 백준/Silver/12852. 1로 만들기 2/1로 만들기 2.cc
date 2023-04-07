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

int dp[1000001];
int pre[10000001];
int n;

int main()
{
    cin >> n;
    memset(dp,10000,sizeof(int)*1000001);
    dp[1] = 0;
    //dp[10] = 0
    //
    for(int i=2; i<= n; i++)
    {
        dp[i] = min(dp[i],dp[i-1] + 1);
        pre[i] = i-1;
        
        if(i%3 ==0 && dp[i] > dp[i/3])
        {
            dp[i] = min(dp[i], dp[i/3] + 1);
            pre[i] = i/3;
        }
        
        if(i%2 ==0 && dp[i] > dp[i/2])
        {
            dp[i] = min(dp[i],dp[i/2] + 1);
            pre[i] = i/2;
        }
        
        
    }
    cout << dp[n] << endl;
    int cur =n;
    while(true)
    {
        cout << cur << " ";
        if(cur == 1) break;
        cur = pre[cur];
    }
}