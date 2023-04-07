#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
#include <tuple>
using namespace std;


int main()
{
    priority_queue<int,vector<int>,greater<int>> pq;
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int a=0;
    cin >> a;
    
    for(int i=0; i<a; i++)
    {
        int b=0;
        cin >> b;
        pq.push(b);
    }
    
    for(int i=0; i<a; i++)
    {
        cout << pq.top() << '\n';
        pq.pop();
    }
}