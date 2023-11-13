def solution(num_list, n):
    answer = 0
    
    for i in range(len(num_list)):
        if num_list[i] == n:
            return 1
    
    return answer