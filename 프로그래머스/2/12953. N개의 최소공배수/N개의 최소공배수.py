import math
def solution(arr):
    answer = 0

    for i in range(1,50000000):
        check = False
        
        for k in range(len(arr)):
            if i % arr[k] != 0:
                check = True
                break
        
        if check == False:
            return i
        
        
        
    
    return answer