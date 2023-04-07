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

string a;
string b;


int main()
{
    cin >> a >> b;
    
    char temp;
    
    temp = a[0];
    a[0] = a[2];
    a[2] = temp;
    
    temp = b[0];
    b[0] = b[2];
    b[2] = temp;
    
    
    
    
    cout << max(stoi(a) ,stoi(b)) << endl;
    
    
}