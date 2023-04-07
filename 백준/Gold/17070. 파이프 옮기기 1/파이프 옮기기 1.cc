#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
#include <tuple>
#include <math.h>
#include <set>
#include <map>
using namespace std;
//cin.tie(NULL);
//ios::sync_with_stdio(false);

int dx[3] = {0,1,1};
int dy[3] = {1,1,0};
int board[20][20];

int n;
int result;
int main()
{
    cin >> n;
    
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<n; k++)
        {
            cin >> board[i][k];
            
        }
    }
    
    queue<tuple<int,int,int,int>> q;
    
    q.push({0,0,0,1});
    
    while(!q.empty())
    {
        
        
        tuple<int,int,int,int> cur = q.front();
        //cout << get<2>(cur) << " " << get<3>(cur) << endl;
        q.pop();
        
        int check_x =0;
        int check_y =0;
        
        check_x = get<0>(cur) - get<2>(cur);
        check_y = get<1>(cur) - get<3>(cur);
        
        if(check_x < 0) check_x *= -1;
        if(check_y < 0) check_y *= -1;
        
        
        if(check_x == 0 && check_y == 1)
        {
            for(int i=0; i<2; i++)
            {
                int nx = get<2>(cur) + dx[i];
                int ny = get<3>(cur) + dy[i];
                
                if(board[nx][ny] == 1) continue;
                if(0 >  nx || nx > n ||0 >  ny || ny > n) continue;
                if(i==1)
                {
                    if(board[get<2>(cur)][get<3>(cur)+1] == 1 || board[get<2>(cur)+1][get<3>(cur)] == 1) continue;
                }
                    
                if(nx == n-1 && ny == n-1)
                {
                    result++;
                }
                q.push({get<2>(cur), get<3>(cur), nx, ny});
            }
            
            
        }
        else if(check_x == 1 && check_y == 1)
        {
            for(int i=0; i<3; i++)
            {
                int nx = get<2>(cur) + dx[i];
                int ny = get<3>(cur) + dy[i];
                
                if(board[nx][ny] == 1) continue;
                if( 0 >  nx || nx > n ||0 >  ny || ny > n) continue;
                if(i==1)
                {
                    if(board[get<2>(cur)][get<3>(cur)+1] == 1 || board[get<2>(cur)+1][get<3>(cur)] == 1) continue;
                }
                if(nx == n-1 && ny == n-1)
                {
                    result++;
                }
                q.push({get<2>(cur), get<3>(cur), nx, ny});
            }
        }
        else if(check_x == 1 && check_y == 0)
        {
            for(int i=1; i<3; i++)
            {
                int nx = get<2>(cur) + dx[i];
                int ny = get<3>(cur) + dy[i];
                
                if(board[nx][ny] == 1) continue;
                if( 0 >  nx || nx > n ||0 >  ny || ny > n) continue;
                if(i==1)
                {
                    if(board[get<2>(cur)][get<3>(cur)+1] == 1 || board[get<2>(cur)+1][get<3>(cur)] == 1) continue;
                }
                if(nx == n-1 && ny == n-1)
                {
                    result++;
                }
                q.push({get<2>(cur), get<3>(cur), nx, ny});
            }
        }
            
        
    }
    
    cout << result << endl;
    
    
    
}