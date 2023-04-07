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
int d[1000000];
vector<int>V;
int main()
{
    cin >> n;
    
    for(int i=0; i< n; i++)
    {
        int a=0;
        cin >> a;
        V.push_back(a);
        
    }
    
    stack<int> S;
    queue<int> Q;
    for(int i=0; i<n; i++)
    {
        
        if(i==0)
        {
            S.push(i);
            continue;
        }
        
        if(V[S.top()] < V[i])
        {
            for(int k=i; k>= 0; k--)
            {
                if(S.empty())
                {
                    S.push(i);
                    break;
                }
                if(V[S.top()] >= V[i])
                {
                    break;
                }
                else{
                    d[S.top()] = V[i];
                    S.pop();
                }
            }
            S.push(i);
            continue;
        }
        else if( V[S.top()] >= V[i] )
        {
            S.push(i);
            continue;
        }
        
    }

    while(!S.empty())
    {
        d[S.top()] = -1;
        S.pop();
    }
    d[n-1] = -1;
   
    for(int i=0; i<n; i++)
    {
        cout << d[i];
        if(i != n-1)
        {
            cout << " ";
        }
    }
    
    cout << endl;
}