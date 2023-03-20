#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
using namespace std;

int main()
{
    
    int a;
    cin >> a;
    
    
    int num =0;
    num =a;
    int check=1;
    while(true)
    {
        int b;
        int c;
        int result=0;
        
        b = a/10;
        c = a%10;
        
        result = b+c;
        
        result %= 10;
        c *=10;
        
        
        c+= result;
        a=c;
        
        if(num==a) break;
        
        check++;
    }
    
    cout << check << endl;
}