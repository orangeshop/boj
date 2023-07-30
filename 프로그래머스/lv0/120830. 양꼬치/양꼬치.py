def solution(n, k):
    answer = 0
    
    answer = n * 12000
    print(n/10)
    
    answer += (k-int(n/10))*2000
    return answer