#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
using namespace std;

int n=0;
int m=0;
bool isused[100];
int arr[100];

void dfs(int a)
{
    if(a==n)
    {
        for(int i=0; i<n; i++) cout << arr[i] << ' ';
        
        cout << '\n';
        
        return;
    }
    
    for(int i=1; i<= m; i++)
    {
    
        if(arr[a-1]>i)
        {
            continue;
        }
        
        if(!isused[i])
        {
            arr[a] = i;
            //isused[i] =1;
            
            dfs(a+1);
            //isused[i] =0;
        }
    }
}
int main()
{
    cin >> m>>n;
    dfs(0);
}
