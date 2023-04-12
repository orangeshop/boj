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
long INF = 0x3f3f3f3f;


int N,M;
int d[60005];
vector<pair<int,int> >adj[60005];


int main(){
    cin >> N >> M;

    for(int i=0; i<M; i++){
        int u = 0;
        int w = 0;
        int c = 0;

        cin >> u >> w >> c;

        adj[u].push_back(make_pair (c, w) );
        adj[w].push_back(make_pair (c, u) );
    }

    fill(d, d+N+1, INF);
    
    
    d[1] = 0;


    priority_queue<pair<int,int>, vector<pair<int,int> >, greater<pair<int,int> > > pq;

    pq.push(make_pair(d[1], 1));

    while(!pq.empty()){

        pair<int,int> cur = pq.top();
        pq.pop();
        if(d[cur.second] != cur.first) continue;
        for(auto nxt : adj[cur.second]){
            if(d[nxt.second] <= d[cur.second] + nxt.first) continue;

            d[nxt.second] = d[cur.second] + nxt.first;

            pq.push(make_pair(d[nxt.second], nxt.second));

        }

    }


    cout << d[N] << endl;
}
