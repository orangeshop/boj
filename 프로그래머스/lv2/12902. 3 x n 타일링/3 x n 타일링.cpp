#include <string>
#include <vector>

using namespace std;

long dp[5005];

int solution(int n) {
    long answer = 0;
    
    dp[1] = 0;
    dp[2] = 3;
    dp[3] = 0;
    dp[4] = 11;
    
    for(int i = 6; i<=5000; i++){
        dp[i] = (4 * dp[i-2]) % 1000000007 - dp[i-4]%1000000007 + 1000000007;
        dp[i] %= 1000000007;
    }
    
    answer = dp[n];
    return answer;
}