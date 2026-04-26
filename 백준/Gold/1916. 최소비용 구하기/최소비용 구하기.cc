#include <iostream>
#include <string>
#include<cstring>
#include <vector>
#include <stack>
#include <memory.h>
#include <algorithm>
#include <queue>
#include <tuple>
#include <math.h>
#include <set>
#include <map>
using namespace std;
#define S second
#define F first
#define l long
#define MAX 0x7ffffff
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int ddx[8] = {-1,-2,-2,-1,1,2,2,1};
int ddy[8] = {-2,-1,1,2,-2,-1,1,2};

int N,M;
vector<pair<int,int>> adj[200005];
int d[200005];
const int INF = 0x3f3f3f3f;
int st,en;

int main(){
    
    cin >> N >> M;
    
    for(int i =0; i< M; i++){
        int u = 0;
        int v = 0;
        int w = 0;
        
        cin >> u >> v>> w;
        
        adj[u].push_back(make_pair(w, v));
    }
    
    
    cin >> st >> en;
    
    
    fill(d, d+N+1, INF);
    
    priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
    
    d[st] = 0;
    
    pq.push(make_pair(d[st], st));
    
    while(!pq.empty()){
        pair cur = pq.top(); pq.pop();
        
        if(d[cur.second] != cur.first) continue;
        
        for(auto nxt : adj[cur.second]){
            if(d[nxt.second] <= d[cur.second] + nxt.first) continue;
            
            d[nxt.second] = d[cur.second] + nxt.first;
            pq.push(make_pair(d[nxt.second], nxt.second));
        }
    }
    
    
//    for(int i=st; i<=en; i++){
//        cout << d[i] << endl;
//    }
    
    cout << d[en] << endl;
    
}
