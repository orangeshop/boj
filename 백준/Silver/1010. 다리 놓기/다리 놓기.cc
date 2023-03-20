#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
using namespace std;


int main()
{
    int a=1;
    cin >> a;
    queue<unsigned long long> Q;
    for(int i=0; i< a; i++)
    {
        int b = 0;
        int c = 0;
        cin >> c >> b;
        unsigned long long num1=1;
        unsigned long long num2=1;
       
            if(c<b-c)
            {
                
            }
            else{
                c = b-c;
            }
        
        for(int i=0; i< c; i++)
        {
            num1 *= b;
            num2 *= i+1;
            b--;
        }
        unsigned long long result =0;
        result = num1/num2;
        Q.push(result);
    }
    
    while(!Q.empty())
    {
        cout << Q.front() << '\n';
        Q.pop();
    }
}