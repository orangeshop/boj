def solution(n):
    answer = []
    ch = []
    
    for i in range(2,n+1):
        chk = False
        
        for k in range(2, i):
            
            if(i % k == 0):
                chk = True
                break
        if(chk == False):
            ch.append(i)
    
    print("----------")      
    print(ch)
    
    for i in range(len(ch)):
        if(n % ch[i] == 0):
            answer.append(ch[i])
    
    return answer