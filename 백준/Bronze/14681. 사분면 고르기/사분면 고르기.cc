#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
using namespace std;

int main()
{
    int a=0;
    int b=0;
    cin >> a;
    cin >> b;
    
    
    if(a>-1 && b>-1)
    {
        cout << "1";
    }
    else if(1>a && b>-1)
    {
        cout << "2";
    }
    else if(1>a && 1>b)
    {
        cout << "3";
    }
    else if(a>-1 && 1>b)
    {
        cout << "4";
    }
   
    
}
    