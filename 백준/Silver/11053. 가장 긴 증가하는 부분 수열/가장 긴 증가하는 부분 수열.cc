#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
#include <tuple>
using namespace std;


int s[1005];
int dp[1005];
int n;

int main()
{
    cin >> n;
    int num=0;
    for(int i=1; i<=n; i++)
    {
        cin >> s[i];
        if(n==1)
        {
            cout << "1";
            return 0;
        }
    }
    dp[1] = 1;
    for(int i=2; i<=n; i++)
    {
        int cnt =0;
        for(int k=i-1; k>=1; k--)
        {
            if(s[i] > s[k])
            {
                cnt = max(cnt, dp[k]);
            }
        }
        dp[i] = cnt+1;
        num = max(dp[i], num);
        
    }
  
   
    cout << num << endl;
 
}