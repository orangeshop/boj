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
    int b;
    int c;
    
    cin >> a >> b >> c;
    
    int result=0;
    int result2 =0;
    int result3=0;
    result = a+b;
    result %=c;
    cout << result << endl;
    
    result =0;
    result = a%c;
    result2 = b%c;
    result3 = result + result2;
    result3 %= c;
    cout << result3 << endl;
    
    result =0;
    result = a*b;
    result %=c;
    cout << result << endl;
    
    result =0;
    result2 =0;
    result3 =0;
    
    result = a%c;
    result2 = b%c;
    result3 = result * result2;
    result3 %= c;
    cout << result3 << endl;
   
    
    
}