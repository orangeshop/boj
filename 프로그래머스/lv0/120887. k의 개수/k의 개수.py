def solution(i, j, k):
    answer = 0
    
    tem = str(k)
    for i in range(i,j+1):
        temp = str(i)
        for h in range(len(temp)):
            if(temp[h] == tem):
                answer += 1
    
    return answer