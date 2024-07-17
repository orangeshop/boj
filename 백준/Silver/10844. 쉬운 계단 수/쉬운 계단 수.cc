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


/**
 1,0 -> 1
 1,1 -> 1
 1,2 -> 1
 1,3 -> 1
 1,4 -> 1
 1,5 -> 1
 1,6 -> 1
 1,7 -> 1
 1,8 -> 1
 1,9 -> 1
 
 2,0 -> 1
 2,1 -> 1
 2,2 -> 2
 2,3 -> 2
 2,4 -> 2
 2,5 -> 2
 2,6 -> 2
 2,7 -> 2
 2,8 -> 2
 2,9 -> 1
 
 
 
 3,0 -> 1
 3,1 -> 3
 3,2 -> 3
 3,3 -> 3
 3,4 -> 3
 3,5 -> 3
 3,6 -> 3
 3,7 -> 3
 3,8 -> 3
 3,9 -> 1
 
 x,1,0
 x,x,0
 
 2 9
 
 101
 121
 321
 
 2,0 1
 2,2 2
 xx1 4?
 121
 101
 
 432
 232
 212
 
 */

int N;

int d[105][10];
// 자릿수, 마지막 수

int ans = 0;
int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    cin >> N;
    
    for(int i =1; i <= 9; i++){
        d[1][i] = 1;
    }
    
    for(int i =2; i <= N; i++){
        for(int k =0; k <= 9; k++){
            if(k == 0){
                d[i][k] = d[i-1][k+1];
            }else if(k == 9){
                d[i][k] = d[i-1][k-1];
            }else{
                d[i][k] = d[i-1][k-1] + d[i-1][k+1];
            }
            d[i][k] %= 1000000000;
        }
    }
    
    for(int i =0; i <= 9; i++){
        ans += d[N][i];
        ans %= 1000000000;
    }
    
    cout << ans << endl;
}
