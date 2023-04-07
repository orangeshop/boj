#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
#include <tuple>
using namespace std;

int s[4][100005];
int d[4][100005];
int n;

int main()
{
    int a=0;
    vector<int> V;
    cin >> a;
    
    for(int i=0; i<a; i++)
    {
        cin >> n;
    
        for(int i =1; i<3; i++)
        {
            for(int k=0; k<n; k++)
            {
                cin >> s[i][k];
            }
        }
    
   
        d[1][1] = max(d[1][1],d[2][1]);
        d[2][1] = min(d[1][1],d[2][1]);
        for(int i =0; i<n; i++)
        {
        
            d[1][i+2] = d[1][i] + max(s[1][i+2],s[2][i+2]);
            d[2][i+2] = d[2][i] + max(s[1][i+2],s[2][i+2]);
        
        
            d[2][i+1] = max(d[2][i] , d[1][i] + s[1][i]);
            d[1][i+1] = max(d[1][i] , d[2][i] + s[2][i]);
       
        }
        
    
        //cout << max(d[1][n], d[2][n]) << endl;
        V.push_back(max(d[1][n], d[2][n]));
        for(int i =1; i<3; i++)
        {
            for(int k=0; k<n; k++)
            {
                d[i][k] = 0;
            }
        }
    }
    
    for(int i=0; i<a; i++)
    {
        cout << V[i]<<'\n';
    }
    
}