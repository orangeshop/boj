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


int n,m;
int arr[100005];
int dp[100005];
int s[100005];
int e[100005];

int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> n >> m;
    
    for(int i=0; i<n; i++)
    {
        cin >> arr[i];
    }
    for(int i=0; i< m; i++)
    {
        cin >> s[i] >> e[i];
    }
    
    dp[0] = arr[0];
    for(int i=1; i<n; i++)
    {
        dp[i] = dp[i-1] + arr[i];
    }
    
    
    
    for(int i=0; i<m; i++)
    {
        
        cout <<  dp[e[i]-1] - dp[s[i]-2] << "\n";
    }
}