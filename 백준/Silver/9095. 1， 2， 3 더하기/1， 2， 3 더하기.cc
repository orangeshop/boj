#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
using namespace std;
int d[1000];
int main()
{
    int a=0;
    cin >> a;
    d[1]=1;
    d[2]=2;
    d[3]=4;
    for(int i=0; i< 1000; i++)
    {
        for(int i=4; i<1000; i++)
        {
            d[i] = d[i-1] + d[i-2] + d[i-3];
        }
    }
    
    for(int i=0; i<a;i++)
    {
        int b=0;
        cin >> b;
        cout << d[b] << endl;
    }
    
}