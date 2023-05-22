#include <string>
#include <vector>
#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int board[105][105];
bool vis[105][105];


vector<int> solution(vector<string> maps) {
    vector<int> answer;
    queue<pair<int,int>> Q;
    
    int Row = maps[0].size();
    int column = maps.size();
    
    //cout << Row << " " << column << endl; 
    
    for(int i=0; i<column; i++){
        for(int k=0; k<Row; k++){
            
            if(vis[i][k] == 0 && maps[i][k] != 'X'){
                Q.push({i,k});
                vis[i][k] = 1;
                int num = 0;
                while(!Q.empty()){
                    pair<int,int> cur = Q.front();
                    Q.pop();
                    
                    for(int dir =0; dir < 4; dir++){
                        int nx = dx[dir] + cur.first;
                        int ny = dy[dir] + cur.second;
                        
                        if(nx < 0 || nx >= column || ny < 0 || ny >= Row) continue;
                        if(vis[nx][ny] == 1 || maps[nx][ny] == 'X') continue;
                        
                        Q.push({nx,ny});
                        vis[nx][ny] = 1;
                    }
                    
                    num += (maps[cur.first][cur.second]-48);
                }
                
                answer.push_back(num);
            }
        }
        
    }
    sort(answer.begin(), answer.end());
    
     for(int i=0; i<column; i++){
        for(int k=0; k<Row; k++){
            cout << vis[i][k] << " ";
        }
         cout << endl;
     }
    
    if(answer.size() == 0)
    {
        answer.push_back(-1);   
    }    
    return answer;
}