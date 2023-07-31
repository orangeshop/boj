#include <string>
#include <vector>
#include <stack>
#include <iostream>
using namespace std;

vector<int> solution(vector<int> prices) {
    vector<int> answer;
    
    stack<pair<int,int>> S; // first : idx, seocond : prices
    S.push({0,prices[0]});
    
    for(int i =0; i< prices.size(); i++){
        answer.push_back(0);
    }
    
    S.push({0,prices[0]});
    
    for(int i =1; i<prices.size(); i++){
        
        // cout << "S top : " <<  S.top().second << endl;
        // cout << "i : " << i << " prices : " << prices[i] << endl;
        
        if(S.top().second < prices[i]){
            
            S.push({i,prices[i]});
        }else{
           
            while(!S.empty()){
                if(S.top().second <= prices[i]) break;
                answer[S.top().first] = i - S.top().first;
                S.pop();
            }
            S.push({i,prices[i]});
        }
    }
    
    while(!S.empty()){
        answer[S.top().first] = (prices.size()-1) - S.top().first;
        S.pop();
    }
    
    return answer;
}