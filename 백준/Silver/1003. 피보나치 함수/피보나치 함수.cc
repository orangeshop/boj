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
    vector<pair<int,int>> V;
    
    V.push_back({1,0});
    V.push_back({0,1});
    queue<int> Q;
    for(int i=0; i<a; i++)
    {
        int b=0;
        cin >>b;
        Q.push(b);
    }
    for(int i=2; i< 90; i++)
    {
        int first =0;
        int second =0;
        first = V[i-1].first + V[i-2].first;
        second = V[i-1].second + V[i-2].second;
        
        V.push_back({first,second});
    }
    for(int i=0; i<a; i++)
    {
        int b = 0;
        b= Q.front();
        Q.pop();
        
       
        
        cout << V[b].first << " " << V[b].second<< endl;
        
    }
}
