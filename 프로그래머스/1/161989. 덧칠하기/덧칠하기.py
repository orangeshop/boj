def solution(n, m, section):
    answer = 0
    target = 0
    for i in range(len(section)):
        if(target < section[i]):
            target = (section[i]-1) + m
            answer += 1
    
    return answer