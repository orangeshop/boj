
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
    cin >>b;
    
    int c[3];
    
    c[0] = b/100;
    c[1] = (b/10)%10;
    c[2] = b%10;
        
    cout << a*c[2] << endl;
    cout << a*c[1] << endl;
    cout << a*c[0] << endl;
    
    int d[3];
    d[0] =a*c[2];
    d[1] =a*c[1]*10;
    d[2] =a*c[0]*100;
    cout << d[0]+d[1]+d[2] << endl;

    
}