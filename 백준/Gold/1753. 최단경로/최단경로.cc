
#include <iostream>
#include <string>
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

vector<pair<int,int>> adj[20005];
int d[20005];
const int INF = 0x3f3f3f3f;



int main()
{
    int e = 0;
    int v = 0;
    int st = 0;
    
    cin >> v >> e >> st;
    
    fill(d,d+v+1,INF);
    
    while(e--)
    {
        int u = 0;
        int v = 0;
        int w = 0;
        cin >> u >> v >> w;
        adj[u].push_back({w,v});
    }
    
    priority_queue<pair<int,int>,vector<pair<int,int>> , greater<pair<int,int>>> pq;
    d[st] = 0;
    pq.push({d[st],st});
    
    while(!pq.empty())
    {
        auto cur = pq.top(); pq.pop();
        if(d[cur.second] != cur.first) continue;
        for(auto nxt : adj[cur.second])
        {
            if(d[nxt.second] <= d[cur.second] + nxt.first) continue;
            
            d[nxt.second] = d[cur.second] + nxt.first;
            pq.push({d[nxt.second],nxt.second});
        }
        
    }
    
    for(int i=1; i<= v; i++)
    {
        if(d[i]==INF) cout << "INF\n";
        else  cout << d[i] << "\n";
        
    }
    
}