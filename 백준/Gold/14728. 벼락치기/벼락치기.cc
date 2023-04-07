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
int n,m;
int dp[105][10005];
queue<pair<int,int>> Q;

void see()
{
    for(int i=0; i<=n; i++)
    {
        for(int k=0; k<=m; k++)
        {
            cout << dp[i][k] << " ";
        }
        cout << endl;
    }
}
int main()
{
    cin >> n >> m;
    
    for(int i=0; i<n; i++)
    {
        int a =0;
        int b= 0;
        
        cin >> a >> b;
        
        Q.push({a,b});
    }
    
    for(int i=1; i<n+1; i++)
    {
        for(int k=0; k<=m; k++)
        {
            if(k-Q.front().F >= 0)
            {
                dp[i][k] = max(dp[i-1][k],dp[i-1][k-Q.front().F] + Q.front().S);
            }
            else if(dp[i][k] ==0 && dp[i-1][k] != 0)
            {
                dp[i][k] = dp[i-1][k];
            }
        }
        Q.pop();
    }
    
    //see();
    
    
    cout << dp[n][m] << endl;
    return 0;
}