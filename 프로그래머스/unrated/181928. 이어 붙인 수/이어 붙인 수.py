def solution(num_list):
    answer = 0
    
    result = ''
    result2 = ''
    for i in range(len(num_list)):
        if(num_list[i] % 2 == 0):
            result += str(num_list[i])
        else:
            result2 += str(num_list[i])
    
    return int(result) + int(result2)