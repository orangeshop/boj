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

int N, M;
int board[1005][1005];
bool vis[1005][1005];
queue<pair<int,int>> Q;

int dx[4] = {0,1,0,-1};
int dy[4] = {1,0,-1,0};


int main(){
    cin >> N >> M;
    
    for(int i =0; i < N; i++){
        for(int k =0; k < M; k++){
            cin >> board[i][k];
        }
    }
    
    int cnt = 0;
    
    for(int i =0; i < N; i++){
        for(int k =0; k < M; k++){
            if(board[i][k] == 0 && vis[i][k] == false){
                
                Q.push({i,k});
                
                cnt ++;
            
                
                while(!Q.empty()){
                    pair<int,int> cur = Q.front();
                    Q.pop();
                    
                    if(vis[cur.first][cur.second] == true || board[cur.first][cur.second] == 1){
                        continue;
                    }
                    
                    vis[cur.first][cur.second] = true;
                    
                    for(int dir =0; dir < 4; dir++){
                        int nx = dx[dir] + cur.first;
                        int ny = dy[dir] + cur.second;
                        
                        if(nx < 0 || nx >= N || ny < 0 || ny >= M){
                            
                            if(nx < 0){
                                Q.push({N-1, ny});
                            }
                            else if(nx >= N){
                                Q.push({0, ny});
                            }
                            else if(ny < 0){
                                Q.push({nx, M-1});
                            }
                            else if(ny >= M){
                                Q.push({nx, 0});
                            }
                            
                            continue;
                        }
                        
                    
                        Q.push({nx,ny});
                        
                        
                    }
                }
            }
        }
    }
    
    
    cout << cnt;
    
}


