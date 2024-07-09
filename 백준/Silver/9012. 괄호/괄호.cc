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

using namespace std;

int N;

int main(int argc, const char * argv[]) {
    cin >> N;
    for(int i =0; i < N; i++){
        string str = "";
        cin >> str;
        stack<string> st;
        for(int k =0; k < str.size(); k++){

            if(str[k] == '('){
                st.push("(");
            }else if(st.size() > 0 && st.top() == "(" && str[k] == ')'){
                st.pop();
                
            }else if(str[k] == ')'){
                st.push(")");
            }
            
//            cout << st.size() << endl;
            
        }
        
        if(st.empty()){
            cout << "YES" << endl;
        }
        else{
            cout << "NO" << endl;
        }
        
    }
}
