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

int n;
int board[1000005];
vector<int> board2;

int main()
{
    
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    
    cin >> n;
    
    for(int i=0; i<n; i++)
    {
        cin >> board[i];
        board2.push_back(board[i]);
    }
    
    sort(board2.begin(),board2.end());
    board2.erase(unique(board2.begin(),board2.end()), board2.end());

    
    for(int i=0; i<n; i++)
    {
        cout <<  lower_bound(board2.begin() , board2.end() , board[i]) - board2.begin();
        if(i != n-1)
        {
            cout << " ";
        }
    }
}