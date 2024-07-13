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
int N, M;

priority_queue<int, vector<int>, greater<int>> pq;
vector<int> adj [32005];
int degree[32005];
vector<int> answer;
int main(){
    cin >> N >> M;
    
    for(int i =0; i < M; i++){
        int a = 0;
        int b = 0;
        cin >> a >> b;
        adj[a].push_back(b);
        degree[b]++;
    }
    
    
    
    for(int i = 1; i<= N; i++){
        if(degree[i] == 0){
            pq.push(i);
        }
    }
    
    while(!pq.empty()){
        int cur = pq.top();
        pq.pop();
//        cout << cur << endl;
        answer.push_back(cur);
        for(auto nxt: adj[cur]){
            
            degree[nxt]--;
            if(degree[nxt] == 0){
                pq.push(nxt);
            }
        }
    }
    
    for(int i =0; i < answer.size(); i++){
        cout << answer[i] << " ";
    }
    
    
}

