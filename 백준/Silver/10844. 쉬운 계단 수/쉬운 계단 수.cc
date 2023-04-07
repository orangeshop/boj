#include <iostream>
#include <string>
#include <cstring>
#include <vector>
#include <stack>
#include <memory.h>
#include <algorithm>
#include <queue>
#include <tuple>
#include <math.h>
#include <list>
#include <set>
#include <map>
#include <iterator>

using namespace std;
#define S second
#define F first
#define l long
#define MAX 0x7ffffff
int dx[4] = {-1,0,1,0};
int dy[4] = {0,1,0,-1};
int ddx[8] = {-1,-2,-2,-1,1,2,2,1};
int ddy[8] = {-2,-1,1,2,-2,-1,1,2};
int cdx[8] = {-1,0,1,0,-1,-1,1,1};
int cdy[8] = {0,1,0,-1,-1,1,1,-1};

//cin.tie(NULL);
//ios::sync_with_stdio(false);
//cout.tie(NULL);

int n;
long long dp[104][11];
int main()
{
    cin >> n;
    
    
    for(int i=0; i<10; i++)
    {
        dp[1][i] = 1;
    }
    dp[1][0] =0;
    
    for(int i= 2; i<=n; i++)
    {
        for(int k=0; k<10; k++)
        {
            if(k==0)
            {
                dp[i][0] = dp[i-1][1]% 1000000000;
                continue;
            }
            else if(k==9)
            {
                dp[i][9] = dp[i-1][8]% 1000000000;
                continue;
            }
            dp[i][k] = (dp[i-1][k-1] + dp[i-1][k+1]) % 1000000000;
        }
    }
    
    long long sum=0;
    for(int k=0; k<10; k++)
    {
        sum += dp[n][k];
    }
    
    cout << sum% 1000000000 << endl;
    
}