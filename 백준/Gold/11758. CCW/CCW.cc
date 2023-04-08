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
#define S second
#define F first
#define l long
#define MAX 0x7ffffff
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int ddx[8] = {-1,-2,-2,-1,1,2,2,1};
int ddy[8] = {-2,-1,1,2,-2,-1,1,2};

//cin.tie(NULL);
//ios::sync_with_stdio(false);

vector<pair<int,int>> V;

int answer(){
    int ans = 0;
    ans = V[0].first * V[1].second + V[1].first * V[2].second + V[2].first * V[0].second;
    ans -= V[0].second * V[1].first + V[1].second * V[2].first + V[2].second * V[0].first;
    
    //cout << ans << endl;
    
    if(ans > 0){
        return 1;
    }else if (ans == 0){
        return 0;
    }
    else{
        return -1;
    }
    
}

int main(){
    for(int i =0; i<3; i++){
        int x = 0;
        int y = 0;
        cin >> x >>y;
        
        V.push_back(make_pair(x, y));
    }
    
    cout << answer() << endl;
}
