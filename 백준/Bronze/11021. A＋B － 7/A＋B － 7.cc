#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
using namespace std;

int main()
{
    
    int a=0;
    scanf("%d", &a);
    
    for(int i=1; i< a+1; i++)
    {
        int b;
        int c;
        scanf(" %d", &b);
        scanf("%d", &c);
        cout << "Case #"<<i<<": "<< b+c << endl;
    }

}
