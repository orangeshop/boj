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

int N,R,Q;
int U,V;
int input;

vector<int> adj[100005];

bool vis[100005];
int tree_count[100005];

int func(int number){
    vis[number] = true;
    for(auto nxt: adj[number]){
        if(vis[nxt] == true)continue;
        tree_count[number] += func(nxt);
    }
    
    tree_count[number]++;
    return tree_count[number];
}






int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> N >> R >> Q;
    
    for(int i=0; i<N-1; i++)
    {
        cin >> U >> V;
        
        adj[U].push_back(V);
        adj[V].push_back(U);
        
    }
    
    func(R);

    for(int i=0; i<Q; i++)
    {
        cin >> input;
        cout << tree_count[input] << '\n';
    }
    
}
