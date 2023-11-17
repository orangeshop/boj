def solution(arr):
    answer = []
    
    for i in range(len(arr)):
        for k in range(arr[i]):
            answer.append(arr[i])
    
    return answer