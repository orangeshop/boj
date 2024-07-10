//
//  main.cpp
//  cpp
//
//  Created by 최영호 on 7/8/24.
//

#include <iostream>
#include <algorithm>
#include <stack>
#include <string>
#include <sstream>
#include <queue>
using namespace std;

int N;
int d[1000005];
int main(){
    cin >> N;
    
    fill(d, d +1000005, 9999);
    d[0] = 0;
    d[1] = 0;
    
    for(int i =1; i < 1000005; i++){
        d[i] = min(d[i], d[i-1] + 1);
        if(i % 3 == 0) d[i] = min(d[i], d[i/3] + 1);
        if(i % 2 == 0) d[i] = min(d[i], d[i/2] + 1);
    }
    
    cout << d[N];
}
