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


int N;
int M;

int board[105][105];

int d[105][105];

int main(){
    cin >> N;
    cin >> M;
    
    for(int i =0; i < 105; i++){
        for(int k=0; k < 105; k++){
            board[i][k] = 1e9;
        }
    }
    
    for(int i =0; i < M; i++){
        int a = 0;
        int b = 0;
        int c = 0;
        cin >> a >> b >> c;
        board[a][b] = min(board[a][b], c);
    }
    
    
    for(int i =1; i <= N; i++){
        board[i][i] = 0;
    }
    
    for(int k =1; k <= N; k++){
        for(int i =1; i <= N; i++){
            for(int j =1; j <= N; j++){
                board[i][j] = min(board[i][j], board[i][k] + board[k][j]);
            }
        }
    }
    
    for(int i =1; i <= N; i++){
        for(int k=1; k <= N; k++){
            if(board[i][k] == 1e9){
                board[i][k] = 0;
            }
            
            cout << board[i][k] << " ";
            
        }
        cout << endl;
    }
    
}
