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

int board[150][150];

/*
00
04
40
44
 
 */

int w,b;

void go(int n, int x, int y){
    bool check = false;
    for(int i =x; i < x + n; i++){
        for(int k = y; k < y + n; k++){
//            cout << i << " " << k << endl;
            if(board[x][y] != board[i][k]){
                check = true;
                break;
            }
        }
        if(check == true) break;
    }
//    cout << check << endl;
    if(check == true){
        
        int n2 = n / 2;
        go(n2, x, y);
        go(n2, x + n2, y);
        go(n2, x, y + n2);
        go(n2, x + n2, y + n2);
    }else{
        if(board[x][y] == 0){
            w += 1;
        }
        else{
            b += 1;
        }
    }
    
    
    
}

int main(){
    cin >> N;
    for(int i =0; i < N; i++){
        for(int k =0; k < N; k++){
            cin >> board[i][k];
        }
    }
    
//    for(int i =0; i < N; i++){
//        for(int k =0; k < N; k++){
//            cout << board[i][k];
//        }
//        cout << endl;
//    }
//    
    go(N, 0 , 0);
    
    cout << w << endl << b << endl;
    
}
