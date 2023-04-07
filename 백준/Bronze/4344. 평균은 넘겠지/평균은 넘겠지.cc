#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
using namespace std;

int board[1001][1001];
int main()
{
    int a=0;
    cin >> a;
    queue<int> Q[1001];
    for(int i=0; i< a; i++)
    {
        int b=0;
        cin >> b;
        Q[i].push(b);
        board[i][0] = b;
        for(int k=0; k< b; k++)
        {
            int c=0;
            cin >> c;
            Q[i].push(c);
            
        }
    }
    
    vector<double> V;
    
    for(int i=0; i< a; i++)
    {
        int num=0;
        num = Q[i].front(); Q[i].pop();
        double result =0;
        
        for(int k=1; k< num+1; k++)
        {
            board[i][k] = Q[i].front();;
            result += Q[i].front();
            Q[i].pop();
        }
        
        result /= num;
        V.push_back(result);
    }
    
    vector<double> v_2;
    
    for(int i=0; i< a; i++)
    {
        int count =0;
        double num = board[i][0];
        for(int k=1; k< board[i][0]+1; k++)
        {
                if(board[i][k] > V[i])
                {
                    count++;
                }
        }
        double num_2 =0;
        num_2 = 100/num;
       
        v_2.push_back(num_2*count);
    }
    
    for(int i=0; i< v_2.size(); i++)
    {
        cout << fixed;
        cout.precision(3);
        cout << v_2[i]<<"%" << endl;
    }
}
