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

int main()
{
    string str = "";
    
    cin >> str;
    
    if(str == "A+")
    {
        cout << "4.3";
    }
    else if(str == "A0")
    {
        cout << "4.0";
    }
    else if(str == "A-")
    {
        cout << "3.7";
    }
    else if(str == "B+")
    {
        cout << "3.3";
    }
    else if(str == "B0")
    {
        cout << "3.0";
    }
    else if(str == "B-")
    {
        cout << "2.7";
    }
    else if(str == "C+")
    {
        cout << "2.3";
    }
    else if(str == "C0")
    {
        cout << "2.0";
    }
    else if(str == "C-")
    {
        cout << "1.7";
    }
    else if(str == "D+")
    {
        cout << "1.3";
    }
    else if(str == "D0")
    {
        cout << "1.0";
    }
    else if(str == "D-")
    {
        cout << "0.7";
    }
    else if(str == "F")
    {
        cout << "0.0";
    }
}
