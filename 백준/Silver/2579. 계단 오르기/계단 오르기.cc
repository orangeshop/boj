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
#include <set>

using namespace std;
vector<int> V;
int N;
int d[305];
int ans = 0;
int main(){
    cin >> N;
    
    for(int i =0; i < N; i++){
        int a = 0;
        cin >> a;
        V.push_back(a);
    }
    
    
    /**
     1 - 10
     2 - 30
     */
    
    d[0] = V[0];
    d[1] = V[1] +V[0];
    d[2] = max(V[0] + V[2], V[1] + V[2]);
    
    
    
    for(int i = 3; i < N; i++){
        int tmp1 = d[i-2] + V[i] ;
        int tmp2 = d[i-3] + V[i-1] + V[i];
        d[i] = max(tmp1, tmp2);
    }
    
    cout << d[N-1] << endl;
    
    
}
