#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
#include <tuple>
using namespace std;


vector<int> adj[10000];
bool vis[10000];

void dfs(int cur)
{
    vis[cur] = true;
    cout << cur << ' ';
    for(auto nxt : adj[cur]){
        if(vis[nxt]) continue;
        dfs(nxt);
    }
}


int main()
{
    
    int a=0;
    int b=0;
    int c=0;
    cin >> a>>b>> c;
    
    for(int i=0; i<b; i++)
    {
        int num_1 =0;
        int num_2 =0;
        
        cin >> num_1 >>num_2;
        
        adj[num_1].push_back(num_2);
        adj[num_2].push_back(num_1);
    }
    for(int i=0; i<b; i++)
    {
        sort(adj[i].begin() ,adj[i].end());
    }
    
    
    //dfs
    
    dfs(c);
    
    
    /*stack<int> s;
    s.push(c);
    vis[c] =true;
    
    while(!s.empty())
    {
        int cur = s.top();
        s.pop();
        
        if(vis[cur]) continue;
        vis[cur] = true;
        
        cout << cur << ' ';
        
        for(auto nxt: adj[cur]){
            if(vis[nxt]) continue;
            s.push(nxt);
            
        }
    }*/
    
    cout << endl;
    for(int i=0; i<= a; i++)
    {
        vis[i] = false;
    }
    
    // bfs
    queue<int> q;
    q.push(c);
    vis[c] =true;
    
    while(!q.empty())
    {
        int cur = q.front();
        q.pop();
        cout << cur << ' ';
        
        for(auto nxt: adj[cur]){
            if(vis[nxt]) continue;
            q.push(nxt);
            vis[nxt] = true;
        }
    }
    
    cout << endl;
}