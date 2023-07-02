def solution(s):
    answer = ''
    
    
    s = s.split(' ')
    
    

    
    
    
    for i in range(len(s)):
        
           
        s[i] = list(s[i])
        
        for k in range(len(s[i])):
            s[i][k] = s[i][k].lower()
            if k == 0:
                s[i][k] = s[i][k].upper()
        if i != len(s)-1:
            s[i].append(" ")
        s[i] = "".join(s[i])
        
        
       

    answer = "".join(s)
    
    return answer