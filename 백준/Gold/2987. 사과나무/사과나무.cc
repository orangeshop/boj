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

vector<pair<int,int>> tri;
vector<pair<int,int>> dot;

int M;

int ccw(){
    
    int ans = 0;
    
    ans = tri[0].first * tri[1].second + tri[1].first * tri[2].second + tri[2].first * tri[0].second;
    ans -= tri[0].second * tri[1].first + tri[1].second * tri[2].first + tri[2].second * tri[0].first;
    
    //cout << ans << endl;
    if(ans < 0 ){
        return -1;
    }else if(ans == 0){
        return 0;
    }else{
        return 1;
    }
}

double ccw2(){
    
    double ans = 0;
    
    ans = tri[0].first * tri[1].second + tri[1].first * tri[2].second + tri[2].first * tri[0].second;
    ans -= tri[0].second * tri[1].first + tri[1].second * tri[2].first + tri[2].second * tri[0].first;
    
    if(ans < 0){
        ans *= -1;
    }
    
    return ans/2;
}



bool ccw_in_dot(int num){
    
    int result1 = 0;
    int result2 = 0;
    int result3 = 0;
    
    bool ans1 = 0;
    bool ans2 = 0;
    bool ans3 = 0;
    
    
    result1 = tri[0].first * tri[1].second + tri[1].first * dot[num].second + dot[num].first * tri[0].second;
    result1 -= tri[0].second * tri[1].first + tri[1].second * dot[num].first + dot[num].second * tri[0].first;
    
    if(result1 < 0 || result1 == 0){
        ans1 = true;
    }else{
        ans1 = false;
    }
    
    result2 = tri[1].first * tri[2].second + tri[2].first * dot[num].second + dot[num].first * tri[1].second;
    result2 -= tri[1].second * tri[2].first + tri[2].second * dot[num].first + dot[num].second * tri[1].first;
    
    if(result2 < 0 || result2 == 0){
        ans2 = true;
    }else{
        ans2 = false;
    }
    
    result3 = tri[2].first * tri[0].second + tri[0].first * dot[num].second + dot[num].first * tri[2].second;
    result3 -= tri[2].second * tri[0].first + tri[0].second * dot[num].first + dot[num].second * tri[2].first;
    
    if(result3 < 0 || result3 == 0){
        ans3 = true;
    }else{
        ans3 = false;
    }
    
    //cout << "result 1 : " << result1 << " result 2 : " << result2 << " result 3 : " << result3 << endl;
    
    if(ans1 == true && ans2 == true && ans3 == true){
        return true;
    }else{
        return false;
    }
}


int N;
int main(){
    
    for(int i=0; i<3; i++){
        int x =0;
        int y =0;
        
        cin >> x >> y;
        
        tri.push_back({x,y});
    }
    
    //cout <<"전 : "<< ccw() << endl;
    
    int check = ccw();
    
    if(check != -1){
        pair<int,int> temp = {0,0};
        temp = tri[1];
        tri[1] = tri[2];
        tri[2] = temp;
        
    }
    
    //cout << "후 : "<< ccw() << endl;
    
    cin >> N;
    
    for(int i=0; i<N; i++){
        int x =0;
        int y =0;
        
        cin >> x >> y;
        
        dot.push_back({x,y});
    }
    
    int answer = 0;
    
    for(int i=0; i<N; i++){
        if(ccw_in_dot(i) == true){
            answer += 1;
        }
    }
    
    cout << fixed;
    cout.precision(1);
    
    cout << ccw2() << endl;
    cout << answer << endl;
    
}
