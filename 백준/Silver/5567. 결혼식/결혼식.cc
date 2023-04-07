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

int n,m;
vector<int> adj[501];
bool vis[501];
int main()
{
    cin >> n;
    cin >> m;
    
    for(int i=0; i<m; i++)
    {
        int a=0;
        int b =0;
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
        
    }
    
    queue<pair<int,int>> Q;
    Q.push({1,0});
    vis[1] = 1;
    int answer = 0;
    while(!Q.empty())
    {
        pair<int,int> cur = Q.front();
        //cout << cur.F << " "<< cur.S << endl;
        Q.pop();
        for(auto nxt : adj[cur.F])
        {
            if(vis[nxt] == 1 || cur.S >= 2) continue;
            //cout << nxt << " " << cur.S << endl;
            Q.push({nxt,cur.S+1});
            answer++;
            vis[nxt] = 1;
        }
    }
    
    cout << answer << endl;
}