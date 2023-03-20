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
    cin >>a;
    double b[1000];
    for(int i=0; i< a; i++)
    {
        int c=0;
        cin >>c;
        b[i] =c;
    }
    int max=0;
    
    for(int i=0; i<a; i++)
    {
        if(i==0)
        {
            max = b[i];
        }
        if(max<b[i])
        {
            max = b[i];
        }
        
    }
  
    for(int i=0; i<a; i++)
    {
       
        b[i] = b[i]/max*100;
        
    }
  
    
    
    double result =0;
    
    for(int i=0; i<a; i++)
    {
        result += b[i];
    }
    
    result /=a;
    cout.precision(10);
    cout << (double)result << endl;
}