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
#define l long
#define MAX 0x7ffffff
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int ddx[8] = {-1,-2,-2,-1,1,2,2,1};
int ddy[8] = {-2,-1,1,2,-2,-1,1,2};

//cin.tie(NULL);
//ios::sync_with_stdio(false);


int n,m;
int board[500001];

int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> n;
    
    for(int i=0; i<n; i++)
    {
        cin >> board[i];
    }
    sort(board,board+n);

    cin >> m;
    for(int i=0; i<m; i++)
    {
        int a = 0;
        cin >> a;
        cout << upper_bound(board, board+n, a) - lower_bound(board,board+n,a);
        if(i != m-1)
        {
            cout << " ";
        }
        
    }
}
