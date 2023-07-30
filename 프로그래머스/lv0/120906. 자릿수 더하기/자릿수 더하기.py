def solution(n):
    answer = 0
    
    for i in range(10):
        answer += n%10
        n = int(n/10)
        
    
    return answer