def solution(num, k):
    answer = -1
    
    str_num = str(num)
    k_num = str(k)
    for i in range(len(str_num)):
        if(k_num == str_num[i]):
            answer = i+1
            break
            
    return answer