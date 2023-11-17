def solution(my_string, m, c):
    answer = ''
    
    arr = [[my_string[(i * m) + k] for k in range(m)] for i in range(int(len(my_string)/m))]
    
    print(len(my_string))
    print(arr)
    
    for i in range(int(len(my_string)/m)):
        answer += arr[i][c-1]
    
    return answer