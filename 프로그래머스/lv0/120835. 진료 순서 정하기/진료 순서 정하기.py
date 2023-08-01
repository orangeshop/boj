def solution(emergency):
    answer = []
    ch = []
    idx = 1
    for i in range(101,0,-1):
        for k in range(len(emergency)):
            if(emergency[k] == i):
                ch.append(i)
                
    
    for i in range(len(emergency)):
        answer.append(0)
        
    print(ch)
    for i in range(len(emergency)):
        for k in range(len(ch)):
            if(emergency[i] == ch[k]):
                answer[i] = k+1
    
    
    return answer