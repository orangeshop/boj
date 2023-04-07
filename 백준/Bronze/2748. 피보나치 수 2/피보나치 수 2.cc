#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
using namespace std;

long long dist[100];

void func(int a, int i)
{
    if(a==i) return;
    dist[i] = dist[i-1] + dist[i-2];
    i++;
    func(a,i);
}

int main()
{
    int a=0;
    cin >> a;
    dist[0] =0;
    dist[1] =1;
    func(a+1,2);
    

    
    cout << dist[a] << endl;
}