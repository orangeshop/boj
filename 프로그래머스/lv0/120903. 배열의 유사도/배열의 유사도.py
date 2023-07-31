def solution(s1, s2):
    answer = 0
    
    for i in range(len(s1)):
        for k in range(len(s2)):
            if(s1[i] == s2[k]):
                answer += 1
    
    return answer