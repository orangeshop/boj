#include <iostream>
#include <string>
#include<cstring>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
#include <tuple>
#include <math.h>
#include <set>
#include <map>
using namespace std;
//cin.tie(NULL);
//ios::sync_with_stdio(false);

long long n,m;

queue<pair<long long,long long>> Q;
int main(){
    
    cin>> n >> m;
    
    Q.push({n,1});
    
    
    while(!Q.empty())
    {
        
        pair<long,long> cur = Q.front(); Q.pop();
        if(cur.first == m)
        {
            
            cout << cur.second << endl;
            return  0;;
        }
        if(cur.first > 1000000000)
        {
            continue;
        }
        
        Q.push({cur.first*2, cur.second+1});
        Q.push({cur.first*10 + 1, cur.second+1});
        
    }
    
    cout << "-1" << endl;
}