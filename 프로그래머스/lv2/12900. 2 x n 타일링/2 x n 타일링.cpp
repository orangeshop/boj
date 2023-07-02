#include <string>
#include <vector>

using namespace std;

int dp[60005];
int solution(int n) {
    int answer = 0;
    
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 3;
    
    for(int i = 4; i<= 60000; i++){
        dp[i] = dp[i -1] + dp[i -2];
        dp[i] %= 1000000007;
    }
    
    answer = dp[n];
    return answer;
}