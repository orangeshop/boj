//
//  main.cpp
//  test
//
//  Created by 최영호 on 2021/12/16.
//


#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
#include <tuple>
#include <math.h>
using namespace std;
//cin.tie(NULL);
//ios::sync_with_stdio(false);


int n;

int main()
{
    cin >> n;
    vector<string> V;
    for(int i=0; i< n; i++)
    {
        int a=0;
        string str;
        
        cin >> a >> str;

        string temp;
        for(int j=0; j<str.size(); j++)
        {
            for(int k=0; k< a; k++)
            {
                temp += str[j];
            }
            
        }
        
        V.push_back(temp);
        
        
    }
    
    for(int i=0; i<n; i++)
    {
        cout << V[i] << endl;
    }
}
