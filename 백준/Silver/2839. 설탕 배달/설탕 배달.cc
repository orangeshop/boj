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

int answer = 300000;
int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    cin >> N;
    
    for(int i = 0; i < 5000; i++){
        if(N < 5 * i) break;
        
        int tmp = N - (5 * i);
        if(tmp % 3 == 0){
            answer = min(answer, i + (tmp / 3));
        }
    }
    
    
    if(answer == 300000){
        answer = -1;
    }
    
    cout << answer;
}
