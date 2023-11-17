def solution(binomial):
    answer = 0
    
    arr = binomial.split()
    
    print(arr)
    
    if(arr[1] == '+'):
        answer = int(arr[0]) + int(arr[2])
    
    if(arr[1] == '-'):
        answer = int(arr[0]) - int(arr[2])
    
    if(arr[1] == '/'):
        answer = int(arr[0]) / int(arr[2])
    
    if(arr[1] == '*'):
        answer = int(arr[0]) * int(arr[2])
    
    
    
    return answer