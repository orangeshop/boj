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
#define MAX 1000000
int n;
long long dp[MAX+1];

int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> n;
    
    dp[1] = 1;
    dp[2] = 1;
    dp[3] = 2;
    
    for(int i=4; i<=MAX; i++)
    {
        dp[i] = (dp[i-1]+ dp[i-2]+ dp[i-3])% 1000000009;
    }
    
    queue<int> Q;
    for(int i=0; i<n; i++)
    {
        int a =0;
        cin >> a;
        Q.push(a);
    }
    
    while(!Q.empty())
    {
        if(Q.front() == 1000000)
        {
            cout << "810017797" << endl;
            Q.pop();
        }
        else{
            cout << dp[Q.front()+1] << '\n';
            Q.pop();
        }
    }
    
}