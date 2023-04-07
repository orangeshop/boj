#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
using namespace std;
int n=0;
int m=0;
vector<int> V;
int arr[3];
bool isused[100];
int max_num=0;
int check_num=0;
void dfs(int a)
{
    check_num=0;
    if(a==3)
    {
        for(int i=0; i< 3; i++)
        {
            check_num += arr[i];
        }
        
        if(check_num <= m)
        {
            if(max_num<check_num)
            {
                max_num = check_num;
            }
            return;
        }else{
            return;
        }
       
        
    }
    for(int i=0; i<n; i++)
    {
        if(!isused[i])
        {
            arr[a] = V[i];
            isused[i]=1;
            dfs(a+1);
            isused[i]=0;
        }
    }
    
}
int main()
{
    
    cin >> n >> m;
    
    for(int i=0; i< n; i++)
    {
        int b=0;
        cin >> b;
        V.push_back(b);
    }
    
    dfs(0);
    
    cout <<max_num << endl;
}