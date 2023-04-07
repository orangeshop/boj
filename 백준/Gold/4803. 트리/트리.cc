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

vector<int> adj[501];
bool vis[501];
bool isTree = true;
queue<pair<int,int>> Q;

void answer(int number, int count){
    
    if(count == 0){
        cout << "Case "<< number <<": No trees." << endl;
    }
    else if(count == 1){
        cout << "Case "<< number <<": There is one tree."<<endl;
    }else{
        cout << "Case "<< number <<": A forest of "<< count <<" trees."<<endl;
    }
}

int main()
{
    int number =1;
    while(true)
    {
        
        int n =0;
        int m =0;
        int count = 0;
        
        cin >> n >> m;
        
        if(n == 0 && m == 0) break;
        
        
        
        for(int i=0; i<m; i++)
        {
            int first = 0;
            int second = 0;
            cin >> first >> second;
            adj[first].push_back(second);
            adj[second].push_back(first);
        }
        
        for(int i=1; i<=n; i++)
        {
            if(vis[i] != true)
            {
                Q.push({i,-1});
                count++;
                vis[i] = true;
                isTree = true;
            }
            
            while(!Q.empty()){
                
                pair<int,int> cur = Q.front();
                Q.pop();
                
                //cout << cur.first << "-> ";
                
                for(auto nxt: adj[cur.first]){
                    
                    if(nxt == cur.second) continue;
                    
                    //cout << nxt <<" "<< vis[nxt]<<" "<<isTree<<endl;
                    
                    
                    
                    if(vis[nxt] == true){
                        isTree = false;
                        continue;
                    }
                    Q.push({nxt,cur.first});
                    vis[nxt] = true;
                }
            }
            //cout << endl;
            
            if(isTree == false)
            {
                //cout << "check" << endl;
                count--;
                isTree = true;
            }
        }
        
        
        
        answer(number, count);
        
        while(!Q.empty()){Q.pop();}
        for(int i=0; i<=n; i++){
            adj[i].clear();
            vis[i] = false;
        }
        number++;
    }
}
