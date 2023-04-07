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
#define S second
#define F first
#define l long
#define MAX 0x7ffffff
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int ddx[8] = {-1,-2,-2,-1,1,2,2,1};
int ddy[8] = {-2,-1,1,2,-2,-1,1,2};

//cin.tie(NULL);
//ios::sync_with_stdio(false);
long long dp[1005][10];
int n;

int main()
{
    cin >> n;
    
    for(int i=0; i<10; i++)
    {
        dp[0][i] = 1;
    }
    
    for(int i=1; i<n; i++)
    {
        for(int k=0; k<10; k++)
        {
            int a=0;
            if(k-1 < 0)
            {
                a = 0;
            }
            else{
                a = dp[i][k-1];
            }
            dp[i][k] = (dp[i-1][k] + a) % 10007;
        }
    }

    int result =0;
    for(int i=0; i<10; i++)
    {
        result += dp[n-1][i];
        result %= 10007;
    }
    
    cout << result  << endl;
}