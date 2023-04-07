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

int n,m;
int w[101];
int v[101];
int d[101][100001];

int main()
{
    cin >> n >> m;
    
    for(int i=1; i<= n; i++)
    {
        cin >> w[i] >> v[i];
    }
   
    for(int i=1; i<=n; i++)
    {
        for(int k=1; k<=m; k++)
        {
            d[i][k] = d[i-1][k];
            if(k-w[i] >= 0)
            {
                d[i][k] = max(d[i][k] , d[i-1][k-w[i]]+v[i]);
            }
        }
    }
    
    cout << d[n][m];
    
    
}