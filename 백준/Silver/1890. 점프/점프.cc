#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
#include <tuple>
using namespace std;

long long s[110][110];
long long d[110][110];
int n;
int main()
{
    cin >> n;
    
    for(int i=1; i<=n; i++)
    {
        for(int k=1; k<=n; k++)
        {
            cin >> s[i][k];
        }
    }
    int cnt=0;
   
    d[1][1] = 1;
    
    for(int i=1; i<=n; i++)
    {
        for(int k=1; k<=n; k++)
        {
            if(i==n && k==n) break;
            if(d[i][k] == 0) continue;
            d[i+s[i][k]][k] += d[i][k];
            d[i][k+s[i][k]] += d[i][k];
            
            if((i==n && k+s[i][k] == n))
            {
                cnt += d[i][k+s[i][k]];
            }
            else if(i+s[i][k]==n && k == n)
            {
                cnt += d[i+s[i][k]][k];
            }
            
        }
    }
    
    cout << d[n][n] << endl;;
}