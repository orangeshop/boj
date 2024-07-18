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

int N, M;

set<string> S;
vector<string> V;
int main(){
    cin >> N >> M;
    
    for(int i =0; i < N; i++){
        string str = "";
        cin >> str;
        S.insert(str);
    }
    
    for(int i =0; i < M; i++){
        string str = "";
        cin >> str;
//        cout << S.insert(str).second << endl;
        if(S.insert(str).second == false){
            V.push_back(str);
        }
    }
    
    cout << V.size() << endl;
    
    sort(V.begin(), V.end());
    
    for(int i =0; i < V.size(); i++){
        cout << V[i] << endl;
    }
}
