#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
using namespace std;


bool isused[10];
int m,n;
int arr[10];
void dfs(int a)
{
    if(n==a)
    {
        for(int i=0; i< n; i++)
        {
            cout << arr[i]<< " " ;
        }
        cout << '\n';
        return;
    }
    for(int i=1; i<= m; i++)
    {
        if(a==0)
        {
            
        }else if(i<arr[a-1]) continue;
        
        if(!isused[i])
        {
            arr[a]=i;
            isused[i]=1;
            dfs(a+1);
            isused[i]=0;
            
        }
    }
}
int main()
{
    cin >> m >> n;
    dfs(0);
}