#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
#include <tuple>
using namespace std;

int board[100][100];
bool vis[100][100];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int n=0;
int m=0;

int main()
{
    queue<pair<int,int>> Q;
    vector<int> V;
    int loop =0;
    cin >> loop;
    int loop_2=0;
    for(int i=0; i< loop; i++)
    {
        int cnt =0;
        cin >> m >>n >> loop_2;
        
        for(int i=0; i< loop_2; i++)
        {
            int a=0;
            int b=0;
            cin >> a >> b;
            board[a][b] =1;
        }

        for(int i=0; i<m; i++)
        {
            for(int k=0; k<n; k++)
            {
                //cout << board[i][k] << " ";
            }
            //cout << endl;
        }
        
        for(int i=0; i< m; i++)
        {
            for(int k=0; k<n; k++)
            {
                if(board[i][k] == 1)
                {
                    Q.push({i,k});
                    board[i][k] =2;
                    vis[i][k]=1;
                    //cout <<"("<< i << ", " << k << ") ->";
                    while(!Q.empty())
                    {
                        pair<int,int> cur = Q.front(); Q.pop();
            
                        //cout << cur.first <<"," << cur.second << "->";
                        for(int i=0; i<4; i++)
                        {
                            int nx = dx[i] + cur.first;
                            int ny = dy[i] + cur.second;
                            
                            if(board[nx][ny]==0) continue;
                            if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                            if(vis[nx][ny] == 1) continue;
                    
                            board[nx][ny] =2;
                            Q.push({nx,ny});
                            vis[nx][ny] =1;
                        }
                    }
                    cnt++;
                   
                }
               
            }
        }
        for(int i=0; i<m; i++)
        {
            for(int k=0; k<n; k++)
            {
                //cout << board[i][k] << " ";
            }
            //cout << endl;
        }
        V.push_back(cnt);
            
        for(int i=0; i<m; i++)
        {
            for(int k=0; k<n; k++)
            {
                board[i][k]=0;
                vis[i][k]=0;
                
            }
            
        }
        
    }
    
    for(int i=0; i< V.size(); i++)
    {
        cout << V[i] << endl;
    }
  
}
