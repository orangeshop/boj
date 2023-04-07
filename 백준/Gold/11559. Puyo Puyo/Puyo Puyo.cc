
#include <iostream>
#include <string>
#include <cstring>
#include <vector>
#include <stack>
#include <memory.h>
#include <algorithm>
#include <queue>
#include <tuple>
#include <math.h>
#include <set>
#include <map>
#include <iterator>

using namespace std;
#define S second
#define F first
#define l long
#define MAX 0x7ffffff
int dx[4] = {-1,0,1,0};
int dy[4] = {0,1,0,-1};
int ddx[8] = {-1,-2,-2,-1,1,2,2,1};
int ddy[8] = {-2,-1,1,2,-2,-1,1,2};
int cdx[8] = {-1,0,1,0,-1,-1,1,1};
int cdy[8] = {0,1,0,-1,-1,1,1,-1};

//cin.tie(NULL);
//ios::sync_with_stdio(false);
//cout.tie(NULL);

int n = 12;
int m = 6;
char board[15][10];
int dp[15][10];
int answer =0;
int i_start = 0;
int k_start = 0;
int max_count =MAX;
bool check = false;
void see()
{
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            cout << dp[i][k] << " ";
        }
        cout << endl;
    }
    cout << "-----------" << endl;
}
void gravity()
{
    queue<char> S;
    
    for(int i= 0; i < m; i++)
    {
        for(int k=n-1; k>=0; k--)
        {
            //cout << k << " " << i << endl;
            //cout << board[k][i] << endl;
            if(board[k][i] == '.') continue;
            S.push(board[k][i]);
        }
        
        for(int k=n-1; k>=0; k--)
        {
            if(S.empty())
            {
                board[k][i] = '.';
                continue;
            }
            board[k][i] = S.front();
            S.pop();
            
        }
    }
    answer++;
    return;
}

void puyo_puyo_pop(int x,int y, char color)
{
    queue<pair<int,int>> Q;
    Q.push({x,y});
    int cnt = 1;
    dp[x][y] = cnt;
    while(!Q.empty())
    {
        pair<int,int> cur = Q.front();
        Q.pop();
        
        for(int dir =0; dir<4; dir++)
        {
            int nx = dx[dir] + cur.F;
            int ny = dy[dir] + cur.S;
            
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(board[nx][ny] != color || dp[nx][ny] != 0) continue;
            cnt++;
            dp[nx][ny] = cnt;
            Q.push({nx,ny});
            
        }
    }

    if(cnt >= 4)
    {
        Q.push({x,y});
        board[x][y] = '.';
        dp[x][y] = 0;
        while(!Q.empty())
        {
            pair<int,int> cur = Q.front();
            Q.pop();
            
            for(int dir =0; dir<4; dir++)
            {
                int nx = dx[dir] + cur.F;
                int ny = dy[dir] + cur.S;
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(board[nx][ny] != color || dp[nx][ny] == 0) continue;
                board[nx][ny] = '.';
                dp[cur.F][cur.S] = 0;
                Q.push({nx,ny});
                
            }
        }
        check = true;
        //gravity();
        
        //return;
    }
    else{
        
        Q.push({x,y});
        dp[x][y] = 0;
        while(!Q.empty())
        {
            pair<int,int> cur = Q.front();
            Q.pop();
            
            for(int dir =0; dir<4; dir++)
            {
                int nx = dx[dir] + cur.F;
                int ny = dy[dir] + cur.S;
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(board[nx][ny] != color || dp[nx][ny] == 0) continue;
                dp[nx][ny] = 0;
                Q.push({nx,ny});
                
            }
        }
        //return;
    }
    //see();
    
}

void find()
{
    check = false;
    for(i_start = 0; i_start<n; i_start++)
    {
        
        for(k_start = 0; k_start<=m; k_start++)
        {
            
            if(i_start == n-1 && k_start == m && check == true)
            {
                //cout << "hi" << endl;
                gravity();
                //see();
                find();
                //break;
            }
            if(board[i_start][k_start] =='.') continue;
            if(dp[i_start][k_start] != 0) continue;
            puyo_puyo_pop(i_start,k_start, board[i_start][k_start]);
            
        }
    }
}

int main()
{
   
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            cin>> board[i][k];
        }
        
    }
   
    find();
    
    
    cout << answer << endl;
    
}
