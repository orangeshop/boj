#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
#include <tuple>
using namespace std;
//cin.tie(NULL);
//ios::sync_with_stdio(false);


int arr[1000001];
bool vis[1000001];
int f;
int s;
int g;
int u;
int d;

int main()
{
    
    // 73% 틀렸습니다. 배열 크기 문제 1000000 -> 1000001
    // 81% 틀렸습니다.
    cin >> f >> s >> g >> u >> d;
    queue<int> q;
    q.push(s);
    
    int array_u_d[2];
    array_u_d[0] = u;
    array_u_d[1] = d*(-1);
    
    q.push(s);
    vis[s] =1;
    
    while(!q.empty())
    {
        
        int cur = q.front(); q.pop();
        
        for(int i=0; i<2; i++)
        {
            int n_node = cur + array_u_d[i];
            
            
            if(n_node <= 0 || n_node > f) continue;
            if(vis[n_node]==1) continue;
            
            //if(n_node-array_u_d[i] < 0 || n_node-array_u_d[i] > f) continue;
            arr[n_node] = arr[n_node-array_u_d[i]]+1;
            q.push(n_node);
            vis[n_node] = 1;
        }
        
    }
    
    
    if(arr[g]==0 && vis[g]==0)
    {
        cout << "use the stairs" << endl;
    }
    else{
        cout << arr[g] << endl;
    }
    
    
    for(int i=0; i<=f; i++)
    {
        //cout << arr[i] << " ";
    }
}