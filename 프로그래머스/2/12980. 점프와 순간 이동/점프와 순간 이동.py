def solution(n):
    answer = 0
    num = n
    # 5000 2500 1250 /625 624 312 156 78 /39 38 /19 18 /9 8 4 2 1 /0
    
    while(True):
        if(num == 0):
            break
            
        # print(num)
        
        if num % 2 == 0:
            num /= 2
        else : 
            num -= 1
            answer += 1
    
    return answer

#   dp = [i for i in range(n + 1)]
#   dp[0] = 0
    
#   for i in range(1, n + 1):
#       if i % 2 == 0:
#           dp[i] = dp[int(i / 2)]
#       else:
#           dp[i] = dp[i -1] + 1