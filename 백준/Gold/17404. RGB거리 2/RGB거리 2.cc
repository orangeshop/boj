
#include <iostream>
#include <string>
#include <cstring>
#include <vector>
#include <stack>
#include <memory.h>
#include <algorithm>
#include <queue>
#include <tuple>
#include <math.h>
#include <list>
#include <set>
#include <map>
#include <iterator>
#include <fstream>
using namespace std;
#define S second
#define F first
#define l long
#define MAX 0x7ffffff
int dx[4] = {-1,0,1,0};
int dy[4] = {0,1,0,-1};
int ddx[8] = {-1,-2,-2,-1,1,2,2,1};
int ddy[8] = {-2,-1,1,2,-2,-1,1,2};
int cdx[8] = {-1,0,1,0,-1,-1,1,1};
int cdy[8] = {0,1,0,-1,-1,1,1,-1};

int N, answer;
int Num_1, Num_2, Num_3;
int board[1005][5];
int dp[1005][5];

int main(){
    
    cin >> N;
    
    for(int i=0; i<N; i++){
        cin >> Num_1 >> Num_2 >> Num_3;
        
        board[i][0] = Num_1;
        board[i][1] = Num_2;
        board[i][2] = Num_3;
    }
    
    answer = MAX;
    
    for(int i=0; i<3; i++){
        
        for(int k=1; k<N; k++){
            
            for(int k = 0; k < 3; k++) {
                if (i == k){
                    dp[0][k] = board[0][k];
                    
                } else dp[0][k] = MAX;
            }
            
            dp[k][0] = min(dp[k-1][1], dp[k-1][2]) + board[k][0];
                
            dp[k][1] = min(dp[k-1][0], dp[k-1][2]) + board[k][1];
            
            dp[k][2] = min(dp[k-1][1], dp[k-1][0]) + board[k][2];
            
        }
        
        
        for(int k =0; k<3; k++){
            
            
            if(i != k){
                answer = min(answer, dp[N-1][k]);
            }
        }
    }
    
    cout << answer << endl;
}


/*
 
 
 
 
 */
