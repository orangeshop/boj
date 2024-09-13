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
#include <map>
#include <cstring>
using namespace std;

int N;
vector<int> adj[1000005];

bool vis[1000005];

int dp[1000005][2];

vector<int> v;


void dfs(int node){
    vis[node] = true;
    
    dp[node][0] = 0;
    dp[node][1] = v[node];
    
    for(int nxt : adj[node]){
        if(vis[nxt] == true) continue;
        dfs(nxt);
        dp[node][0] += max(dp[nxt][0], dp[nxt][1]);
        dp[node][1] += dp[nxt][0];
        
    }
}

int main(){
    cin >> N;
    v.push_back(0);
    for(int i =0; i < N; i++){
        int a = 0;
        cin >> a;
        
        v.push_back(a);
    }
    
    for(int i =0; i < N-1; i++){
        int a = 0;
        int b = 0;
        
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    
    dfs(1);
    
    cout << max(dp[1][0], dp[1][1]);
    
    
}
