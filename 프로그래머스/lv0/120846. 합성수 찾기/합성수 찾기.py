def solution(n):
    answer = 0
    
    for i in range(0,n+1):
        for k in range(2, i-1):
            if(i % k== 0):
                print(f"i : {i}, k : {k}")
                answer += 1
                break
    
    return answer