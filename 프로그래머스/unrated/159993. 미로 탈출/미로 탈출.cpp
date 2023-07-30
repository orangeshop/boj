#include <string>
#include <vector>
#include <queue>
#include <iostream>
using namespace std;

int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int vis[105][105];
int bd[105][105];
queue<pair<int,int>> Q;             
int solution(vector<string> maps) {
    int answer = 0;
    int end_p_x = 0;
    int end_p_y = 0;
    int L_p_x = -1;
    int L_p_y = -1;
    int result_L_p = -1;
    
    for(int i=0; i < maps.size(); i++){
        for(int k =0; k< maps[i].size(); k++){
            if(maps[i][k] == 'S'){
                Q.push({i,k});
                vis[i][k] = 1;
            }
            
            if(maps[i][k] == 'E'){
                end_p_x = i;
                end_p_y = k;
            }
            
            if(maps[i][k] == 'L'){
                L_p_x = i;
                L_p_y = k;
            }
        }
    }
    
    
    while(!Q.empty()){
       
        pair cur = Q.front();
        Q.pop();
        
            for(int dir =0; dir < 4; dir++){
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];
            
            
            if(nx < 0 || nx >= maps.size() || ny < 0 || ny >= maps[0].size()) continue;
            if(vis[nx][ny] == 1) continue;
            if(maps[nx][ny] == 'X') continue;
                
            vis[nx][ny] = 1;
            
            bd[nx][ny] = bd[cur.first][cur.second] + 1;
            
            Q.push({nx,ny});
        }
    }
    
    for(int i=0; i < maps.size(); i++){
        for(int k =0; k< maps[i].size(); k++){
            cout << bd[i][k] << " ";
        }
        cout << endl;
    }
    
    
    
    cout << L_p_x << " " << L_p_y << endl;
    result_L_p = bd[L_p_x][L_p_y];
    cout << result_L_p << endl;
    
    if(vis[L_p_x][L_p_y] == 0){
        answer = -1;
        return answer;    
    }
    
    for(int i=0; i < maps.size(); i++){
        for(int k =0; k< maps[i].size(); k++){
            bd[i][k] = 0;
            vis[i][k] = 0;
        }
    }
    
    
    
    Q.push({L_p_x, L_p_y});
    vis[L_p_x][L_p_y] = 1;
    bd[L_p_x][L_p_y] = result_L_p;
    
    for(int i=0; i < maps.size(); i++){
        for(int k =0; k< maps[i].size(); k++){
            cout << bd[i][k] << " ";
        }
        cout << endl;
    }
    
    while(!Q.empty()){
        
        pair cur = Q.front();
        Q.pop();
        
        for(int dir =0; dir < 4; dir++){
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];
            
            
            if(nx < 0 || nx >= maps.size() || ny < 0 || ny >= maps[0].size()) continue;
            if(vis[nx][ny] == 1) continue;
            if(maps[nx][ny] == 'X') continue;
                
            vis[nx][ny] = 1;
            
            bd[nx][ny] = bd[cur.first][cur.second] + 1;
            
            Q.push({nx,ny});
        }
    }
    cout << "---------" << endl;
    for(int i=0; i < maps.size(); i++){
        for(int k =0; k< maps[i].size(); k++){
            cout << bd[i][k] << " "; 
        }
        cout << endl;
    }
    
    answer = bd[end_p_x][end_p_y];
    if(answer == 0){
        answer = -1;
    }
    return answer;
}