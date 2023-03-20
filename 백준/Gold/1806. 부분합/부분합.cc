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
    
    int en =0;
    int tot = board[0];
    for(int st=0; st<n; st++)
    {
        while(en < n && tot<m)
        {
            en++;
            if(en!=n)
            {
                tot += board[en];
            }
           
        }
        if(en==n) break;
        nm = min(nm, en-st+1);
        tot -= board[st];
    }
    if(nm == MAX) nm =0;
    cout << nm << endl;
}