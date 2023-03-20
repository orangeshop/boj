
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

vector<char> V;
char arr[1000];
bool isused[1000];
int n,m;
char alpa_1[5] = {'a', 'e', 'i', 'o', 'u'};
char alpa_2[21] = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};


vector<string> result;
void back_track(int a)
{
    if(a==n+1)
    {
        int check_1 =0;
        int check_2 =0;
        for(int i=0; i< 5; i++)
        {
            for(int k=0; k<a; k++)
            {
                if(arr[k] == alpa_1[i])
                {
                    check_1++;
                }
            }
        }
        if(check_1 < 1) return;
        
        for(int i=0; i< 21; i++)
        {
            for(int k=0; k<a; k++)
            {
                if(arr[k] == alpa_2[i])
                {
                    check_2++;
                }
            }
        }
        
        if(check_2 < 2) return;
        
        string str;
        for(int i=1; i<a; i++)
        {
            //cout << arr[i];
            str += arr[i];
        }
        //cout << str << endl;
        result.push_back(str);
        //cout << '\n';
        return;
            
    }
    
    for(int i=1; i<= m; i++)
    {
        //cout << arr[a-1] << " " << V[i] << endl;
        if(a-1 == 0)
        {
            if(!isused[i])
            {
                arr[a] = V[i];
                isused[i] = true;
                back_track(a+1);
                isused[i] = false;
            }
        }
        else if(arr[a-1] > V[i])
        {
            continue;
        }
        else{
            if(!isused[i])
            {
                arr[a] = V[i];
                isused[i] = true;
                back_track(a+1);
                isused[i] = false;
            }
        }
        
    }
}


int main()
{
    cin >> n >> m;
    V.push_back(NULL);
    for(int i=0; i< m; i++)
    {
        char a;
        cin >> a;
        V.push_back(a);
    }
    
    back_track(1);
    
    sort(result.begin(), result.end());
    
    
    for(int i=0; i<result.size(); i++)
    {
        
        cout << result[i] << '\n';
    }
}