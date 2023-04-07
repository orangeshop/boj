
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
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int a=0;
    cin >> a;
    
    vector<string> V;
    deque<int> dq;
    for(int i=0; i< a; i++)
    {
        bool reverse_check = false;
        string str;
        cin >> str;
        
        int size =0;
        
        cin >> size;
        
        string array;
        cin >> array;
        
        int S_size =0; // 자릿수 계산
        stack<int> S;
        for(int k=1; k< array.size(); k++)
        {
            if(size==0) break;
            if(array[k]== ',' || array[k]==']')
            {
                int num=0;
                int num_2 =1;
                for(int j=0; j< S_size; j++)
                {
                    num+= S.top() * num_2;
                    S.pop();
                    num_2 *= 10;
                }
                
                dq.push_back(num);
                S_size=0;
                continue;
            }
            else
            {
                S.push(array[k]-48);
                S_size++;
            }
        }
        
        for(int k=0; k<str.size(); k++)
        {
            if(str[k]=='R')
            {
                if(reverse_check==false)
                {
                    reverse_check = true;
                }
                else if(reverse_check == true)
                {
                    reverse_check = false;
                }
            }
            else if(str[k]=='D')
            {
                if(reverse_check == false) // 정 방향
                {
                    if(dq.empty())
                    {
                        size--;
                        break;
                    }
                    dq.pop_front();
                    size--;
                }
                else if(reverse_check == true) // 역방향
                {
                    if(dq.empty())
                    {
                        size--;
                        break;
                    }
                    dq.pop_back();
                    size--;
                }
            }
        }
        
        
        
        if(size<0)
        {
            V.push_back("error");
           
        }
        else
        {
            string make_array = "[";
            int dq_size = dq.size();
            for(int k=0; k< dq_size; k++)
            {
                if(reverse_check == false) // 정 방향
                {
                    make_array +=  to_string(dq.front());
                    dq.pop_front();
                }
                else if(reverse_check == true) // 역방향
                {
                    make_array += to_string(dq.back());
                    dq.pop_back();
                }
                
                if(k != dq_size-1)
                {
                    make_array += ',';
                }
            }
            make_array += ']';
            V.push_back(make_array);
        }
        
       
    }
    
    for(int i=0; i< V.size(); i++)
    {
        cout << V[i] << endl;;
        
    }
}