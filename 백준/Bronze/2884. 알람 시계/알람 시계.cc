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

    if(0>b-45)
    {
        b = 60+(b-45);
        a--;
        
        if(0>a)
        {
            a=23;
        }
        
        cout << a <<" "<< b << endl;
    }else{
        cout << a << " "<< b-45 << endl;
    }
    
    
    
}