def solution(my_string):
    answer = 0
    pre_num_check = False
    temp = ''
    for i in range(len(my_string)):
        
        if(my_string[i] == '1'):    
            pre_num_check = True
            temp += '1'
        elif(my_string[i] == '2'):    
            pre_num_check = True
            temp += '2'
        elif(my_string[i] == '3'):    
            pre_num_check = True
            temp += '3'
        elif(my_string[i] == '4'):    
            pre_num_check = True
            temp += '4'
        elif(my_string[i] == '5'):    
            pre_num_check = True
            temp += '5'
        elif(my_string[i] == '6'):    
            pre_num_check = True
            temp += '6'
        elif(my_string[i] == '7'):    
            pre_num_check = True
            temp += '7'
        elif(my_string[i] == '8'):    
            pre_num_check = True
            temp += '8'
        elif(my_string[i] == '9'):    
            pre_num_check = True
            temp += '9'
        elif(my_string[i] == '0'):    
            pre_num_check = True
            temp += '0'
        else:
            if(pre_num_check == True):
                answer += int(temp)
                temp = ''
                pre_num_check = False
    if(temp != ''):
        answer += int(temp)
    return answer