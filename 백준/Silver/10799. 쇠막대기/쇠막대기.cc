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

string str = "";
stack<int> st;
stack<string> st2;
int answer = 0;
int main(int argc, const char * argv[]) {
    cin >> str;
    
    for(int i =0; i < str.size(); i++){
        if(st2.size() > 0 && st2.top() == "("&& str[i] == ')' && st.top() == i - 1){
            st.pop();
            st2.pop();
            answer += st.size();
            
            continue;
        }
        
        if(str[i] == ')' && st.top() != i -1){
            answer += 1;
            st.pop();
            st2.pop();
        }
        
        
        if(str[i] == '('){
            st.push(i);
            st2.push("(");
        }
        
    }
    
    cout << answer;
    
}
