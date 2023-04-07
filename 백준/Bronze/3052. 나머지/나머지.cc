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
    int result =0;
    int d[1000];
    
    for(int i=0; i< 1000; i++)
    {
        d[i]=0;
    }
    
    for(int i=0; i< 10; i++)
    {
        cin >> a;
        result = a%42;
       
        for(int i=0; i< 1000; i++)
        {
            if(result == i)
            {
                d[i] +=1;
            }
        }
        
    }
    int check=0;
    
    for(int i=0; i< 100; i++)
    {
        if(d[i] != 0)
        {
            check++;
        }
    }
    
    cout << check << endl;

}
   