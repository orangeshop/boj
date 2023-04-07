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
    int b;
    int max;
    int min;
    for(int i=0;i< a; i++)
    {
        cin >> b;
        if(i==0)
        {
            max = b;
            min = b;
        }
        if(max<b)
        {
            max = b;
        }
        if(min>b)
        {
            min =b;
        }
    }

    cout << min << " " << max << endl;
   
}