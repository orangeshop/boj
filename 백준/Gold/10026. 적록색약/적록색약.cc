
#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
#include <tuple>
#include <math.h>
#include <set>
using namespace std;
//cin.tie(NULL);
//ios::sync_with_stdio(false);
int n;
int board[101][101];
bool vis[101][101];

int board_2[101][101];
bool vis_2[101][101];


int check_board[101][101];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

// red = 1
// blue = 2
// grean = 3

void board_2_func()
{
    queue<pair<int,int>> Q;
    int num=1;
    
    for(int i=0; i<n; i++)
    {
        for(int k=0; k< n; k++)
        {
            
            if(vis_2[i][k] == 0)
            {
                Q.push({i,k});
                vis_2[i][k] = 1;
                check_board[i][k] = num;
                while(!Q.empty())
                {
                    pair<int,int> cur = Q.front();
                    Q.pop();
            
                    for(int i=0; i<4; i++)
                    {
                        int nx = cur.first + dx[i];
                        int ny = cur.second + dy[i];
            
                        if(0 > nx || n < nx || 0 > ny || n < ny) continue;
                        if(vis_2[nx][ny] == 1) continue;
                        if(board_2[cur.first][cur.second] != board_2[nx][ny]) continue;
            
                        Q.push({nx,ny});
                        vis_2[nx][ny] = 1;
                        check_board[nx][ny] = num;
                    }
                }
                
                num++;
            }
        }
    }
}
void board_func()
{
    queue<pair<int,int>> Q;
    
    int num=1;
    
    for(int i=0; i<n; i++)
    {
        for(int k=0; k< n; k++)
        {
            
            if(vis[i][k] == 0)
            {
                Q.push({i,k});
                vis[i][k] = 1;
                check_board[i][k] = num;
                while(!Q.empty())
                {
                    pair<int,int> cur = Q.front();
                    Q.pop();
            
                    for(int i=0; i<4; i++)
                    {
                        int nx = cur.first + dx[i];
                        int ny = cur.second + dy[i];
            
                        if(0 > nx || n < nx || 0 > ny || n < ny) continue;
                        if(vis[nx][ny] == 1) continue;
                        if(board[cur.first][cur.second] != board[nx][ny]) continue;
            
                        Q.push({nx,ny});
                        vis[nx][ny] = 1;
                        check_board[nx][ny] = num;
                    }
                }
                
                num++;
            }
        }
    }
}

void check_board_reset()
{
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<n; k++)
        {
            check_board[i][k] = 0;
        }
    }
}

int main()
{
    cin >> n;
    
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<n; k++)
        {
            char a;
            cin >> a;
            
            if(a == 'R')
            {
                board[i][k] = 1;
                board_2[i][k] = 1;
            }
            else if(a == 'B')
            {
                board[i][k] = 2;
                board_2[i][k] = 2;
            }
            else{
                board[i][k] = 3;
                board_2[i][k] = 1;
            }
        }
    }
    

    
    board_func();
    
    int max_num =0;
    
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<n; k++)
        {
            max_num = max(check_board[i][k], max_num);
        }
    }
   
    check_board_reset();
    board_2_func();
    int max_num_2 =0;
    
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<n; k++)
        {
            max_num_2 = max(check_board[i][k], max_num_2);
        }
    }
    
    cout << max_num << " " << max_num_2 << endl;
    
}