#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
using namespace std;

int main()
{
    int a;
    
    cin >> a;
    
    vector<char> V[100];
    
    for(int i=0; i< a; i++)
    {
        string str;
        cin >> str;
        for(int k=0; k<str.size(); k++)
        {
            V[i].push_back(str[k]);
        }
    }
    
    
    
    
    for(int i=0; i< a; i++)
    {
        
        stack<int> S;
        S.push(0);
        
        for(int k=0; k< V[i].size(); k++)
        {
            if(V[i][k] == 'O')
            {
                
                S.push(S.top()+1);
            }
            else if(V[i][k]=='X')
            {
                S.push(0);
            }
            
        }
        int result =0;
        
        for(int k=0; k< V[i].size(); k++)
        {
            
            result += S.top(); S.pop();
        }
      
        cout << result << endl;
    }
}