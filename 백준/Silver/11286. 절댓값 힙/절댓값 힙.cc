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
   //절댓값 힙 큐 두개 사용
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    priority_queue<int> pq; // 내림 차순
    priority_queue<int , vector<int>, greater<int>> pq_1; // 오름차순
    
    int a=0;
    cin >> a;
    vector<int> V;
    for(int i=0; i<a ; i++)
    {
        int b=0;
        cin >> b;
        
        if(b < 0)
        {
            pq.push(b);
        }
        else if(b >0)
        {
            pq_1.push(b);
        }
        else if(b==0)
        {
            if(pq.empty() && pq_1.empty())
            {
                V.push_back(0);
                //cout << "0" << endl;
            }
            else if(pq.empty())
            {
                V.push_back(pq_1.top());
                //cout << pq_1.top() << endl;
                pq_1.pop();
            }
            else if(pq_1.empty())
            {
                V.push_back(pq.top());
                //cout << pq.top() << endl;
                pq.pop();
            }
            else if((pq.top()*(-1)) < pq_1.top())
            {
                V.push_back(pq.top());
                //cout << pq.top() << endl;
                pq.pop();
            }
            else if((pq.top()*-(1)) > pq_1.top())
            {
                V.push_back(pq_1.top());
                //cout << pq_1.top() << endl;
                pq_1.pop();
            }
            else if((pq.top()*-(1)) == pq_1.top())
            {
                V.push_back(pq.top());
                //cout << pq.top() << endl;
                pq.pop();
            }
            
        }
        
    }
    
    for(int i=0; i< V.size(); i++)
    {
        cout << V[i] << '\n';
    }
    
    
}