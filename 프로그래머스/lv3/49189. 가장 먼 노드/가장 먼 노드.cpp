#include <string>
#include <vector>
#include <queue>
#include <iostream>
#include <algorithm>
using namespace std;

vector<int> adj[20005];
bool vis[20005];
int check[20005];
int solution(int n, vector<vector<int>> edge) {
    int answer = 0;
    
    for(int i=0; i<edge.size(); i++){
        // cout << edge[i][0] << " " << edge[i][1] << endl;   
        adj[edge[i][0]].push_back(edge[i][1]);
        adj[edge[i][1]].push_back(edge[i][0]);
    }
    
    for(int i=1; i<=n; i++){
        for(int k =0; k< adj[i].size(); k++){
            // cout << "i : " << i << " "<<adj[i][k] << endl;
        }
    }
    
    queue<pair<int,int>> Q;
    
    
    Q.push({0, 1}); // check , start point
    vis[1] = true;
    
    int check_num = 0;
    
    while(!Q.empty()){
        
        pair<int,int> cur = Q.front();
        Q.pop();
        
        // cout << "Q first : " << cur.first << " " << "Q second : " << cur.second << endl;
        
        check[cur.second] = cur.first;
        check_num = max(check_num, cur.first);
        
        for(auto nxt : adj[cur.second]){
            if(vis[nxt] == true) continue;
            
            Q.push({cur.first + 1 , nxt});
            vis[nxt] = true;
            
        }
    }
    
    for(int i=0; i<=n; i++){
        // cout << check[i] << endl;
        if(check[i] == check_num){
            answer+=1;
        }
    }
    
    
    return answer;
}