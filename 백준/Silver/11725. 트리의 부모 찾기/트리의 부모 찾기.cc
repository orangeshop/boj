
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
//cin.tie(NULL);
//ios::sync_with_stdio(false);

vector<int> adj[100001];
int p[100001];
int n;

void dfs(int cur)
{
    for(auto nxt: adj[cur])
    {
        if(p[cur] == nxt) continue;
        p[nxt] = cur;
        dfs(nxt);
    }
}


int main(){
    
    
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    
    cin >> n;
    for(int i=0; i<n-1; i++)
    {
        int a=0;
        int b=0;
        cin >> a >> b;
        
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    
    dfs(1);
    
    for(int i=2; i<=n; i++)
    {
        cout << p[i] << '\n';
    }
}