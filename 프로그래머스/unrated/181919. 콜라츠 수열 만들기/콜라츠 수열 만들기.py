def solution(n):
    answer = [n]
    result = n
    while(True):
        if(result == 1):
            break
            
        if(result % 2 == 0):
            result /= 2
        else:
            result = 3 * result + 1
        
        answer.append(result)
    
    return answer