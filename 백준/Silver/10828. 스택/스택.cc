#include <iostream>
#include <algorithm>
#include <stack>
#include <string>
#include <sstream>

using namespace std;

int N;
stack<string> st;
int main(int argc, const char * argv[]) {
    cin >> N;
    for(int i =0; i <= N; i++){
        string str = "";
        getline(cin, str);
        
        stringstream ss(str);
        
        string first, second;
        
        ss >> first >> second;
        
        if(first == "push"){

            st.push(second);
        }else if (first == "top"){
            if(st.empty()){
                cout  << "-1" << endl;
            }else{
                cout << st.top() << endl;
            }
        }else if (first == "size"){
            cout  << st.size() << endl;
        }else if (first == "empty"){
            
            if(st.empty()){
                cout  << "1" << endl;
            }
            else{
                cout  << "0" << endl;
            }
        }else if (first == "pop"){
            if(st.empty()){
                cout << "-1" << endl;
            }else{
                string tmp = st.top();
                st.pop();
                cout  << tmp << endl;
            }
        }
    }
}
