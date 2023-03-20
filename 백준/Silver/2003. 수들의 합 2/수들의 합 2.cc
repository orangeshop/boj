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
l l tot;
int board[10005];
int main()
{
    cin >> n >> m;
    
    for(int i=0; i<n; i++)
    {
        cin >> board[i];
    }
    int count =0;
    int en =0;
    for(int st=0; st<n; st++)
    {
        while(en < n && tot < m)
        {
            if(en != n)
            {
                tot += board[en];
                //cout << st << " " << en << " " << tot << endl;
                if(tot==m)
                {
                    count++;
                }
            }
            en++;
        }
        tot -= board[st];
        if(tot==m)
        {
            //cout << st+1 << " " << en-1 << " " << tot << endl;
            count++;
        }
        if(en==n)break;
        
        
    }
    cout << count << endl;
}