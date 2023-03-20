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

int board[35];
int dp[35];
int n;
int main()
{
    cin >> n;
    
    dp[0] = 1;
    dp[2] = 3;
    
    for(int i=4; i<31; i+=2)
    {
        dp[i] = (dp[i-2]*4) - dp[i-4];
    }
    
    cout << dp[n] << endl;
}