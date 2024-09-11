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

int N, R, Q;

vector<int> adj[100005];
vector<int> V;
int vis[100005];
int DFS(int cur){
    vis[cur] = 1;
    
    for(int nxt : adj[cur]){
        if(vis[nxt]) continue;
        vis[cur] += DFS(nxt);
    }
    return vis[cur];
}

int main(){
    cin.tie(NULL);
        ios::sync_with_stdio(false);
    cin >> N >> R >> Q;
    
    for(int i =0; i < N-1; i++){
        int a = 0;
        int b = 0;
        
        cin >> a >> b;
        
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    
    for(int i =0; i < Q; i++){
        int a = 0;
        cin >> a;
        V.push_back(a);
    }
    
    DFS(R);
    
    for(int i =0; i < Q; i++){
        cout << vis[V[i]]<< '\n';
    }
}





