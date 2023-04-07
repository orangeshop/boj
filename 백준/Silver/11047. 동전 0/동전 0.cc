#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
#include <tuple>
#include <math.h>
#include <set>
using namespace std;
//cin.tie(NULL);
//ios::sync_with_stdio(false);

long n,m;
int arr[100];
int main()
{
    cin >> n >> m;

   
    for(int i=0; i<n; i++)
    {
        int a=0;
        cin >> a;
        arr[i] = a;
    }
    long result =0;
    long check_num =0;
    
    
    for(long i=n-1; i>= 0; i--)
    {
        if(arr[i] <= m)
        {
            check_num =i;
            break;
        }
    }
    
    
    //cout << arr[check_num] << endl;
    while(true)
    {
        result += m/arr[check_num];
        m %= arr[check_num];
        //cout << m << endl;
        if(m==0) break;
        
        for(long i=check_num; i>=0; i--)
        {
            if(arr[i] <= m)
            {
                check_num =i;
                break;
            }
        }
        
        
        
       
    }
    
    cout << result << endl;
}