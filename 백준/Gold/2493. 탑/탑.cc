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
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
//cin.tie(NULL);
//ios::sync_with_stdio(false);

int n;
int board[500005];
int check_board[500005];
stack<pair<int,int>> S;


int main()
{
    cin >> n;
    
    for(int i=1; i<=n; i++)
    {
        cin >> board[i];
    }
 
    int max_num =0;
    
    for(int i=1; i<=n; i++)
    {
        if(i==1)
        {
            S.push(make_pair(board[i],i));
            check_board[i] = 0;
            max_num = i;
            continue;
        }
        
        if(S.top().first < board[i])
        {
            while(!S.empty())
            {
                //cout <<"while : "<< S.top().first << " " << S.top().second << endl;
                S.pop();
                if(S.size()==0) break;
                if(S.top().first > board[i]) break;
            }
            
            if(S.size() !=0)
            {
                max_num = S.top().second;
            }
            
            if(S.size()== 0)
            {
                S.push(make_pair(board[i], i));
                check_board[i] = 0;
            }
            else{
                
                check_board[i] = max_num;
                S.push(make_pair(board[i], i));
            }
            //cout <<"while out : "<< S.top().first << " " << S.top().second << endl;
            
        }
        
        if(S.top().first > board[i])
        {
            //max_num = i;
            check_board[i] = S.top().second;
            S.push(make_pair(board[i], i));
            
        }
      
    }
    
    for(int i=1; i<=n; i++)
    {
        cout << check_board[i];
        if(n==i)
        {
            break;
        }
        else{
            cout << " ";
        }
    }
}