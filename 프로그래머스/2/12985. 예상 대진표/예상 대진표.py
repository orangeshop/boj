def solution(n,a,b):
    answer = 0
    
    result_a = a
    result_b = b
    
    while(True):
        
        if(result_a == result_b):
            break
            
        result_a = int((result_a/2) + (result_a % 2))
        result_b = int((result_b/2) + (result_b % 2))
        
        answer += 1
                
    return answer