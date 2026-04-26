//
//  main.cpp
//  boj1111
//
//  Created by 최영호 on 3/5/24.
//

#include <iostream>
#include <queue>
#include <set>
using namespace std;
int N, d, k, c;
int arr[30001];
vector<int> V;
bool vis[3001];
int clac(){
    fill(vis, vis + 3001, false);
    int answer = 0;
    for(int i =0; i < k; i++){
        
        if(vis[V[i]]== false){
            vis[V[i]] = true;
            answer++;
        }
    }
    
    
    if(vis[c] == false){
        answer++;
    }
    
    return answer;
}

int main(int argc, const char * argv[]) {

    cin >> N >> d >> k >> c;
    
    
    int result = 0;
    for(int i =0; i < N; i++){
        int tmp = 0;
        cin >> tmp;
        arr[i] = tmp;
        
    }
    
    
    for(int i =0; i < N; i++){
        
        if(V.size() == k){
            result = max(result, clac());
            V.erase(V.begin());
        }
        
        V.push_back(arr[i]);
    }
    
    for(int i =0; i < k; i++){
        
        if(V.size() == k){
            result = max(result, clac());
            V.erase(V.begin());
        }
        
        V.push_back(arr[i]);
    }
    
    cout << result << endl;
    
    return 0;
}


