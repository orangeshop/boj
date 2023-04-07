#include <iostream>
#include <queue>
#include <stack>
#include <vector>
#include <string>
using namespace std;

bool vis[31];
int main()
{
    for(int i=0; i<28; i++)
    {
        int a =0;
        cin >> a;
        
        vis[a] = 1;
    }
    
    for(int i=1; i<31; i++)
    {
        if(vis[i] == 1) continue;
        cout << i << endl;
    }
}