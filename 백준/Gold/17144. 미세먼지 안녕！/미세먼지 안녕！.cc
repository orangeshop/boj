
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
pair<int,int> Air_Clean_Up =make_pair(0, 0);
pair<int,int> Air_Clean_Bottom = make_pair(0, 0);
int board[51][51];
int n,m,t;

bool IsOutBound(int x, int y)
{
    return x < 0 || x >= n || y < 0 || y >= m;
}

void see(){
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            cout << board[i][k] << " ";
        }
        cout << endl;
    }
}



void Clean_Up(int x, int y)
{
    int corner_x_m = board[x][m-1];
    int corner_0_m = board[0][m-1];
    int corner_0_0 = board[0][0];
    int arr[1025] = {0, };
    int X = x;
    
    //cout << corner_x_m << " " << corner_0_m<< " "<<corner_0_0 << " " << endl;
   
    
    for(int i=1; i<m; i++)
    {
        arr[i+1] = board[x][i];
    }
    for(int i=1; i<m; i++)
    {
        board[x][i] = arr[i];
    }
    // left -> right
    
    memset(arr, 0, sizeof(int)*1025);
    
    for(int i=x; i>=1; i--)
    {
        arr[i] = board[i][m-1];
    }
    
    for(int i=x; i>=0; i--)
    {
        if(i-1 < 0) break;
        board[i-1][m-1] = arr[i];
    }
    board[x-1][m-1] = corner_x_m;
    
    //right -> up
    
    memset(arr, 0, sizeof(int)*1025);
    
    
    
    for(int i=m-2; i>=0; i--)
    {
        arr[i-1] = board[0][i];
       
    }
    
    for(int i=m-2; i>=0; i--)
    {
        board[0][i] = arr[i];
        
    }
    
    board[0][m-2] = corner_0_m;
    
    //right ->> left
    
    memset(arr, 0, sizeof(int)*1025);
    
   
    
    for(int i=1; i<X; i++)
    {
        if(i+1 > X) break;
        arr[i+1] = board[i][0];
    }
    
    for(int i=1; i<X; i++)
    {
        board[i][0] = arr[i];
    }
    
    board[1][0] = corner_0_0;
    //see();
    
}

void Clean_Bottom(int x, int y)
{
    int corner_x_m = board[x][m-1];
    int corner_n_m = board[n-1][m-1];
    int corner_n_0 = board[n-1][0];
    int arr[1025] = {0, };
    
    for(int i=1; i<m; i++)
    {
        arr[i] = board[x][i];
    }
    for(int i=0; i<m; i++)
    {
        board[x][i+1] = arr[i];
    }
    memset(arr, 0, sizeof(int)*1025);
    for(int i=x; i<n; i++)
    {
        arr[i] = board[i][m-1];
    }
    
    for(int i=x; i<n; i++)
    {
        board[i+1][m-1] = arr[i];
    }
    
    board[x+1][m-1] = corner_x_m;
    memset(arr, 0, sizeof(int)*1025);
    
    
    for(int i=m-2; i>0; i--)
    {
        arr[i] = board[n-1][i];
    }
    for(int i=m-2; i>0; i--)
    {
        board[n-1][i-1] = arr[i];
    }
    board[n-1][m-2] = corner_n_m;
    memset(arr, 0, sizeof(int)*1025);
    for(int i = n-2; i>x; i--)
    {
        arr[i] = board[i][0];
        
    }
    for(int i = n-2; i>x+1; i--)
    {
        board[i-1][0] = arr[i];
        
    }
    board[n-2][0] = corner_n_0;
    
    //see();
}


void bfs()
{
    queue<pair<int,int>> Q;
    queue<tuple<int,int,int>> Info; // result, x ,y
    int dx[4] = {1,0,-1,0};
    int dy[4] = {0,1,0,-1};
    
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            if(board[i][k] !=0)
            {
                if(board[i][k] == -1)
                {
                    continue;
                }
                Q.push({i,k});
                
                while(!Q.empty())
                {
                    pair<int,int> cur = Q.front();
                    Q.pop();
                    int count =0;
                    
                    // 먼저 가능한 위치 탐색 = count
                    // 마지막에 최종적으로 바뀌어야 해서 전부 Info에 넣어서 한꺼번에 재정의
                    //
                    for(int dir =0; dir<4; dir++)
                    {
                        int nx = cur.first + dx[dir];
                        int ny = cur.second + dy[dir];
                        
                        if(IsOutBound(nx, ny)) continue;
                        if(board[nx][ny] == -1) continue;
                        count++;
                        Info.push(make_tuple(board[cur.first][cur.second]/5 , nx,ny));
                    }
                    
                    int result = board[cur.first][cur.second] -= ((board[cur.first][cur.second] / 5 ) * count);
                    Info.push(make_tuple(result,cur.first,cur.second));
                }
            }
            
            
        }
        
        
    }
    
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            if(board[i][k] == -1) continue;
            board[i][k] = 0;
        }
    }
    while(!Info.empty())
    {
        
        //cout << get<0>(Info.front()) << " ";
        //cout << get<1>(Info.front()) << " ";
        //cout << get<2>(Info.front()) << " ";
        
        board[get<1>(Info.front())][get<2>(Info.front())] += get<0>(Info.front());
        Info.pop();
    }
}

int Final_check(int a)
{
    
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            if(board[i][k] == -1) continue;
            a += board[i][k];
        }
    }
    
    return a;
}

int main()
{
    cin >> n >> m >> t;
    
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            cin >> board[i][k];
            if(board[i][k] == -1)
            {
                if(Air_Clean_Up.first == 0 && Air_Clean_Up.second == 0)
                {
                    Air_Clean_Up.first = i;
                    Air_Clean_Up.second = k;
                }
                else{
                    Air_Clean_Bottom.first = i;
                    Air_Clean_Bottom.second = k;
                }
            }
        }
    }
    
    for(int i=0; i<t; i++)
    {
        bfs();
        Clean_Up(Air_Clean_Up.first,Air_Clean_Up.second);
        Clean_Bottom(Air_Clean_Bottom.first, Air_Clean_Bottom.second);
        //see();
    }
    
    cout << Final_check(0) << endl;
}