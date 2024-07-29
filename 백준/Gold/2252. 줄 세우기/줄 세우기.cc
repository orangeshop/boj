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

int N, M;
vector<int> adj[40000];
int indegree[40000];

queue<int> Q;

int main(){
    cin >> N >> M;
    
    for(int i =0; i < M; i++){
        int a = 0;
        int b = 0;
        
        cin >> a >> b;
        
        adj[a].push_back(b);
        indegree[b]++;
    }
    
    for(int i =1; i <= N; i++){
        if(indegree[i] == 0){
            Q.push(i);
        }
    }
    
    while(!Q.empty()){
        int cur = Q.front();
        Q.pop();
        cout << cur << ' ';
        for(auto nxt: adj[cur]){
            indegree[nxt]--;
            if(indegree[nxt] == 0){
                Q.push(nxt);
            }
        }
    }
}
