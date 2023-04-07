#include <iostream>
#include <string>
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


int d[100005];

int main()
{
    int n = 0;
    int num = 0;
    cin >> n >> num;
    
    for(int i=0; i< 100005; i++)
    {
        if(n > i)
        {
            d[i] = n - i;
        }
        else{
            d[i] = i - n;
        }
        
        if(i % 2 == 0)
        {
            d[i] = min(d[i], d[i/2]);
        }
        
        if(i-1 < 0) continue;
        
        if(d[i] > d[i-1]+1)
        {
            d[i] = d[i-1]+1;
        }
        
        if(d[i-1] > d[i]+1)
        {
            d[i-1] = d[i]+1;
        }
        
        
    }
    
    cout << d[num] << endl;
    
    
}