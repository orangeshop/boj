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

int T;
int N, M, K;
int W;
vector<int> adj[40000];
int indegree[40000];

int board[40000];
int d[40000];

queue<int> Q;

int main(){
    cin >> T;
    
    for(int i =0; i < T; i++){
        cin >> N >> K;
        
        for(int i =0; i < 1005; i++){
            adj[i].clear();
            d[i] = 0;
        }
        
        for(int i = 1; i <= N; i++){
            cin >> board[i];
        }
        
        
        for(int i =0; i < K; i++){
            int a = 0;
            int b = 0;
            
            cin >> a >> b;
            
            adj[a].push_back(b);
            indegree[b]++;
        }
        
        cin >> W;
        
        for(int i =1; i <= N; i++){
            if(indegree[i] == 0){
                Q.push(i);
            }
            d[i] = board[i];
        }
        
        while(!Q.empty()){
            int cur = Q.front();
            Q.pop();
            
            for(auto nxt: adj[cur]){
                indegree[nxt]--;
                d[nxt] = max(d[nxt], d[cur] + board[nxt]);
                
                if(indegree[nxt] == 0){
                    Q.push(nxt);
                }
            }
        }
        
        
        
        cout << d[W] << endl;
    }
}
