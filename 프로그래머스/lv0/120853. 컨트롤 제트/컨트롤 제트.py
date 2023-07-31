def solution(s):
    answer = 0
    
    temp = s.split(" ")
    
    for i in range(len(temp)):
        print(temp[i])
        if(temp[i] == "Z"):
            temp[i-1] = ""
            temp[i] = ""
    print(temp)
    
    for i in range(len(temp)):
        if(temp[i] == ''):
            continue
        answer += int(temp[i])
    
    
    return answer