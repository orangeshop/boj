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

int board[2200][2200];

/*
00
04
40
44
 
 */

int w,b,c;

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
        
        int n3 = n / 3;
        go(n3, x, y);
        go(n3, x ,y + n3);
        go(n3, x, y + n3 * 2);
        go(n3, x + n3, y);
        go(n3, x + n3,y + n3);
        go(n3, x+ n3, y + n3 * 2);
        go(n3, x+ n3 * 2, y);
        go(n3, x+ n3 * 2 ,y + n3);
        go(n3, x+ n3 * 2, y + n3 * 2);
        
    }else{
        if(board[x][y] == -1){
            w += 1;
        }
        else if(board[x][y] == 1){
            b += 1;
        }else{
            c += 1;
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
    
    cout << w << endl << c << endl << b << endl;
    
}
