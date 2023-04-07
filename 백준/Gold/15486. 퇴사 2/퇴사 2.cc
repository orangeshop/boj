
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
#define MAX 1500000
int n;
int table_t[MAX+1];
int table_p[MAX+1];
int dp[MAX+1];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> n;
    
    for(int i=0; i<n; i++)
    {
        cin >> table_t[i] >> table_p[i];
    }
    
    //dp[i] = 총 금액
    // i = 요일
    for(int i=0; i<n; i++)
    {
        dp[i+table_t[i]] = max(dp[i+table_t[i]],dp[i] +table_p[i]);
        dp[i+1] = max(dp[i+1],dp[i]);
    }
    int max_num =0;
    for(int i=0; i<=n; i++)
    {
        max_num = max(dp[i],max_num);
    }
    
    cout << max_num << '\n';
    
}