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

long long N;
stack<pair<long long,long long>> St;
long long answer =0;
int main()
{
    cin >> N;
    
    for(int i=0; i<N; i++)
    {
        
        long long a =0;
        cin >> a;
        long long idx =i;
        if(St.empty())
        {
            St.push({a,idx});
            continue;
        }
        //cout << St.top().F << " " << St.top().S << endl;
        //999,999,999
       
        if(St.top().F > a)
        {
            //cout << "hi" << endl;
            while(!St.empty())
            {
                pair<long long,long long> cur = St.top();
                if(St.top().F <= a) break;
                St.pop();
                long long result =0;
                if(St.empty())
                {
                    result = cur.F * i;
                }
                else{
                    result = cur.F * (i - cur.S);
                }
                //cout << "result : " << result << endl;
                idx = cur.S;
                answer = max(answer, result);
                
            }
            
        }
        
        St.push({a,idx});
        
        
        
        if(i== N-1)
        {
            while(!St.empty())
            {
                //cout <<"out : " << St.top().F << " " << St.top().S << endl;
                pair<long long,long long> cur = St.top();
                St.pop();
                long long result =0;
                if(St.empty())
                {
                    result = cur.F * (i+1);
                }
                else{
                    result = cur.F * ((i+1) - cur.S);
                }
                //cout << "result : " << result << endl;
                answer = max(answer, result);
                
            }
        }
        
    }
    
    
    cout << answer << endl;
}