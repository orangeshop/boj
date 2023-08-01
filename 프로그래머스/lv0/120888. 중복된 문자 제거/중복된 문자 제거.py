def solution(my_string):
    answer = ''
    
    check = []
    answer += my_string[0]
    check.append(my_string[0])
    
    for i in range(1,len(my_string)):
        for k in range(len(check)):
            if(check[k] == my_string[i]):
                break
            if(k == len(check)-1):
                print("hi")
                answer += my_string[i]
                check.append(my_string[i])
            
                
    print(check)    
    return answer