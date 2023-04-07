#include <iostream>
#include <string>
#include<cstring>
#include <vector>
#include <stack>
#include <memory.h>
#include <algorithm>
#include <queue>
#include <tuple>
#include <math.h>
#include <set>
#include <map>
using namespace std;
//cin.tie(NULL);
//ios::sync_with_stdio(false);

int f,n,m;

char board[35][35][35];
int dp[35][35][35];
bool vis[35][35][35];

int dx[6] = {1,0,-1,0,0,0};
int dy[6] = {0,1,0,-1,0,0};
int df[6] = {0,0,0,0,1,-1};

void success(int a)
{
    cout << "Escaped in "<<a<< " minute(s)." << endl;
}

void fail()
{
    cout << "Trapped!" << endl;
}

queue<tuple<int,int,int>> Q;


int main()
{
    while(1)
    {
        cin >> f >> n >> m;
        int start_1 =0;
        int start_2 =0;
        int start_3 =0;
        int end_1 =0;
        int end_2 =0;
        int end_3 =0;
        if(n == 0 && m ==0 && f ==0) break;
        for(int i=0; i<f; i++)
        {
            for(int k=0; k<n; k++)
            {
                for(int j=0; j<m; j++)
                {
                    cin >> board[i][k][j];
                    if(board[i][k][j] == 'S')
                    {
                        start_1 = i;
                        start_2 = k;
                        start_3 = j;
                    }
                    
                    if(board[i][k][j] == 'E')
                    {
                        end_1 = i;
                        end_2 = k;
                        end_3 = j;
                    }
                }
            }
        }
        
        Q.push({start_1,start_2,start_3});
        vis[start_1][start_2][start_3] = 1;
         
        while(!Q.empty())
        {
            tuple<int,int,int> cur = Q.front();
            Q.pop();
            //cout << get<0>(cur) << " " << get<1>(cur) << " " << get<2>(cur) << endl;
            for(int dir =0; dir <6; dir++)
            {
                int nx = dx[dir] + get<1>(cur);
                int ny = dy[dir] + get<2>(cur);
                int nf = df[dir] + get<0>(cur);
                
                //cout << nf << " " << nx << " " << ny << endl;
                
                if(0 > nx || nx >= n || 0 > ny || ny >= m || 0 > nf || nf >= f) continue;
                
                //cout << nf << " " << nx << " " << ny << endl;
                if(board[nf][nx][ny] == '#') continue;
                if(vis[nf][nx][ny] == 1) continue;
                
                dp[nf][nx][ny] = dp[get<0>(cur)][get<1>(cur)][get<2>(cur)]+1;
                
                Q.push({nf,nx,ny});
                vis[nf][nx][ny] = 1;
            
            }
        }
        
        if(vis[end_1][end_2][end_3] != 0)
        {
            success(dp[end_1][end_2][end_3]);
        }
        else{
            fail();
        }
        for(int i=0; i<f; i++)
        {
            for(int k=0; k<n; k++)
            {
                for(int j=0; j<m; j++)
                {
                    vis[i][k][j] = 0;
                    board[i][k][j] = 0;
                    dp[i][k][j] = 0;
                }
            }
        }
        
    }
    
}