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

int dx[4] = {0,0,1,-1};
int dy[4] = {1,-1,0,0};


int M,N;
int board[1005][1005];
bool vis[1005][1005];
int cnt[1005][1005];

int ans;

queue<pair<int, int>> Q;

int main(){
    cin >> M >> N;
    
    for(int i =0; i < N; i++){
        for(int k =0; k < M; k++){
            cin >> board[i][k];
            if(board[i][k] == 1){
                Q.push({i,k});
                vis[i][k] = true;
            }
        }
    }
    
    
    
    bool check = false;
    
    for(int i =0; i < N; i++){
        for(int k =0; k < M; k++){
            if(board[i][k] == 0){
                check = true;
            }
        }
    }
    
    if(check == true){
        while(!Q.empty()){
            pair<int,int> cur = Q.front();
            Q.pop();
            
            for(int dir = 0; dir < 4; dir++){
                int nx = dx[dir] + cur.first;
                int ny = dy[dir] + cur.second;
                
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(board[nx][ny] == -1 || vis[nx][ny] == true) continue;
                
                cnt[nx][ny] = cnt[cur.first][cur.second] + 1;
                
                vis[nx][ny] = true;
                
                Q.push({nx,ny});
                
            }
        }
    }else{
        cout << 0 << endl;
        return 0;
    }
    
    
    for(int i =0; i < N; i++){
        for(int k =0; k < M; k++){
            if(vis[i][k] == false && board[i][k] != -1){
                cout << -1 << endl;
                return 0;
            }
            
            ans = max(ans, cnt[i][k]);
        }
    }
    
    cout << ans << endl;
    
    
    
    
}
