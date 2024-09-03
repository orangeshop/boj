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
#include <map>
#include <cstring>
using namespace std;

int N;
int board[25][25];
int dp[20][1 << 20];

int asnwer = 1e9;

int tsp(int cur, int visit){
    
    if(visit == (1 << N)-1){
        return 0;
    }
    
    if(dp[cur][visit] != -1){
        return dp[cur][visit];
    }
    
    dp[cur][visit] = 1e9;
    
    for(int i =0; i < N; i++){
        
        if(visit & (1 << i)) continue;
        
        dp[cur][visit] = min(dp[cur][visit], tsp(cur + 1, visit | (1 << i))+ board[cur][i]);
    }

    return dp[cur][visit];
}
int main(){
    cin >> N;
    
    for(int i =0; i < N; i++){
        for(int k =0; k < N; k++){
            cin >> board[i][k];
        }
    }
    
    memset(dp, -1, sizeof(dp));
    
    
    cout << tsp(0, 0);
}


