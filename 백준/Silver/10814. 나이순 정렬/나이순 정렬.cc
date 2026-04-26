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

using namespace std;
int N;
vector<pair<int, pair<int, string>>> V;

int main(){
    cin >> N;
    
    for(int i = 0; i < N; i++){
        int a = 0;
        string str = "";
        cin >> a >> str;
        
        V.push_back(make_pair(a, make_pair(i, str)));
    }
    
    sort(V.begin(), V.end());
    
    for(int i =0; i < N; i++){
        cout << V[i].first << " " << V[i].second.second << endl;
    }
}
