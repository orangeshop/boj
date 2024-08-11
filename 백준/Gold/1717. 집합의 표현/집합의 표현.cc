//
//  main.cpp
//  cpp
//
//  Created by 최영호 on 7/8/24.
//

#include <iostream>
#include <algorithm>
#include <stack>
#include <string>
#include <sstream>
#include <queue>
#include <set>

using namespace std;


int N;
int M;

int p[1000005];

int find(int x){
    if(p[x] == x){
        return x;
    }
    else{
        p[x] = find(p[x]);
        return p[x];
    }
}

void IsUnion(int x, int y){
    int a = find(x);
    int b = find(y);
    
    if(a != b){
        p[a] = b;
    }
}


int Union(int x, int y){
    int a = find(x);
    int b = find(y);
    
    if(a == b){
        return 1;
    }
    else{
        return 0;
    }
}


int main(){
    
    ios_base::sync_with_stdio(false);

    cin.tie(NULL);

    cout.tie(NULL);
    cin >> N >> M;
    
    for(int i =0; i <= N; i++){
        p[i] = i;
    }
    
    for(int i =0; i < M; i++){
        int a= 0;
        int b = 0;
        int c = 0;
        
        cin >> a >> b >>  c;
        
        if(a == 0){
            IsUnion(b, c);
        }else{
            if(Union(b, c) == 1){
                cout << "YES" << "\n";
            }else{
                cout << "NO" << "\n";
            }
        }
        
    }
    
}
