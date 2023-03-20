#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
#include <tuple>
#include <math.h>
using namespace std;
//cin.tie(NULL);
//ios::sync_with_stdio(false);

int a;
int b;
int c;
int d;
int e;

int main()
{
    
    cin >> a >> b >> c >> d >> e;
    
    
    int num =0;
    
    num = (a*a) + (b*b) + (c*c) + (d*d) + (e*e);
    num %= 10;
    
    cout << num << endl;
    
}