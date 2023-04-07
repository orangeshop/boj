#include <iostream>
#include <queue>
#include <stack>
#include <vector>
#include <string>
using namespace std;


int n;
int main()
{
    cin >> n;
    
    for(int i=0; i<n; i++)
    {
        if(i==0)
        {
            cout <<"int a;" << endl;
            cout <<"int *ptr = &a;" << endl;
        }
        else{
            
            cout << "int ";
            for(int k=0; k<i+1; k++)
            {
                cout << "*";
            }
            
            if(i+1 == 2)
            {
                cout << "ptr" << i+1 << " = &ptr;" << endl;
            }
            else{
                cout << "ptr" << i+1 << " = &ptr"<< i <<";"<< endl;
            }
            
        }
    }
    
}