#include <iostream>
#include <queue>
#include <stack>
#include <vector>
using namespace std;

int n;
int main()
{
    cin >> n;
    
    for(int i=0; i<n; i++)
    {
        for(int k=n; k>i; k--)
        {
            cout << "*";
        }
        cout << endl;
    }
}
