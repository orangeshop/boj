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
    cin>> a;
    
    int answer=0;
    
    for(int i=0; i< a; i++)
    {
        int result =0;
        string part_1 = to_string(i);
        result += i;
        for(int i=0; i< part_1.size(); i++)
        {
            
            result += part_1[i]-48;
        }
        
        if(result == a)
        {
            answer = i;
            break;
        }
        
        
    }
    
    cout << answer << endl;
}