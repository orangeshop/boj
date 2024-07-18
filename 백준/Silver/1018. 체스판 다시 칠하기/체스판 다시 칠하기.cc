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

char w[8][8] =
{
    {'W','B','W','B','W','B','W','B'},
    {'B','W','B','W','B','W','B','W'},
    {'W','B','W','B','W','B','W','B'},
    {'B','W','B','W','B','W','B','W'},
    {'W','B','W','B','W','B','W','B'},
    {'B','W','B','W','B','W','B','W'},
    {'W','B','W','B','W','B','W','B'},
    {'B','W','B','W','B','W','B','W'}
};

char b[8][8] = {
    {'B','W','B','W','B','W','B','W'},
    {'W','B','W','B','W','B','W','B'},
    {'B','W','B','W','B','W','B','W'},
    {'W','B','W','B','W','B','W','B'},
    {'B','W','B','W','B','W','B','W'},
    {'W','B','W','B','W','B','W','B'},
    {'B','W','B','W','B','W','B','W'},
    {'W','B','W','B','W','B','W','B'}
};

int N, M;

char board[55][55];

int main(){
    
    cin >> N >> M;
    
    for(int i =0; i < N; i++){
        string str = "";
        cin >> str;
        for(int k =0; k < M; k++){
            board[i][k] = str[k];
        }
    }
    int ans = 999999999;
    
    for(int i =0; i < N-7; i++){
        for(int k =0; k < M-7; k++){
            int Btmp = 0;
            int Ctmp = 0;
            
//            cout << i << " " << k << endl;
            
            for(int j = 0; j < 8; j++){
                for(int l = 0; l < 8; l++){
                    
//                    cout << j << " " << l << " " << j-i << " " << l-k << endl;
//                    cout <<j + i << " " << l + k << " " << j-i << " " << l-k << endl;
                    if(board[j + i][l + k] != b[j][l]){
                        Btmp ++;
                    }
                    
                    if(board[j + i][l + k] != w[j][l]){
                        Ctmp ++;
                    }
                }
            }
            
//            cout << Btmp << " " << Ctmp << endl;
            
            ans = min(ans, min(Btmp, Ctmp));
            
//            cout << endl;
        }
    }
    
    cout << ans << endl;
    
    
}
