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
int n,m;
vector<int> adj[5005];
bool vis[5005];
int arr[105][5005];
int result[105];
int main()
{
    cin >> n >> m;
    
    for(int i=0; i<m; i++)
    {
        int a =0;
        int b =0;
        
        cin >> a >> b;
        
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    queue<pair<int,int>> Q;
    
    for(int i=1; i<=n; i++)
    {
        Q.push({i,0});
        vis[i]=1;
        int cnt = 1;
        while(!Q.empty())
        {
            pair<int,int> cur = Q.front();
            Q.pop();
            for(auto nxt : adj[cur.F])
            {
                if(vis[nxt]) continue;
                result[i] += cnt;
                Q.push({nxt,cur.S +1});
                
                vis[nxt] = 1;
            }
            if(Q.front().S > cur.S)
            {
                cnt++;
            }
        }
        
        for(int k=1; k<=n; k++)
        {
            vis[k] = 0;
        }
    }
    
   
    int find_max = MAX;
    for(int i=1; i<=n; i++)
    {
        find_max = min(result[i],find_max);
    }
    for(int i=1; i<=n; i++)
    {
        if(find_max == result[i])
        {
            cout << i << endl;
            break;
        }
    }
    
}