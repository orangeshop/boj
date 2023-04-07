#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
using namespace std;
int n=1;
int m=1;
void dfs(int a)
{
    if(a+1==n)
    {
        cout << m;
        return;
    }
    
    m*=n;
    n++;
    dfs(a);
    
}

int main()
{
    int a;
    cin >> a;
    dfs(a);
}