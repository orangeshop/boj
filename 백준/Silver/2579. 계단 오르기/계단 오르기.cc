#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
#include <tuple>
using namespace std;

int dp[301][3];
int s[301];

int main()
{
    int a=0;
    cin >> a;
    
    for(int i=1; i<=a; i++)
    {
        cin >> s[i];
        if(a==1)
        {
            cout << s[1];
            return 0;
        }
        
    }
    
    dp[1][1] = s[1];
    dp[1][2] = 0;
    dp[2][1] = s[2];
    dp[2][2] = s[1] + s[2];
        
    for(int i=3; i<=a; i++)
    {
        dp[i][1] = max(dp[i-2][1], dp[i-2][2]) + s[i];
        dp[i][2] = dp[i-1][1] + s[i];
    }
    
  
    cout << max(dp[a][1], dp[a][2]);
    
    
}