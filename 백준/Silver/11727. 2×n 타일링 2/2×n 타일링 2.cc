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

int dp[1001];
int n;
int main()
{
    cin >> n;
    
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 3;
    dp[3] = 5;
    
    for(int i=4; i<=n; i++)
    {
        dp[i] = dp[i-1] + dp[i-2] + dp[i-2];
        dp[i] %= 10007;
    }
    
    cout << dp[n] << endl;
    
}