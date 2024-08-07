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

int d[500005];


bool bs(int num){
    ios::sync_with_stdio(false);
    cin.tie(0);
    
    int L = 0;
    int R = N-1;
    
    while(L <= R){
        int mid = (L + R) / 2;
        // -10 2 3 6 10
        
        
        if(d[mid] == num){
            return 1;
        }
        else if(d[mid] >num){
            R = mid - 1;
        }else{
            L = mid + 1;
        }
    }
    
    
    
    return 0;
    
}

int main(){
    cin >> N;
    
    for(int i =0; i < N; i++){
        int a = 0;
        cin >> a;
        d[i] = a;
    }
    
    sort(d, d + N);
    
    cin >> M;
    
    for(int i =0; i < M; i++){
        int a = 0;
        cin >> a;
        cout << bs(a) << " ";
    }
    
}
