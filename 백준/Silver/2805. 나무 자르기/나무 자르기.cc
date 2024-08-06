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


int N, M;

int d[1000005];

int main(){
    cin >> N >> M;
    
    for(int i = 0; i < N; i++){
        cin >> d[i];
    }
    
    
    int L = 0;
    int R = 2000000000;
    
    while(1){
        if(L > R) break;
        int mid = (L+R)/2;
        
        long long sum = 0;
        for(int i =0; i < N; i++){
            if(d[i] - mid >= 0) sum += d[i] - mid;
        }
        
        
        if(sum >= M){
            L = mid + 1;
        }else{
            R = mid - 1;
        }
    }
    
    cout << R << endl;
    
    
}
