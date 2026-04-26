#include <iostream>
#include <string>
#include <cstring>
#include <vector>
#include <stack>
#include <memory.h>
#include <algorithm>
#include <queue>
#include <tuple>
#include <math.h>
#include <list>
#include <set>
#include <map>
#include <iterator>

using namespace std;
#define S second
#define F first
#define l long
#define MAX 0x7ffffff
int dx[4] = {-1,0,1,0};
int dy[4] = {0,1,0,-1};
int ddx[8] = {-1,-2,-2,-1,1,2,2,1};
int ddy[8] = {-2,-1,1,2,-2,-1,1,2};
int cdx[8] = {-1,0,1,0,-1,-1,1,1};
int cdy[8] = {0,1,0,-1,-1,1,1,-1};

//cin.tie(NULL);
//ios::sync_with_stdio(false);
//cout.tie(NULL);

int V,E;
int A,B,C;
vector<pair<int,int>> adj[10004];
bool check[10005];

int main()
{
    cin >> V >> E;
    
    for(int i=0; i<E; i++)
    {
        cin >> A >> B >> C;
        adj[A].push_back({C,B});
        adj[B].push_back({C,A});
    }
    
    check[1] = 1;
    priority_queue<tuple<int,int,int>, vector<tuple<int,int,int>>, greater<tuple<int,int,int>>> pq;
    for(auto nxt: adj[1]){
        pq.push({nxt.first, 1, nxt.second});
    }
    int cnt =0;
    int ans = 0;
    while(cnt < V-1)
    {
        int cost,a,b =0;
        tie(cost, a, b) = pq.top(); pq.pop();
        
        if(check[b] == 1) continue;
        
        ans += cost;
        cnt++;
        check[b] = 1;
        
        for(auto nxt: adj[b]){
            if(check[nxt.second] != 1){
                pq.push({nxt.first, b, nxt.second});
            }
        }
    }
    
    cout << ans << endl;
}

