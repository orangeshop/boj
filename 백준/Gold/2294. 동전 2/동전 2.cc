#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
#include <tuple>
using namespace std;

int d[100005];
int s[100005];
int n,m;

int main()
{
    
    cin >> n >> m;
 
    for(int i=0; i< n; i++)
    {
       
        cin >> s[i];
        d[s[i]] = 1;
        
    }

    for(int i=1; i<=m; i++)
    {
        
        for(int k=0; k<n; k++)
        {
            if(i-s[k]<0) continue;
            
            if(d[i]==0 && d[i-s[k]] !=0)
            {
                d[i] = d[i-s[k]]+1;
            }
            else if(d[i-s[k]] !=0 && d[i-(i-s[k])] !=0){
                d[i] = min(d[i], d[i-(i-s[k])]+d[i-s[k]]);
            }
        }
    }
    
    if(d[m]==0)
    {
        cout << "-1";
    }else{
        cout << d[m] << endl;
    }
}
