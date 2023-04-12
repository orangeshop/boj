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

int N,E;

vector<pair<int,int>> adj[900];
long d[900];
vector<int> target;
const int INF = 0x3f3f3f3f;

int v1, v2;
bool v1_check, v2_check;

priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;

void Dijkstra(int st){
    
    d[st] = 0;
    pq.push({d[st], st});
    
    while(!pq.empty()){
        pair<int,int> cur = pq.top();
        pq.pop();
        
        if(d[cur.second] != cur.first) continue;
        for(auto nxt : adj[cur.second]){
            if(d[nxt.second] <= d[cur.second] + nxt.first) continue;
            
            d[nxt.second] = d[cur.second] + nxt.first;
            
            pq.push({d[nxt.second], nxt.second});
        }
    }
    
    
//    for(int i=1; i<=N; i++){
//        cout << d[i] << endl;
//    }
//    cout << "--------------" << endl;
}


int main(){
    cin >> N >> E;
    long temp_answer = 0;
    long answer = 0;
    
    for(int i=0; i< E; i++){
        int v1 = 0;
        int v2 = 0;
        int c =0;
        
        
        cin >> v1 >> v2 >> c;
        
        adj[v1].push_back(make_pair(c, v2));
        adj[v2].push_back(make_pair(c, v1));
    }
    
    cin >> v1 >> v2;
    
    fill(d, d+N+1, INF);
    
    Dijkstra(1);
    
    
    answer += d[v1];
    temp_answer += d[v2];
    fill(d, d+N+1, INF);
    Dijkstra(v2);
    temp_answer += d[v1];
    fill(d, d+N+1, INF);
    Dijkstra(v1);
    temp_answer += d[N];

    fill(d, d+N+1, INF);
    Dijkstra(v1);
    answer += d[v2];
    fill(d, d+N+1, INF);
    Dijkstra(v2);
    answer += d[N];

    answer = min(temp_answer, answer);
    
    if(answer >= INF){
        answer  = -1;
    }
    
    if(d[N] >= INF){
        answer  = -1;
    }
    
    cout << answer << endl;
    
}
