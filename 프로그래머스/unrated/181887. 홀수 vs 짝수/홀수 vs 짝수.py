def solution(num_list):
    answer = 0
    
    result1 = 0
    result2 = 0
    
    for i in range(len(num_list)):
        if(i % 2 == 0):
            result1 += num_list[i]
        else:
            result2 += num_list[i]
    
    if(result1 > result2):
        answer = result1
    else:
        answer = result2
    
    return answer