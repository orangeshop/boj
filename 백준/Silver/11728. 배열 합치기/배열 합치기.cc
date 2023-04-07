#include <iostream>
//#include <string>
#include <vector>
//#include <stack>
//#include <algorithm>
#include <queue>
using namespace std;


int a[1000000];
int b[1000000];
int c[2000000];
int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int a_1,b_1,num1=0 ,num2=0;
    cin >> a_1 >> b_1;
    for(int i=0; i< a_1; i++) cin >> a[i];
    for(int i=0; i< b_1; i++) cin >> b[i];
    for(int i=0; i< a_1+b_1; i++)
    {
        if(a_1 == num1)
        {
            c[i] = b[num2];
            num2++;
            continue;
        }else if(b_1 == num2)
        {
            c[i] = a[num1];
            num1++;
            continue;
        }
        else if(a[num1]>b[num2])
        {
            c[i] = b[num2];
            num2++;
            continue;
        }else{
            c[i] = a[num1];
            num1++;
            continue;
        }
    }
    for(int i=0; i< a_1+b_1; i++) cout << c[i] << ' ';
}