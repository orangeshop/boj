//
//  main.cpp
//  boj1111
//
//  Created by 최영호 on 3/5/24.
//

#include <iostream>
#include <queue>
#include <set>
#include <algorithm>
using namespace std;
int N, M;
int arr[500005];
int sz[500005];

vector<pair<int, int>> V;

int find(int x){
    
    if(x == arr[x]){
        return x;
    }else{
        arr[x] = find(arr[x]);
        return arr[x];
    }
}

void Union(int x, int y){
    int a = find(x);
    int b = find(y);
    
    if(a == b){
        return;
    }
    
    if(sz[a] >= sz[b]){
        sz[a] += sz[b];
        arr[b] = a;
    }
    else{
        sz[b] += sz[a];
        arr[a] = b;
    }
}

int main(int argc, const char * argv[]) {

    cin >> N >> M;
    
    fill(sz, sz+500005, 1);
    for(int i =0; i < N+1; i++){
        arr[i] = i;
    }
    
    for(int i =0; i < M; i++){
        int a = 0;
        int b = 0;
        cin >> a >> b;
        V.push_back(make_pair(a, b));
    }
    
    int N = 0;
    int answer = 0;
    
    for(int i =0; i < M; i++){
//        c/*o*/ut << V[i].first << " " << V[i].second << endl;
        int a = find(V[i].first);
        int b = find(V[i].second);
        
        if(a != b){
            Union(V[i].first, V[i].second);
            N++;
        }
        else{
            N++;
            cout << N<< endl;
            return 0;
        }
        
        
    }
    
    cout << 0 << endl;
    
    
    
    
    
    
    
    
    return 0;
}


