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
int n,L,R;
int L_R;
int board[55][55];
bool vis[55][55];
bool insert_num[55][55];
int sum;
int answer =0;
bool final_return;
queue<pair<pair<int,int>,int>> result;
queue<pair<int,int>> Q;

void see()
{
    for(int i=0; i< n; i++)
    {
        for(int k=0; k<n; k++)
        {
            //cout << board[i][k] << " ";
            vis[i][k] = 0;
            insert_num[i][k] = 0;
        }
        //cout << endl;
    }
}

int average(int sum,int count)
{
    return sum/count;
}
int calc(int now , int next)
{
    int inside_num = 0;
    inside_num = now - next;
    if(now - next < 0)
    {
        inside_num *= -1;
    }
    return inside_num;
}

int L_R_calc()
{
    int inside_num = 0;
    inside_num = R - L;
    
    return inside_num;
}
void bfs(int x,int y)
{
    if(vis[x][y] == 1) return;
    Q.push({x,y});
    vis[x][y] = 1;
    int size = 1;
    int sum = 0;
    queue<pair<pair<int,int>,int>> inner_Q;
    inner_Q.push(make_pair(make_pair(x, y), board[x][y]));
    sum += board[x][y];
    
    while(!Q.empty())
    {
        pair<int,int> cur = Q.front();
        Q.pop();
        
        for(int dir =0; dir<4; dir++)
        {
            int nx = dx[dir] + cur.F;
            int ny = dy[dir] + cur.S;
            
            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if(board[nx][ny] == board[cur.F][cur.S]) continue;
            if(vis[nx][ny] == 1) continue;
            if( (L <= calc(board[cur.F][cur.S] ,board[nx][ny]) && (calc(board[cur.F][cur.S] ,board[nx][ny]) <= R)) == true)
            {
                //if(insert_num[x][y] == 1) continue;
                //insert_num[x][y] = 1;
                inner_Q.push(make_pair(make_pair(nx, ny), board[nx][ny]));
                Q.push({nx,ny});
                sum += board[nx][ny];
                vis[nx][ny] = 1;
                size++;
            }
        }
    }
    
    
    if(size > 1)
    {
        while(!inner_Q.empty())
        {
            pair<pair<int, int>, int> cur = inner_Q.front();
            inner_Q.pop();
            int avg = average(sum, size);
            result.push(make_pair(make_pair(cur.F.F, cur.F.S), avg));
        }
    }
    else{
        
    }
    
    //see();
}
void func()
{
    if(final_return == true)
    {
        //return;
    }
    
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<n; k++)
        {
            //if(vis[i][k] == 1) continue;
            bfs(i,k);
            
            if(i == n-1 && k == n-1)
            {
                if(result.size() == 0) return;
                while(!result.empty())
                {
                    pair<pair<int,int>,int> cur = result.front();
                    result.pop();
                    //cout << cur.F.F << " " << cur.F.S << " " << cur.S << endl;
                    
                    board[cur.F.F][cur.F.S] = cur.S;
                }
                answer++;
                
                see();
                func(); //나중에 해제
            }
        }
    }
    
    
}

int main()
{
    cin >> n >> L >> R;
    
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<n; k++)
        {
            cin >> board[i][k];
        }
    }
    
    
    func();
    
    cout << answer << endl;
    
}