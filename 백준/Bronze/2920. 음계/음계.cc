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
int ascending[8] = {1,2,3,4,5,6,7,8};
int descending[8] = {8,7,6,5,4,3,2,1};


int main()
{
    vector<int> V;
    for(int i=0; i<8; i++)
    {
        cin >> n;
        V.push_back(n);
    }
    
    bool ascen = true;
    
    for(int i=0; i<8; i++)
    {
        if(V[i] != ascending[i])
        {
            ascen = false;
            break;
        }
        
        if(i == 7 && ascen == true)
        {
            cout << "ascending" << endl;
            return 0;
        }
        
    }
    
    bool descen = true;
    
    for(int i=0; i<8; i++)
    {
        if(V[i] != descending[i])
        {
            descen = false;
            break;
        }
        
        if(i == 7 && descen == true)
        {
            cout << "descending" << endl;
            return 0;
        }
        
    }
    
    cout << "mixed" << endl;
    
}