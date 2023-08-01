import math
def solution(n):
    answer = -1
    
    for i in range(11):
        num = math.factorial(i)
        if(num <= n):
            answer = max(answer, i)
        print(num)
    
    
    return answer