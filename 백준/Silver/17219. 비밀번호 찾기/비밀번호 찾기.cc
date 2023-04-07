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

int n,m;


int main()
{
    
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cin >> n >> m;
    
    map<string,string> M;
    
    for(int i=0; i<n; i++)
    {
        string str1;
        string str2;
        cin >> str1 >> str2;
        M.insert(pair<string,string>(str1,str2));
    }
    
    for(int i=0; i<m; i++)
    {
        string str;
        
        cin >> str;
        
        auto item = M.find(str);
        
        if (item != M.end()) {
            cout << item -> second << '\n';
        }
    }
}
