#include <iostream>
#include <string>
#include<cstring>
#include <vector>
#include <stack>
#include <memory.h>
#include <algorithm>
#include <queue>
#include <tuple>
#include <math.h>
#include <set>
#include <map>
using namespace std;
//cin.tie(NULL);
//ios::sync_with_stdio(false);



#define MAX 100000
int dp_t[MAX+1];
int  dx[3] = {1,-1,2};
int n,m;

int main(){
    
    cin >> n >> m;
    
    for(int i=0; i<=MAX; i++)
    {
        if(i-n<0)
        {
            dp_t[i] = (i-n)*-1;
        }
        else{
            dp_t[i] = i-n;
        }
    }
    
    //i가 거리
    //dp_t[i] = 시간
   
    
    for(int k=0; k<2; k++)
    {
        for(int i=0; i<=MAX; i++)
        {
            
            if(i+1 > MAX)
            {
                
            }
            else{
                dp_t[i+1] = min(dp_t[i]+1,dp_t[i+1]);
            }
            
            dp_t[i-1] = min(dp_t[i]+1,dp_t[i-1]);
            
            if(i*2 > MAX)
            {
                
            }
            else{
                dp_t[i*2] = min(dp_t[i]+1,dp_t[i*2]);
            }

        }
    }
    
    for(int i=0; i<=MAX; i++)
    {
        
        if(i+1 > MAX)
        {
            
        }
        else{
            dp_t[i+1] = min(dp_t[i]+1,dp_t[i+1]);
        }
        
        dp_t[i-1] = min(dp_t[i]+1,dp_t[i-1]);
        
        if(i*2 > MAX)
        {
            
        }
        else{
            dp_t[i*2] = min(dp_t[i]+1,dp_t[i*2]);
        }
        
    }
    
    
    
    queue<pair<int,int>> Q;
    
    Q.push({n,0});
    //vis[n] = 1;
    int answer = 0;
    
    while(!Q.empty())
    {
        
        pair<int,int> cur = Q.front(); Q.pop();
        //cur.first = 현재 위치
        //cur.second = 최솟값
        //Q.push = dp_t와 최솟값이 같지 않으면 push x
        if(cur.second > dp_t[m]) continue;
        if(cur.second != dp_t[cur.first]) continue;
        
        if(cur.first == m && cur.second == dp_t[m])
        {
            answer++;
        }
        
        for(int dir =0; dir<3; dir++)
        {
            if(dir == 2)
            {
                if(dx[dir] * cur.first > MAX) continue;
                int nx = dx[dir] * cur.first;
                Q.push({nx,cur.second+1});
            }
            
            if(dir != 2){
                if(dx[dir] + cur.first > MAX) continue;
                int nx = dx[dir] + cur.first;
                Q.push({nx,cur.second+1});
            }
        }
    }
    
    
    
    cout << dp_t[m] << endl;
    cout << answer <<endl;
    
}