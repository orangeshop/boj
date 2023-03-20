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

int board[3][4];
int max_dp[3][4];
int min_dp[3][4];
int n;

int main(){
    cin >> n;
    
    for(int i=0; i<n; i++)
    {
        if(i==0)
        {
            cin >> max_dp[0][0] >> max_dp[0][1] >> max_dp[0][2];
            min_dp[0][0] = max_dp[0][0];
            min_dp[0][1] = max_dp[0][1];
            min_dp[0][2] = max_dp[0][2];
            continue;
        }
        
        cin >> board[1][0] >> board[1][1] >> board[1][2];
        
        max_dp[1][0] = max(max_dp[0][0] + board[1][0] , max_dp[0][1] + board[1][0]);
        
        max_dp[1][1] = max({max_dp[0][0]+board[1][1],max_dp[0][1]+board[1][1],max_dp[0][2]+board[1][1]});
        max_dp[1][2] = max(max_dp[0][1] + board[1][2] , max_dp[0][2] + board[1][2]);
        
        max_dp[0][0] = max_dp[1][0];
        max_dp[0][1] = max_dp[1][1];
        max_dp[0][2] = max_dp[1][2];
       
        
        
        min_dp[1][0] = min(min_dp[0][0] + board[1][0] , min_dp[0][1] + board[1][0]);
        min_dp[1][1] = min({min_dp[0][0]+board[1][1],min_dp[0][1]+board[1][1],min_dp[0][2]+board[1][1]});
        min_dp[1][2] = min(min_dp[0][1] + board[1][2] , min_dp[0][2] + board[1][2]);
        
        min_dp[0][0] =min_dp[1][0];
        min_dp[0][1] =min_dp[1][1];
        min_dp[0][2] =min_dp[1][2];
        
        
    }
    
    int max_num = 0;
    for(int k=0; k<3; k++)
    {
        max_num = max(max_num, max_dp[0][k]);
    }
   
    int min_num =10000;
    for(int k=0; k<3; k++)
    {
        min_num = min(min_num, min_dp[0][k]);
    }
    cout <<max_num<<" "<<min({min_dp[0][0],min_dp[0][1],min_dp[0][2]})<< endl;
}
