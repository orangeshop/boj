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

string str;

int main()
{
    int count=0;
    getline(cin, str);
    
    for(int i=0; i< str.size(); i++)
    {
        
        if(str[i]== ' ')
        {
            if(i-1 <0) continue;
            
            //cout <<str[i-1] << " " << str[i+1] << endl;
            if(str[i-1] != ' ' && str[i+1] != ' ')
            {
                count++;
            }
        }
    }

    if(str[str.size()-1]== ' ')
    {
        count--;
    }
    cout << count+1 << endl;
}
