#include <string>
#include <vector>
#include <iostream>
using namespace std;

int arr[101];

void func(){
    int result = 1;
    string temp = "";
    for(int i =1; i< 101; i++){
        
        temp = to_string(result);
        cout <<i <<" result : " << result << endl;
        if(result % 3 == 0)
        {
            cout << "in if" << endl;
            result++;
            i--;
            continue;    
        }
        if(temp[0] == '3' || temp[1] == '3' || temp[2] == '3'){
            cout << "in if" << endl;
            result++;
            i--;
            continue;
        }
        arr[i] = result;
        result++;
    }
}

int solution(int n) {
    int answer = 0;
    
    func();
    
    answer = arr[n];
    
    return answer;
}