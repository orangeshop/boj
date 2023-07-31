def solution(array):
    answer = 0
    
    for i in range(len(array)):
        temp = str(array[i])
        for l in range(len(temp)):
            if(temp[l] == '7'):
                answer += 1
    
    return answer