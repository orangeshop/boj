
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

int n;
int m;
int d[100000];
vector<int>V;
int main()
{
    cin >> n >> m;
    
    for(int i=0; i< n; i++)
    {
        int a=0;
        cin >> a;
        V.push_back(a);
        
    }
    d[0] = 1;
    for(int k=0; k<n; k++)
    {
        for(int i=1; i<=m; i++)
        {
            if(i-V[k] >= 0)
            {
                d[i] += d[i-V[k]];
            }
        }
    }
    
    cout << d[m];
    
}
