def solution(num_list, n):
    answer = []
    
    result = [num_list[i] for i in range(n, len(num_list))]
    
    for i in range(0, n):
        result.append(num_list[i])
    
    print(result)
    return result