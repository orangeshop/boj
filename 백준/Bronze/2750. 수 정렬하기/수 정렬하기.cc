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
    vector<int> V;
    for(int i=0; i<a; i++)
    {
        int b=0;
        cin >> b;
        V.push_back(b);
    }
    sort(V.begin(), V.end());
    for(int i=0; i<a; i++)
    {
        cout << V[i] << endl;
    }
    
}