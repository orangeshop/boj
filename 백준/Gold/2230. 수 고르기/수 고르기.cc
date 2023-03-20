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
#define MAX 0x7fffffff
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
//cin.tie(NULL);
//ios::sync_with_stdio(false);

int n,m;
int nm = MAX;
int board[100005];

int main()
{
    cin >> n >> m;
    
    for(int i=0; i<n; i++)
    {
        cin >> board[i];
    }
    sort(board,board+n);
    int en =0;
    for(int st=0; st<n; st++)
    {
        while(en < n && board[en]-board[st] < m)
            en++;
        if(en==n) break;
        nm = min(nm,board[en]-board[st]);
    }
    cout << nm << endl;
}
