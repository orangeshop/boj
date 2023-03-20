#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
#include <tuple>
using namespace std;

vector<int> adj[100];
bool vis[100];
int n=0;
int m=0;

int main()
{
    cin >> n;
    cin >> m;
    
    for(int i=0; i<m; i++)
    {
        int a=0;
        int b=0;
        
        cin >> a >> b;
        
        adj[a].push_back(b);
        adj[b].push_back(a);
        
    }
    
   

    queue<int> Q;
    Q.push(1);
    vis[1]=1;
    int cnt =0;
    
    while(!Q.empty())
    {
        int cur = Q.front();
        Q.pop();
        //cout << cur << " ";
        for(auto nxt : adj[cur])
        {
            if(vis[nxt]==1) continue;
            Q.push(nxt);
            vis[nxt] = true;
            cnt++;
        }
    }
    
  
    cout << cnt << endl;
    
    
    
}