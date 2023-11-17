def solution(myString, pat):
    answer = 0
    
    
    temp = ''
    for i in range(len(myString)):
        if(myString[i] == 'A'):
            temp += 'B'
        elif(myString[i] == 'B'):
            temp += 'A'
            
    print(temp)
    
    
    for i in range(len(temp)):
        
        if(temp[i: len(pat) + i] == pat):
            return 1
    
    return answer