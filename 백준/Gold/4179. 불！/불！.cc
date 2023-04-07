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
#define S second
#define F first

//cin.tie(NULL);
//ios::sync_with_stdio(false);

int n,m;

int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

char board[1005][1005];
int dp[1005][1005];
bool vis[1005][1005];
pair<char,pair<int,int>> Human_Start;
pair<char,pair<int,int>> Fire_Start;
queue<pair<char,pair<int,int>>> Q;
void success(int a)
{
    cout << a << endl;
}

void fail()
{
    cout << "IMPOSSIBLE" << endl;
}

void see()
{
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            cout <<  dp[i][k] << " ";
        }
        cout << endl;
    }
}




int main()
{
   
    cin >> n >> m;
   
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            cin >> board[i][k];
            
            dp[i][k] = 0x7fffff;
            
            if(board[i][k] == 'J')
            {
                dp[i][k] =1;
                Human_Start = make_pair('J',make_pair(i, k));
            }
            
            if(board[i][k] == 'F')
            {
                Fire_Start = make_pair('F',make_pair(i, k));
                Q.push(make_pair('F',make_pair(Fire_Start.S.F,Fire_Start.S.S)));
                vis[Fire_Start.S.F][Fire_Start.S.S] = 1;
            }
        }
    }
    

    
    
    Q.push(make_pair('J',make_pair(Human_Start.S.F,Human_Start.S.S)));
    
    vis[Human_Start.S.F][Human_Start.S.S] = 1;
    
    
    while(!Q.empty())
    {
        pair<char,pair<int,int>> cur = Q.front(); Q.pop();
        //cout << cur.F<<" " << cur.S.F << " " << cur.S.S <<endl;
        for(int dir = 0; dir <4; dir++)
        {
            int nx = dx[dir] + cur.S.F;
            int ny = dy[dir] + cur.S.S;
            
            if(0 > nx || nx >= n || 0 > ny || ny >=m) continue;
            if(board[nx][ny] == '#' || vis[nx][ny] == 1) continue;
            
            if(cur.first == 'J')
            {
                dp[nx][ny] = dp[cur.S.F][cur.S.S]+1;
                Q.push(make_pair('J', make_pair(nx, ny)));
                vis[nx][ny] = 1;
            }
            else{
                Q.push(make_pair('F', make_pair(nx, ny)));
                vis[nx][ny] = 1;
            }
        }
    }
    
    int min_num = 0x7fffff;
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<m; k++)
        {
            
            if(i != 0 && i != n-1 && k != 0 && k != m-1) continue;
            if(board[i][k] == '#') continue;
            
            min_num = min(min_num , dp[i][k]);
        }
    }
    
    if(min_num == 0x7fffff)
    {
        fail();
    }
    else{
        success(min_num);
    }
    //see();
  
}