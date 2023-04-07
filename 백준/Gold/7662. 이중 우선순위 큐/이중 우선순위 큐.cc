#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
#include <tuple>
#include <math.h>
#include <set>
using namespace std;
//cin.tie(NULL);
//ios::sync_with_stdio(false);

int n;
multiset<int> S;
multiset<int>:: iterator iter;
void delete_ple()
{
    if(S.empty()) return;
    int a =0;
    a = (*(--S.end()));
    
    
    
    
    iter = S.find(a);
    S.erase(iter);
    
}

void delete_min()
{
    if(S.empty()) return;
    int a =0;
    
    a = *S.begin();
    
    iter = S.find(a);
    S.erase(iter);
}

void insert_algo(int a)
{
    S.insert(a);
}

int main()
{
    
    cin >> n;
    for(int i=0; i<n; i++)
    {
        int num =0;
        cin >> num;
        
        for(int k=0; k<num; k++)
        {
            string str;
            int insert_num =0;
            
            cin >> str >> insert_num;
            
            if(str[0]=='I')
            {
                insert_algo(insert_num);
            }
            
            if(str[0] == 'D')
            {
                if(insert_num == 1)
                {
                    delete_ple();
                }
                else{
                    delete_min();
                }
            }
        }
        int number=0;
        for(iter = S.begin(); iter != S.end(); iter++)
        {
            //cout << *iter << endl;
            number = *iter;
        }
        
        if(S.empty())
        {
            cout << "EMPTY" << endl;
        }
        else{
            
            cout << number << " ";
            iter = S.begin();
            cout << *iter << endl;;
        }
        
        S.clear();
    }
    
    
}