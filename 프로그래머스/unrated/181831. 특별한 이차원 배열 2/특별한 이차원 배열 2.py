def solution(arr):
    answer = 1
    
    for i in range(len(arr)):
        for k in range(len(arr[i])):
            if(arr[i][k] != arr[k][i]):
                answer = 0
    
    return answer