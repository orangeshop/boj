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

long long dp[105][21];
int board[105];
int n;

int main()
{
    cin >> n;
    
    for(int i=0; i<n; i++)
    {
        cin >> board[i];
    }
    
    dp[0][board[0]] = 1;
    
    
    for(int i=1; i<n-1; i++)
    {
        
        for(int k=0; k<=20; k++)
        {
            if(dp[i-1][k-board[i]] != 0)
            {
                if(k-board[i] < 0)
                {
                    
                }else
                {
                    //cout <<"up : "<< k-board[i] << endl;
                    //dp[i][k] = max(dp[i][k], dp[i-1][k-board[i]]);
                    dp[i][k] += dp[i-1][k-board[i]];
                }
                
            }
            if(dp[i-1][k +board[i]] != 0)
            {
                if(k+board[i] > 20)
                {
                    
                }else{
                    //cout <<"down : "<< k+board[i] << endl;
                    //dp[i][k] = max(dp[i][k], dp[i-1][k+board[i]]+1);
                    dp[i][k] += dp[i-1][k+board[i]];
                }
            }
        }
    }
 
 
    cout << dp[n-2][board[n-1]] << endl;
}