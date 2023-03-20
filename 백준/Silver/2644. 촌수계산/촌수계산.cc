
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
int x,y;
int m;
vector<int> adj[104];
queue<pair<int,int>> Q;
bool vis[104];
int main()
{
    cin >> n;
    
    cin >> x >> y;
    
    cin >> m;
    
    
    for(int i=0; i<m; i++)
    {
        int a =0;
        int b =0;
        
        cin >> a >> b;
        
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    Q.push({x,0});
    vis[x] = 1;
    
    
    while(!Q.empty())
    {
        pair<int,int> cur = Q.front();
        //cout << cur.first << " " << cur.second << endl;
        
        if(cur.first == y)
        {
            cout << cur.second << endl;
            return 0;
        }
        
        Q.pop();
        for(auto nxt : adj[cur.first])
        {
            if(vis[nxt] == 1) continue;
            //cout << nxt << endl;
            
            
            Q.push({nxt,cur.second+1});
            vis[nxt] = 1;
        }
        
       
        
        
    }
    
    cout << "-1" << endl;
    
}
