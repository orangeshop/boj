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
    
    cin >> a >> b;
    
    if(a > b)
    {
        cout << ">";
    }else if(a<b)
    {
        cout << "<";
    }else{
        cout << "==";
    }
}