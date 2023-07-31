def solution(numbers, k):
    answer = 0
    
    k -= 1
    
    k *= 2
    
    print(k)
    
    if(len(numbers) > k):
        temp = k
    else:
        temp = k%len(numbers)
        
    print(temp)
    
    answer = numbers[temp]
    
    return answer