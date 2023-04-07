#include <iostream>
#include <string>
#include <cstring>
#include <vector>
#include <stack>
#include <memory.h>
#include <algorithm>
#include <queue>
#include <tuple>
#include <math.h>
#include <list>
#include <set>
#include <map>
#include <iterator>

using namespace std;
#define S second
#define F first
#define l long
#define MAX 0x7ffffff
int dx[4] = {-1,0,1,0};
int dy[4] = {0,1,0,-1};
int ddx[8] = {-1,-2,-2,-1,1,2,2,1};
int ddy[8] = {-2,-1,1,2,-2,-1,1,2};
int cdx[8] = {-1,0,1,0,-1,-1,1,1};
int cdy[8] = {0,1,0,-1,-1,1,1,-1};

//cin.tie(NULL);
//ios::sync_with_stdio(false);
//cout.tie(NULL);
int T,N,M;
l l dp[100005];
l l clac(queue<int> &Q)
{
    while(!Q.empty())
    {
        dp[Q.front()] +=1;
        for(int i= Q.front()+1; i<=M; i++)
        {
            if(dp[i-Q.front()] >= 0)
            {
                dp[i] += dp[i-Q.front()];
            }
        }
//        for(int i=1; i<= M; i++)
//        {
//            cout << dp[i] << " ";
//        }
//        cout << endl;
        
        Q.pop();
    }
    
    
    return dp[M];
}


int main()
{
    queue<int> Q;
    cin >> T;
    queue<l l> result;
    for(int i=0; i<T; i++)
    {
        cin >> N;
        for(int k=0; k<N; k++)
        {
            int a =0;
            cin >> a;
            Q.push(a);
        }
        cin >> M;
        result.push(clac(Q));
        
        //memset(dp,0,sizeof(10005));
        
        for(int k=0; k<=10005; k++)
        {
            dp[k] = 0;
        }
    }
    
    while(!result.empty())
    {
        cout << result.front() << endl;
        result.pop();
    }
    
    
}