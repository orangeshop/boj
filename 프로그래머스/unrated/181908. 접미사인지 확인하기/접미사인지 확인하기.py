def solution(my_string, is_suffix):
    answer = 0
    
    result = []
    
    for i in range(len(my_string)):
        result.append(my_string[i :])
    
    print(result)
    
    for i in range(len(result)):
        if(result[i] == is_suffix):
            answer = 1
    
    return answer