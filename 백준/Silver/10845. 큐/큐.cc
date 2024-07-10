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

queue<string> Q;
string last;


int main(){
    cin >> N;
    for(int i =0; i <= N; i++){
        string str = "";
        getline(cin, str);
        
        stringstream ss(str);
        string first, seocnd;
        ss >> first >> seocnd;
        
        if(first == "push"){
            Q.push(seocnd);
            last = seocnd;
        }else if(first == "pop"){
            if(!Q.empty()){
                cout << Q.front() << endl;
                Q.pop();
            }else{
                cout << "-1" << endl;
            }
        }else if(first == "size"){
            cout << Q.size() << endl;
        }else if(first == "empty"){
            if(!Q.empty()){
                cout << "0" << endl;
            }else{
                cout << "1" << endl;
            }
        }else if(first == "front"){
            if(!Q.empty()){
                cout << Q.front() << endl;
            }else{
                cout << "-1" << endl;
            }
        }else if(first == "back"){
            if(!Q.empty()){
                cout << last << endl;
            }else{
                cout << "-1" << endl;
            }
        }
        
        
    }
}
