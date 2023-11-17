def solution(str1, str2):
    answer = 0
    
    for i in range(len(str2)):
        if(str1 == str2[i : len(str1) + i]):
            answer = 1
    
    return answer