def solution(n):
    answer = 0
    dp = [0 for _ in range(n + 2)]
    dp[0] = 0
    dp[1] = 1
    dp[2] = 2
    for i in range(3, n + 1):
        dp[i] = (dp[i-1] + dp[i - 2]) % 1234567
        
        
    
    for i in range(n + 1):
        print(dp[i])
    return dp[n]