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

int n;
int board[100001];
int dp[100001];

int main()
{
    cin >> n;
    
    for(int i=0; i<n; i++)
    {
        cin >> board[i];
    }
    
    dp[0] = board[0];
    int max_num =-100000;
    for(int i=0; i<n; i++)
    {
        dp[i] = max(0,dp[i-1]) + board[i];
        max_num = max(max_num,dp[i]);
    }
    
    cout << max_num << endl;
    
}