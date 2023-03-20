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
        for(int k=a; k>0; k--)
        {
            if(k<i+1){
            
            cout << "*";
            }else{
                cout << " ";
            }
        }
        cout << endl;
    }

}