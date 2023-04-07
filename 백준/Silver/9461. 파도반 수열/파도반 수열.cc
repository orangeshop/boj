#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
using namespace std;

int main()
{
    
    vector<long long> V;
    V.push_back(1);
    V.push_back(1);
    V.push_back(1);
    
    int a=0;
    cin >> a;
    queue<int> Q;
    for(int i=0; i< a; i++)
    {
        int b=0;
        cin >> b;
        Q.push(b);
        
    }
    for(int i=3; i< 100; i++)
    {
        V.push_back(V[i-3]+V[i-2]);
    }
    for(int i=0; i< a; i++)
    {
        
        int b=0;
        b=Q.front();
        Q.pop();
        
        cout << V[b-1] << endl;
        
    }
}