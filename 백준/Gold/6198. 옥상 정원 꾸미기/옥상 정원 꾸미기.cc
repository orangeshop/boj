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
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
//cin.tie(NULL);
//ios::sync_with_stdio(false);

int n;
long long board[80005];
long long dp[80005];
stack<pair<long long,long long>> S;

int main()
{
    cin >> n;
    
    for(int i=0; i<n; i++)
    {
        cin >> board[i];
    }
    S.push(make_pair(board[0],0));
    for(int i=1; i<n; i++)
    {
        
        if(S.top().F <= board[i])
        {
            while(!S.empty())
            {
                if(S.top().F > board[i]) break;
                long long check = S.top().S;
                S.pop();
                if(S.size() == 0)break;
                
                if(board[S.top().S] == board[check])
                {
                    dp[S.top().S] += dp[check] + 1;
                    dp[check] = 0;
                }
                else{
                    dp[S.top().S] += dp[check] + 1;
                }
                
            }
            S.push(make_pair(board[i], i));
        }
        
        if(S.top().F > board[i])
        {
            S.push(make_pair(board[i], i));
        }
    }
    
    long long result =0;
    
    while(!S.empty())
    {
        long long check = S.top().S;
        S.pop();
        if(S.size() == 0)break;
        
        if(board[S.top().S] == board[check])
        {
            dp[S.top().S] += dp[check] + 1;
            dp[check] = 0;
        }
        else{
            dp[S.top().S] += dp[check] + 1;
        }
    }
    for(int i=0; i<n; i++)
    {
        //cout << dp[i] << " ";
        result += dp[i];
    }
    
    cout << result << endl;

}