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
    int b=0; // b보다 d가 작으면
    vector<int> c;
    int f=0;
    cin >> a >> b;
    
    for(int i=0; i< a; i++)
    {
        int d=0;
        cin >> d;
        
        if(b>d)
        {
            c.push_back(d);
        }
    }
    
    for(int i=0; i< c.size(); i++)
    {
        cout << c[i] << " ";
    }

}
    