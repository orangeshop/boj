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
    
    char b;
    
    int result=0;
    
    for(int i=0; i< a; i++)
    {
        cin >> b;
        result += (int)b-48;
        
    }
    
    cout << result << endl;
}