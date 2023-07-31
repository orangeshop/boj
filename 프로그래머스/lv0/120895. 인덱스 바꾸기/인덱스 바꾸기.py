def solution(my_string, num1, num2):
    answer = ''
    
    temp1 = my_string[num1]
    temp2 = my_string[num2]
    
    temp_list = []
    
    print(temp1)
    print(temp2)
    
    for i in range(len(my_string)):
        temp_list.append(my_string[i])
            
    print(temp_list)
    
    temp_list[num1] = temp2
    temp_list[num2] = temp1
    
    for i in range(len(temp_list)):
        answer += temp_list[i]
    
    return answer