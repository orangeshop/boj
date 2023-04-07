#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
#include <tuple>
using namespace std;


int board[100][100][100];
bool vis[100][100][100];
int dx[6] = {1,0,-1,0,0,0};
int dy[6] = {0,1,0,-1,0,0};
int dz[6] = {0,0,0,0,1,-1};
int n=0;
int m=0;

int main()
{
    queue<tuple<int,int,int>> Q;
    int answer =0;
    int a=0;
    cin >> m >> n>> a;
    
    int depth =0;
    int x=0;
    int y=0;
    for(int i=0; i<n*a; i++)
    {
        for(int k=0; k<m; k++)
        {
            
            
            cin >> board[x][y][depth];
            
            if(board[x][y][depth]==1)
            {
                Q.push({x,y,depth});
                vis[x][y][depth] =1;
            }
            
            if(y==m-1)
            {
                y=0;
            }else{
                y++;
            }
            
        }
      
        
        if(x == n-1)
        {
            depth++;
            x=0;
        }else{
            x++;
        }
        
    }
    
    
    while(!Q.empty())
    {
        tuple<int,int,int> cur = Q.front(); Q.pop();
        
        for(int i=0; i<6; i++)
        {
            int nx = get<0>(cur) + dx[i];
            int ny = get<1>(cur) + dy[i];
            int nz = get<2>(cur) + dz[i];
            if(nx < 0 || nx >= n || ny <0 || ny >=m || nz < 0 || nz >=a) continue;
            if(vis[nx][ny][nz]==1) continue;
            if(board[nx][ny][nz]==-1) continue;
            
            board[nx][ny][nz]=board[get<0>(cur)][get<1>(cur)][get<2>(cur)]+1;
            //answer = board[nx][ny][get<2>(cur)];
            answer = board[get<0>(cur)][get<1>(cur)][get<2>(cur)];
            
            Q.push({nx,ny,nz});
            vis[nx][ny][nz]=1;
            
            
        }
    }
    
    
    int x_2=0;
    int y_2=0;
    int depth_2=0;
    for(int i=0; i<n*a; i++)
    {
        for(int k=0; k<m; k++)
        {
            
            
            //cout << board[x_2][y_2][depth_2] << " ";
            if(board[x_2][y_2][depth_2]==0)
            {
                answer =-1;
            }
            
            
            if(y_2==m-1)
            {
                y_2=0;
            }else{
                y_2++;
            }
            
        }
        //cout << endl;
        
        if(x_2 == n-1)
        {
            depth_2++;
            x_2=0;
        }else{
            x_2++;
        }
        
    }

    cout << answer << endl;
    
    
}
