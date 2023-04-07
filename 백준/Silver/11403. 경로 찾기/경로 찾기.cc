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
int n;
vector<int> adj[105];
bool vis[105];
bool check[105][105];
int main()
{
    cin >> n;
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<n; k++)
        {
            int a =0;
            cin >> a;
            if(a==1)
            {
                //adj[k].push_back(i);
                adj[i].push_back(k);
            }
        }
    }
    queue<int> Q;
    
    
    
    
    for(int i=0; i<n; i++)
    {
        Q.push(i);
        //vis[i] = 1;
        while(!Q.empty())
        {
            int cur = Q.front();
            Q.pop();
            
            //cout << cur << " ";
            for(auto nxt : adj[cur])
            {
                if(vis[nxt]) continue;
                check[i][nxt] = 1;
                Q.push(nxt);
                vis[nxt] =1;
            }
        }
        
        for(int k=0; k<n; k++)
        {
            vis[k] = 0;
        }
    }
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<n; k++)
        {
            cout << check[i][k] << " ";
        }
        cout << endl;
    }
    
    
}