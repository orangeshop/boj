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


char board[1005][1005];
int dp[1005][1005];
int n,m;
int max_num;
void see_1()
{
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            cout <<  board[i][k] << " ";
        }
        cout << endl;
    }
}
/*5 5
11100
11110
11111
01111
00111*/
void see_2()
{
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            //cout <<  dp[i][k] << " ";
            max_num = max(max_num,dp[i][k]);
        }
        //cout << endl;
    }
    
    cout << max_num * max_num << endl;
}
int main()
{
    cin >> n >> m;
    
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            cin >> board[i][k];
            if(board[i][k] == '1')
            {
                dp[i][k] = 1;
            }
        }
    }
    
    
    
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            if(board[i][k] != '1') continue;
            
            if(board[i-1][k] == '1' && board[i][k-1] == '1'  && board[i-1][k-1] == '1')
            {
                dp[i][k] = min({dp[i-1][k],dp[i][k-1],dp[i-1][k-1]}) + 1;
            }
            
        }
    }
    
    see_2();
    
    
    
}