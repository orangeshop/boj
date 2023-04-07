#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
#include <tuple>
using namespace std;

int board[502][502];
bool vis[502][502];

int dx[8] = {-1,-2,-2,-1,1,2,2,1};
int dy[8] = {-2,-1,1,2,-2,-1,1,2};

int n;
int m;

int main()
{
    
    int a;
    cin >> a;
    vector<int> V;
    for(int k=0; k<a; k++)
    {
    
        cin >> n;
        m=n;
        
        int first_dot =0;
        int second_dot =0;
        
        int d_dot_x =0;
        int d_dot_y =0;
        
        cin >> first_dot >> second_dot;
        cin >> d_dot_x >> d_dot_y;
        
       
        queue<pair<int,int>> Q;
        Q.push({first_dot,second_dot});
        vis[first_dot][second_dot] = 1;
    
        while(!Q.empty())
        {
            pair<int,int> cur = Q.front(); Q.pop();
            for(int i=0; i<8; i++)
            {
                int nx = cur.first + dx[i];
                int ny = cur.second + dy[i];
                
                if(vis[nx][ny]==1) continue;
                if(nx<0 || nx >=n || ny <0 || ny >= m) continue;
                
                board[nx][ny] = board[cur.first][cur.second] +1;
                
                Q.push({nx,ny});
                vis[nx][ny] =1;
                
            }
        }
    
        //cout << board[d_dot_x][d_dot_y] << endl;
        V.push_back(board[d_dot_x][d_dot_y]);
        
        for(int i=0; i< m; i++)
        {
            for(int j=0; j< m; j++)
            {
                board[i][j] =0;
                vis[i][j] =0;
                //cout << board[i][k] << " ";
            }
            //cout << endl;
        }
        
        
    }
    for(int i=0; i<a; i++)
    {
        cout << V[i] << endl;
    }
}
