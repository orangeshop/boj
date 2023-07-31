def solution(my_string):
    answer = 0
    
    temp = my_string.split(' ')
    
    print(temp)
    
    mode = False
    for i in range(len(temp)):
        
        print(temp[i])
        
        if(i == 0):
            answer += int(temp[i])
            continue
            
        if(temp[i] == '+'):
            mode = True
            continue
        elif(temp[i] == '-'):
            mode  = False    
            continue
            
        
        if(mode == True):
            answer += int(temp[i])
        else:
            answer -= int(temp[i])
        
        
    
    return answer