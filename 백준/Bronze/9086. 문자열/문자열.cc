#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
using namespace std;

int main()
{
    int a =0;
    cin >> a;
    
    for(int i =0; i<a; i++)
    {
        string str ="";
        cin >> str;
        cout << str[0]<<str[str.size()-1]<<endl;
     }
        
}