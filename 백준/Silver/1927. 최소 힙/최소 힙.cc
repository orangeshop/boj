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
    priority_queue<int , vector<int>, greater<int> > pq;
    int a;
    cin >> a;
    vector<int> V;
    for(int i=0; i<a; i++)
    {
        int b=0;
        cin >> b;
        
        if(b==0)
        {
            if(pq.empty())
            {
                V.push_back(0);
            }else{
            
                V.push_back(pq.top());
                pq.pop();
                
            }
        }
        else{
            pq.push(b);
        }
    }
   
    for(int i=0; i< V.size(); i++)
    {
        cout << V[i] << '\n';
    }
    
}