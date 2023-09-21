#include <string>
#include <vector>
#include <iostream>
using namespace std;
int board[105][105];
bool vis[105][105];

int solution(int m, int n, vector<vector<int>> puddles) {

    if(puddles.size() != 0){
        for(int i =0; i< puddles.size(); i++){
            vis[puddles[i][1]-1][puddles[i][0]-1] = true;
        }
    }

    board[0][0] = 1;
    
    for(int i =0; i< n; i++){
        for(int k = 0; k < m; k++){
            if(vis[i][k] == true){
                continue;
            }
            
            if(i == 0){
                board[i][k] += board[i][k - 1] % 1000000007;
            }
            else if(k == 0){
                board[i][k] += board[i - 1][k] % 1000000007;
            }
            else{
                board[i][k] += (board[i - 1][k] + board[i][k - 1]) % 1000000007;
            }
        }
    }
    return board[n-1][m-1];
}