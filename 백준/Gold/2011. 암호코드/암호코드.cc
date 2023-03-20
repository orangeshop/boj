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

int board[5005];
long long dp[5005][30];

int main()
{
    string str ="";
    cin >> str;
    
    int n = 0;
    n = str.size();
    for(int i=0; i<n; i++)
    {
        board[i] = str[i]-48;
    }
    //121074110
    dp[0][board[0]] = 1;
    
    for(int i=1; i<=n; i++)
    {
        int temp = 0;
        for(int k=1; k<27; k++)
        {
            temp += dp[i-1][k];
            temp %= 1000000;
        }
        dp[i][board[i]] = temp;
        
        if(board[i-1]==0)
        {
            continue;
        }
        if(board[i-1]*10 + board[i] < 27)
        {
            dp[i][board[i-1]*10 + board[i]] = dp[i-1][board[i-1]] % 1000000;
        }
    }
    

    int result =0;
    for(int i=1; i<27; i++)
    {
        result += dp[n-1][i];
        result %= 1000000;
    }
    
    cout << result << endl;
    
}