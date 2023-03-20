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
#include <list>
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

int lc[100];
int rc[100];

int N;
char node1, node2, node3;

void pre(int cur)
{
    cout << char(cur+'A'-1);
    if(lc[cur] != 0) pre(lc[cur]);
    if(rc[cur] != 0) pre(rc[cur]);
}

void pre1(int cur)
{
    if(lc[cur] != 0) pre1(lc[cur]);
    cout << char(cur+'A'-1);
    if(rc[cur] != 0) pre1(rc[cur]);
}

void pre2(int cur)
{
    if(lc[cur] != 0) pre2(lc[cur]);
    if(rc[cur] != 0) pre2(rc[cur]);
    cout << char(cur+'A'-1);
}



int main()
{
    cin >> N;
    
    for(int i=0; i<N; i++)
    {
        cin >> node1 >> node2 >> node3;
        
        if(node2 != '.') lc[node1-'A'+1] = node2-'A'+1;
        if(node3 != '.') rc[node1-'A'+1] = node3-'A'+1;
       
    }
    
    for(int i=0; i<=N; i++)
    {
        if(lc[i]== -18) lc[i] = 0;
        if(rc[i]== -18) rc[i] = 0;
    }
    
    for(int i=0; i<=N; i++)
    {
        //cout << rc[i] << " ";
    }
    
    

    pre(1);
    cout << endl;
    pre1(1);
    cout << endl;
    pre2(1);
    cout << endl;
   
}