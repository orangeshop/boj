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

int board[20][20];
int dp[20][1<<20];
int N;

int tsp(int cur, int visit){
    
    if(visit == (1 << N)-1){
        if(board[cur][0] == 0){
            return 1e9;
        }
        return board[cur][0];
    }
    
    if(dp[cur][visit] != -1){
        return dp[cur][visit];
    }
    
    dp[cur][visit] = 1e9;
    
    for(int i =0; i < N; i++){
        if(board[cur][i] == 0){
            continue;
        }
        
        if((visit & (1 << i)) == (1 << i)){
            continue;
        }
        
        dp[cur][visit] = min(dp[cur][visit], board[cur][i] + tsp(i, visit | (1 << i)));
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
    
    cout << tsp(0, 1);
    
    return 0;
    
}
