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


int T;

int d[2][100005];
int dp[2][100005];

int main(){
    cin >> T;
    
    for(int i =0; i < T; i++){
        int n = 0;
        cin >> n;
        
        for(int i =0; i < 2; i++){
            for(int k =0; k < n; k++){
                d[i][k] = 0;
                dp[i][k] = 0;
            }
        }
        
        for(int i =0; i < n; i++){
            cin >> d[0][i];
        }
        
        for(int i =0; i < n; i++){
            cin >> d[1][i];
        }
        
        dp[0][0] = d[0][0];
        dp[1][0] = d[1][0];
        
        dp[0][1] = d[1][0] + d[0][1];
        dp[1][1] = d[0][0] + d[1][1];
        
        for(int i = 2; i <= n; i++){
            dp[0][i] = max(dp[1][i-1], dp[1][i-2]) + d[0][i];
            dp[1][i] = max(dp[0][i-1], dp[0][i-2]) + d[1][i];
            
//            cout << dp[0][i] << " " << dp[1][i] << endl;
        }
        
//        for(int i =0; i < 2; i++){
//            for(int k =0; k < n; k++){
//                cout << dp[i][k] << " ";
//            }
//            cout << endl;
//        }
        
        
        cout << max(dp[0][n-1], dp[1][n-1]) << endl;
        
    }
    
    
    
}
