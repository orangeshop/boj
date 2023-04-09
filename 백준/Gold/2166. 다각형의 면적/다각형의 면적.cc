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

vector<pair<double,double>> V;

double answer(int cnt){
    double ans = 0;
    ans = V[0].first * V[1+cnt].second + V[1+cnt].first * V[2+cnt].second + V[2+cnt].first * V[0].second;
    ans -= V[0].second * V[1+cnt].first + V[1+cnt].second * V[2+cnt].first + V[2+cnt].second * V[0].first;
    ans/= 2;
    //cout << ans << endl;
    
//    if(ans > 0){
//        return 1;
//    }else if (ans == 0){
//        return 0;
//    }
//    else{
//        return -1;
//    }
    
    return ans;
    
}
int N;
int main(){
    
    cin >> N;
    
    for(int i =0; i<N; i++){
        double x = 0;
        double y = 0;
        cin >> x >>y;
        
        V.push_back(make_pair(x, y));
    }
    double answer_result = 0;
    
    for(int i=0; i<N-2; i++){
        answer_result += answer(i);
    }
    
    cout<<fixed;
    cout.precision(1);
    
    if(answer_result < 0){
        answer_result *= -1;
        cout << answer_result << endl;
    }
    else{
        cout << answer_result << endl;
    }
    
    
}
