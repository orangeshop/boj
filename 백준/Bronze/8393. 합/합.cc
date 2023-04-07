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
    int b=0;
    
    for(int i=1; i< a+1; i++)
    {
        b+=i;
    }
    
    cout <<b;

}