
#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <algorithm>
#include <queue>
#include <tuple>
#include <math.h>
#include <set>
#include <map>
using namespace std;
//cin.tie(NULL);
//ios::sync_with_stdio(false);



long long a;
long long b;
long long c;
long long calc(long long x, long long m) {
    long long ans = 1;
    
    if (m == 0)
            return 1;
        else if (m == 1)
            return x;
        if (m % 2 > 0)
            return calc(a, m - 1)*x;
        long long int half = calc(a, m / 2);
        half %= c;
        return (half * half) % c;
    
    return ans;
}


int main()
{
    cin >> a >> b >> c;
    
    cout << calc(a,b)%c << endl;
    
    
}