def solution(array):
    answer = [-1,-1]
    
    for i in range(len(array)):
        if(array[i] > answer[0]):
            answer[0] = array[i]
            answer[1] = i
    return answer