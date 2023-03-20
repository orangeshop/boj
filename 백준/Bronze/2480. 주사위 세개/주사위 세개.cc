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
int a,b,c;
int main()
{
    cin >> a >> b >> c;
    int result = 0;
    if(a == b && b == c)
    {
        result = 10000 + (a*1000);
        cout << result << endl;
        return 0;
    }
    else if(a==b){
        result = 1000 + (a*100);
        cout << result << endl;
        return 0;
    }
    else if(c==b){
        result = 1000 + (c*100);
        cout << result << endl;
        return 0;
    }
    else if(a==c){
        result = 1000 + (a*100);
        cout << result << endl;
        return 0;
    }
    else{
        int max_num = max({a,b,c});
        cout << max_num * 100 << endl;
        return 0;
    }
}