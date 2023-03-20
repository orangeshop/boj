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
    scanf("%d", &a);
    
    for(int i=1; i< a+1; i++)
    {
        for(int k=0; k< a; k++)
        {
            if(k==i) break;
            
            cout << "*";
        }
        cout << endl;
    }

}