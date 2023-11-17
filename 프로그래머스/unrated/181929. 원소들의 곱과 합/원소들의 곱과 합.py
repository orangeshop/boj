def solution(num_list):
    answer = 0
    
    result1 = 1
    result2 = 0
    
    for i in range(len(num_list)):
        result1 *= num_list[i]
        result2 += num_list[i]
    
    print(f"{result1} {result2 ** 2}")
    
    if(result1 < result2**2):
        answer = 1
    
    return answer