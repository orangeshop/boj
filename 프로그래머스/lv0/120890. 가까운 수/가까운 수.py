def solution(array, n):
    answer = 0
    
    temp = []
    
    Find_min = 999999999
    idx = -1
    
    array.sort()
    
    for i in range(len(array)):
        temp.append(array[i] - n)
    
    for i in range(len(temp)):
        if(temp[i] < 0):
            temp[i] *= -1
    
    print(temp)
    
    for i in range(len(temp)):
        temp_num = Find_min
        Find_min = min(temp[i], Find_min)
        if(Find_min != temp_num):
            idx = i
        

    answer = array[idx]
    
    return answer