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

int dp[205][205];

void see()
{
    for(int i=1; i<=m; i++)
    {
        for(int k=1; k<=n; k++)
        {
            cout << dp[i][k] << " ";
        }
        cout << endl;
    }
}

int main()
{
    cin >> n >> m;
    
    for(int i=1; i<=m; i++)
    {
        for(int k=1; k<=n; k++)
        {
            dp[i][k] = 1;
            if(k==1)
            {
                dp[i][k] = i;
            }
        }
    }
    
    for(int i=2; i<=m; i++)
    {
        for(int k=2; k<=n; k++)
        {
            dp[i][k] = dp[i-1][k] + dp[i][k-1];
            dp[i][k] %= 1000000000;
        }
    }
    
    //see();
    
    cout << dp[m][n] << endl;
}
