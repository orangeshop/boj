#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
#include <tuple>
using namespace std;

int dist[100];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int a=0;
    cin >> a;
    priority_queue<int , vector<int>, greater<int>> pq_1;
    for(int i=0; i< a; i++)
    {
        int b=0;
        cin >> b;
        
        pq_1.push(b);
    }
    
    for(int i=0; i< a; i++)
    {
        cout << pq_1.top() << '\n';
        pq_1.pop();
    }
    
   
}