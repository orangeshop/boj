//
//  main.cpp
//  cpp
//
//  Created by 최영호 on 7/8/24.
//

#include <iostream>
#include <algorithm>
#include <stack>
#include <string>
#include <sstream>
#include <queue>
#include <set>

using namespace std;

int V, E;
int v1, v2;

vector<pair<int, int>> adj[20005];
bool vis[20005];
int d[20005];

//queue<pair<int, int>> Q;

priority_queue<pair<int,int>,vector<pair<int,int>>, greater<pair<int,int>>> Q;


void dfs(int st){
    Q.push(make_pair(0, st));
    d[st] = 0;
    
    while (!Q.empty()) {
        pair<int, int> cur = Q.top();
        Q.pop();
        if(d[cur.second] != cur.first) continue;
        for(auto nxt : adj[cur.second]){
            if(d[nxt.second] < d[cur.second] + nxt.first) continue;
            d[nxt.second] = d[cur.second] + nxt.first;
            Q.push(make_pair(d[nxt.second], nxt.second));
        }
    }
}

int main(){
    
    fill(d, d+ 20005, 1e9);
    
    cin >> V >> E;
    
    for(int i =0; i < E; i++){
        int u, v, w =0;
        cin >> u >> v >> w;
        
        adj[u].push_back(make_pair(w, v));
        adj[v].push_back(make_pair(w, u));
    }
    
    cin >> v1 >> v2;
    
    int sTOv1, sTov2, vTov, v1ToN, v2ToN = 0;
    
    dfs(1);
    sTOv1 = d[v1];
    sTov2 = d[v2];
    
    fill(d, d+ 20005, 1e9);
    
    dfs(v1);
    vTov = d[v2];
    v1ToN = d[V];
    
    
    fill(d, d+ 20005, 1e9);
    
    dfs(v2);
    v2ToN = d[V];
    
    int answer = 1e9;
    
    answer = min(sTOv1 + vTov + v2ToN, sTov2 + vTov + v1ToN);
    
    if(answer >= 1e9 || vTov >= 1e9){
        cout << "-1" << endl;
    }else{
        cout << answer << endl;
    }
    
    
    
}
