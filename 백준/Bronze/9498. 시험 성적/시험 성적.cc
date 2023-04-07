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
    
    cin >> a;
    
    
    if(a>89)
    {
        cout << "A" << endl;
    }
    else if(90> a && a>79)
    {
        cout << "B"<< endl;
    }
    else if(80> a && a>69)
    {
        cout << "C"<< endl;
    }
    else if(70> a && a>59)
    {
        cout << "D"<< endl;
    }
    else if(60>a)
    {
        cout << "F"<< endl;
    }
    
}