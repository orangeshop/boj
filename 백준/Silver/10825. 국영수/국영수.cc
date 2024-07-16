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
vector<tuple<string, int, int, int>> V;

bool compare2(tuple<string, int, int ,int> a, tuple<string, int, int ,int> b){
    if(get<1>(a) != get<1>(b)){
        return get<1>(a) > get<1>(b);
    }
    else if(get<2>(a) != get<2>(b)){
        return get<2>(a) < get<2>(b);
    }
    else if(get<3>(a) != get<3>(b)){
        return get<3>(a) > get<3>(b);
    }
    return (get<0>(a) < get<0>(b));
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    cin >> N;
    
    for(int i = 0; i < N; i++){
        string str = "";
        int a = 0;
        int b = 0;
        int c = 0;
        cin >> str >> a >> b >> c;
        
        V.push_back(make_tuple(str, a, b, c));
    }
    
    sort(V.begin(), V.end(), compare2);
    
    for(int i =0; i < N; i++){
        cout << get<0>(V[i])<< '\n';
    }
}
