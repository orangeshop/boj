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

int board[9][9];

vector<pair<int,int>> V;


bool out = false;

bool check(int x, int y){
    for(int i =0; i < 9; i++){
        if(board[x][i] == board[x][y] && i !=y){
            return false;
        }
        if(board[i][y] == board[x][y] && i !=x){
            return false;
        }
    }
    
    int sq_x = x % 3;
    int sq_y = y % 3;
    
    
    for(int i = x - sq_x; i < x - sq_x + 3; i++){
        for(int k = y - sq_y; k < y - sq_y + 3; k++){
            if(i == x && k == y) continue;
            if(board[i][k] == board[x][y]) return false;
        }
    }
    
    return true;
}


void dfs(int depth){
    
    if(out == true) return;
    
    if(depth == V.size()){
        for(int i =0; i < 9; i++){
            for(int k =0; k < 9; k++){
                cout << board[i][k];
            }
            cout << endl;
        }
        out = true;
        return;
    }
    
    int x = V[depth].first;
    int y = V[depth].second;

    
    for(int i =1; i < 10; i++){
        board[x][y] = i;
        
        if(check(x,y)){
            
            dfs(depth + 1);
            
        }
        if(out == true) return;
    }
    board[x][y] = 0;
    
}

int main(){
    for(int i =0; i < 9; i++){
        string str = "";
        cin >> str;
        for(int k =0 ; k < 9; k++){
            board[i][k] = str[k] - '0';
            if(board[i][k] == 0){
                V.push_back({i,k});
            }
        }
    }
    
    
    dfs(0);
    
}
