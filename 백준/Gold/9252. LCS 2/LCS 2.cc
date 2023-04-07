#include <iostream>
#include <string>
#include<cstring>
#include <vector>
#include <stack>
#include <memory.h>
#include <algorithm>
#include <queue>
#include <tuple>
#include <math.h>
#include <set>
#include <map>
using namespace std;
//cin.tie(NULL);
//ios::sync_with_stdio(false);


int dp[1005][1005];
string string_n;
string string_m;

int main()
{
    cin >> string_n >> string_m;
    
    int max_num =0;
    
    for(int i=0; i<=string_n.size(); i++)
    {
        for(int k=0; k<=string_m.size(); k++)
        {
            if(i==0 || k==0)
            {
                dp[i][k] =0;
                
            }
            else if(string_n[i-1] == string_m[k-1])
            {
                dp[i][k] = dp[i-1][k-1]+1;
            }
            else{
                dp[i][k] = max(dp[i-1][k], dp[i][k-1]);
                
            }
            max_num = max(dp[i][k],max_num);
        }
    }
    
    cout << max_num << endl;
    
    unsigned long result_i = 0;
    unsigned long result_k = 0;
    result_i = string_n.size();
    result_k = string_m.size();

    vector<char> V;
    while(1)
    {
        if(dp[result_i][result_k] == 0) break;
        
        if(dp[result_i-1][result_k] == dp[result_i][result_k])
        {
            result_i = result_i-1;
            result_k = result_k;
        }
        else if(dp[result_i][result_k-1] == dp[result_i][result_k])
        {
            result_i = result_i;
            result_k = result_k-1;
        }
        else{

            V.push_back(string_n[result_i-1]);
            result_i = result_i-1;
            result_k = result_k-1;
        }
        
    }
   
    
    
    for(int i=V.size()-1; i>=0; i--)
    {
        cout << V[i];
    }
    cout << endl;

}