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

using namespace std;
int N, M, V;
vector<int> adj[1005];
queue<int> Q;
bool visB[1005];
vector<int> Bans;
void bfs(int c){
    Q.push(c);
    visB[c] = true;
    while(!Q.empty()){
        int cur = Q.front();
        cout << cur << " ";
        Q.pop();
        
        for(auto nxt : adj[cur]){
            if(visB[nxt] == true) continue;
            visB[nxt] = true;
            Q.push(nxt);
        }
    }
}

bool visD[1005];
stack<int> S;
vector<int> Dans;
void dfs(int cur)
{
    visD[cur] = true;
    cout << cur << ' ';
    for(auto nxt : adj[cur]){
        if(visD[nxt]) continue;
        dfs(nxt);
    }
}

int main(){
    cin >> N >> M >> V;
    
    for(int i =0; i < M; i++){
        int a = 0;
        int b = 0;
        
        cin >> a >> b;
        
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    
    for(int i =0; i <= N; i++){
        sort(adj[i].begin(), adj[i].end());
    }
     
    
    dfs(V);

    cout << endl;
    
    bfs(V);
    
    cout << endl;
    
}
