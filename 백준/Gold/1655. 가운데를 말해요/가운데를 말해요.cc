#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
#include <tuple>
using namespace std;
//cin.tie(NULL);
//ios::sync_with_stdio(false);




int arr[100000];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int b=0;
    cin >> b;

    
    priority_queue<int,vector<int>> pq_1; // 내림 차순
    priority_queue<int,vector<int>,greater<int>> pq_2; // 오름 차순
    
    
   
    for(int i=0; i< b; i++)
    {
        int a=0;
        cin >> a;
        
        if(i==0)
        {
            pq_1.push(a);
            arr[i]=a;
            continue;
        }
        else if(i==1)
        {
            if(pq_1.top() > a)
            {
                pq_2.push(pq_1.top());
                pq_1.pop();
                pq_1.push(a);
               
            }
            else{
                pq_2.push(a);
                
            }
        }
        else
        {
            
            if(a<0)
            {
                if(pq_2.top() >= a)
                {
                    pq_1.push(a);
                }
                else if(pq_1.top() <= a)
                {
                    pq_2.push(a);
                }
            }
            else{
                
                
                if(pq_2.top() >= a)
                {
                    pq_1.push(a);
                }
                else if(pq_1.top() <= a)
                {
                    pq_2.push(a);
                }
            }
            /*
            if(pq_2.top() > a)
            {
                pq_1.push(a);
            }
            else if(pq_1.top() < a)
            {
                pq_2.push(a);
            }*/
        }
        
        if(pq_1.size()+2 == pq_2.size())
        {
            pq_1.push(pq_2.top());
            pq_2.pop();
        }
        else if(pq_1.size() == pq_2.size()+2)
        {
            pq_2.push(pq_1.top());
            pq_1.pop();
        }
        
        
        if(pq_1.size() == pq_2.size())
        {
            if(pq_1.top() == pq_2.top())
            {
                arr[i] = pq_1.top();
                continue;
            }
            if(pq_1.top() > pq_2.top())
            {
                arr[i] = pq_2.top();
                continue;
            }
            else if(pq_1.top() < pq_2.top())
            {
                arr[i] = pq_1.top();
                continue;
            }
        }
        else if(pq_1.top() == pq_2.top())
        {
            arr[i] = pq_1.top();
            continue;
        }
        else if(pq_1.size() > pq_2.size())
        {
            arr[i] = pq_1.top();
            continue;
        }
        else if(pq_1.size() < pq_2.size())
        {
            arr[i] = pq_2.top();
            continue;
        }
        
        
        
     
    }
    
    /*
    int size =pq_1.size();
    for(int i=0; i< size; i++)
    {
        cout << pq_1.top() << " ";
        pq_1.pop();
    }
    cout << endl;
    
    int size1 =pq_2.size();
    for(int i=0; i< size1; i++)
    {
        cout << pq_2.top() << " ";
        pq_2.pop();
    }
    
    cout << endl;
    */
    for(int i=0; i< b; i++)
    {
        cout << arr[i] << '\n';
    }
}