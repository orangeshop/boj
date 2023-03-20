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
    int c=0;
    
    int result =0;
    cin >> a;
    cin >> b;
    cin >> c;
    
    result = a*b*c;
    
    string str = to_string(result);
    
    int d[10];
    
    for(int i=0; i< 10; i++)
    {
        d[i]=0;
    }
    
    for(int i=0; i< str.size(); i++)
    {
        if(str[i]=='0')
        {
            d[0] +=1;
        }
        else if(str[i]=='1')
        {
            d[1] +=1;
        }
        else if(str[i]=='2')
        {
            d[2] +=1;
        }
        else if(str[i]=='3')
        {
            d[3] +=1;
        }
        else if(str[i]=='4')
        {
            d[4] +=1;
        }
        else if(str[i]=='5')
        {
            d[5] +=1;
        }
        else if(str[i]=='6')
        {
            d[6] +=1;
        }
        else if(str[i]=='7')
        {
            d[7] +=1;
        }
        else if(str[i]=='8')
        {
            d[8] +=1;
        }
        else if(str[i]=='9')
        {
            d[9] +=1;
        }
        
    }
    
    for(int i=0; i< 10; i++)
    {
        cout << d[i] << endl;
    }
        
    
    
}