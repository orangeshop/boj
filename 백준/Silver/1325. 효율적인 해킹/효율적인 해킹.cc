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

int n, m;
vector<int> adj[10005];
bool vis[10005];
int check[10005];
int main()
{
    cin >> n >> m;
    
    for(int i=0; i<m; i++)
    {
        int a =0;
        int b =0;
        
        cin >> a >> b;
        
        //adj[a].push_back(b);
        adj[b].push_back(a);
        
    }
    
    queue<int> Q;
    for(int i=1; i<=n; i++)
    {
        int count =0;
        Q.push(i);
        vis[i] = 1;
        while(!Q.empty())
        {
            int cur = Q.front();
            Q.pop();
            
            for(auto nxt : adj[cur])
            {
                if(vis[nxt]) continue;
                count++;
                Q.push(nxt);
                vis[nxt] = 1;
            }
        }
        check[i] = count;
        for(int i=1; i<=n; i++)
        {
            vis[i] = 0;
        }
    }
    
    int find_max =0;
    for(int i=1; i<=n; i++)
    {
        find_max = max(find_max, check[i]);
        //cout << check[i] << endl;
    }
    
    queue<int> R;
    
    for(int i=1; i<=n; i++)
    {
        if(find_max == check[i])
        {
            R.push(i);
        }
        
    }
    
    while(!R.empty())
    {
        cout << R.front();
        R.pop();
        if(R.size() != 0)
        {
            cout << " ";
        }
    }
    
    
}