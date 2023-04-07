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
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int ddx[8] = {-1,-2,-2,-1,1,2,2,1};
int ddy[8] = {-2,-1,1,2,-2,-1,1,2};

//cin.tie(NULL);
//ios::sync_with_stdio(false);


int n, vir;
int board[55][55];
int dp[11][55][55];
bool vis[11][55][55];
int result_board[55][55];
queue<pair<int,int>> Q;
vector<pair<int,int>> V;
vector<int> V_2;
bool isused[11];
int arr[11];

int result = MAX;

void see(int a)
{
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<n; k++)
        {
            cout << dp[a][i][k] << " ";
        }
        cout << endl;
    }
    
    cout << "----------" << endl;
}

void bfs(int depth, int x, int y)
{
    Q.push(make_pair(x, y));
    vis[depth][x][y] = 1;
    dp[depth][x][y] = 0;
    
    while(!Q.empty())
    {
        pair<int,int> cur = Q.front(); Q.pop();
        for(int dir =0; dir<4; dir++)
        {
            int nx = dx[dir] + cur.F;
            int ny = dy[dir] + cur.S;
            
            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if(vis[depth][nx][ny] == 1 || board[nx][ny] == 1) continue;
            
            dp[depth][nx][ny] = dp[depth][cur.F][cur.S] + 1;
            
            Q.push(make_pair(nx, ny));
            vis[depth][nx][ny] = 1;
        }
    }
    
    //see(depth);
}

void cb(int depth)
{
    if(depth == vir)
    {
        
        int result_result =0;
        
        for(int i=0; i<n; i++)
        {
            for(int k=0; k<n; k++)
            {
                
                int result_sub = MAX;
                for(int dir=0; dir<vir; dir++)
                {
                    //cout << arr[dir] << " ";
                
                    result_sub = min(result_sub, dp[arr[dir]][i][k]);
                    
                }
                //cout << endl;
                
                    result_board[i][k] = result_sub;
                
            }
        }
        
        int check_result =0;
        bool check = false;
        for(int i=0; i<n; i++)
        {
            for(int k=0; k<n; k++)
            {
                //if(check == true) continue;
                if(board[i][k] == 1)
                {
                    //cout << "0 ";
                    //continue;
                }
                if(board[i][k] == 0)
                {
                    if(result_board[i][k] == MAX)
                    {
                        //cout << "insert : " << i << " " << k << endl;
                        check_result = MAX;
                        check = true;
                        //continue;
                    }
                }
                //cout << result_board[i][k] << " ";
                if(result_board[i][k] == MAX) continue;
                check_result = max(check_result, result_board[i][k]);
                
            }
            //cout << endl;
        }
        //cout << "-------------" << endl;
        //cout << check_result << endl;
        result = min(result,check_result);
        return;
    }
    
    
    
    for(int i = 0; i<V_2.size(); i++)
    {
        if(i < arr[depth-1]) continue;
        if(!isused[i])
        {
            
            arr[depth] = i;
            isused[i] = true;
            cb(depth +1);
            isused[i] = false;
        }
    }
    
}

int main()
{
    
    cin >> n >> vir;
    int count = 0;
    for(int i=0; i<n; i++)
    {
        for(int k=0; k<n; k++)
        {
            cin >> board[i][k];
            if(board[i][k] == 2)
            {
                V.push_back(make_pair(i, k));
                V_2.push_back(count);
                count++;
            }
        }
    }
    
    for(int j=0; j<10; j++)
    {
        for(int i=0; i<n; i++)
        {
            for(int k=0; k<n; k++)
            {
                dp[j][i][k] = MAX;
            }
        }
    }
    
    //cout << endl;
    for(int i=0; i<V.size(); i++)
    {
        bfs(i,V[i].F, V[i].S);
    }
   
    cb(0);
    
    
    if(result == MAX)
    {
        cout << "-1" << endl;
    }
    else{
        cout << result << endl;
    }
}