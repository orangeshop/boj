#include <iostream>
#include <string>
#include <cstring>
#include <vector>
#include <stack>
#include <memory.h>
#include <algorithm>
#include <queue>
#include <tuple>
#include <math.h>
#include <list>
#include <set>
#include <map>
#include <iterator>

using namespace std;
#define S second
#define F first
#define l long
#define MAX 0x7ffffff
int dx[4] = {-1,0,1,0};
int dy[4] = {0,1,0,-1};
int ddx[8] = {-1,-2,-2,-1,1,2,2,1};
int ddy[8] = {-2,-1,1,2,-2,-1,1,2};
int cdx[8] = {-1,0,1,0,-1,-1,1,1};
int cdy[8] = {0,1,0,-1,-1,1,1,-1};

//cin.tie(NULL);
//ios::sync_with_stdio(false);
//cout.tie(NULL);



string str;
string boom;

stack<unsigned char> s;
stack<pair<char,pair<int,int>>> st;
bool vis[1000000];

int check_count;

int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    cout.tie(NULL);
    
    cin >> str;
    cin >> boom;
    
    
    for(int i=0; i<str.size(); i++)
    {
        if(st.empty())
        {
            if(str[i] == boom[0])
            {
                st.push({str[i],{1,i}});
            }
            else
            {
                st.push({str[i],{0,i}});
            }
        }
        else
        {
            if(str[i] == boom[st.top().S.F])
            {
                st.push({str[i], {st.top().S.F+1, i}});
            }
            else
            {
                
                if(str[i] == boom[0])
                {
                    st.push({str[i], {1,i}});
                }
                else{
                    st.push({str[i], {0,i}});
                }
            }
        }
        
        if(st.top().S.F == boom.size())
        {
            
            for(int k=0; k<boom.size(); k++)
            {
                vis[st.top().S.S] = 1;
                st.pop();
                
            }
        }
        
    }
    
    
    bool check =false;
    for(int i=0; i<str.size(); i++)
    {
        if(vis[i] != 1)
        {
            check = true;
        }
    }
    
    if(check == false)
    {
        cout << "FRULA";
    }
    else{
        for(int i=0; i<str.size(); i++)
        {
            if(vis[i] == 1) continue;
            cout << str[i];
        }
    }
    
    // 2퍼 틀
    //aaaabb
    //aab
    
    //out : frula
}