def solution(nums):
    answer = 0
    
    dp = [0 for _ in range(200005)]
    
    for i in range(len(nums)):
        dp[nums[i]] += 1
    
    # print(dp)
    
    max_target = int(len(nums)/2)
    
    for i in range(len(dp)):
        if(dp[i] != 0):
            answer += 1
    
    if(answer > max_target):
        answer = max_target
    return answer