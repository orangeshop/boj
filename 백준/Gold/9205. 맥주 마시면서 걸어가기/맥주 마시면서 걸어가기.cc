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

/*
1
2
0 0
1000 0
1000 1000
2000 1000
*/
/**
 1
 2
 0 0
 1000 0
 2000 1000
 2000 2000
 */


int t;
int target;
int start_x;
int start_y;
int arrival_x;
int arrival_y;


int t_dx[4] = {1000, 0 , -1000, 0};
int t_dy[4] = {0, 1000 , 0, -1000};


vector<pair<int,int>> V;
bool vis[101];
queue<pair<int,int>> Q;


int clac(int cur_x , int cur_y, int nxt_x ,int nxt_y){
    
    return abs(cur_x-nxt_x) + abs(cur_y - nxt_y);
}


string func(){
    
    string answer = "sad";
    
    
    while(!Q.empty())
    {
        
        pair<int,int> cur = Q.front();
        Q.pop();
        
        //cout <<"inner Q : "<< cur.first << " " << cur.second << endl;
        
        if(cur.first == arrival_x && cur.second == arrival_y)
        {
            answer = "happy";
            return answer;
        }
        
        
        for(int i=0; i<V.size(); i++)
        {
            if(vis[i] ==true) continue;
            
            if(clac(cur.first , cur.second, V[i].first, V[i].second) <= 1000){
                Q.push({V[i].first, V[i].second});
                vis[i] = true;
            }
        }
    }
    
    
    return answer;
}

int main()
{
    cin >> t;
    for(int i=0; i<t; i++)
    {
        cin >> target;
        cin >> start_x >> start_y;
        Q.push({start_x, start_y});
        
        for(int k=0; k<target; k++)
        {
            int x =0;
            int y =0;
            cin>> x >> y;
            V.push_back({x,y});
            
        }
        cin >> arrival_x >> arrival_y;
        
        V.push_back({arrival_x, arrival_y});
        cout << func() << endl;
        V.clear();
        
        for(int i=0; i<101; i++)
        {
            vis[i] = 0;
        }
        
        while(!Q.empty())
        {
            Q.pop();
        }
        
        //cout << endl;
    }
}