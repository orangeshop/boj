def solution(polynomial):
    answer = ''
    
    ch_list = polynomial.split(' ')
    print(ch_list)
    
    x_list = []
    num_list = []
    for i in range(len(ch_list)):
        
        if(ch_list[i][len(ch_list[i])-1] == "x"):
            x_list.append(ch_list[i])
        elif(ch_list[i][0] != '+'):
            num_list.append(ch_list[i])
    print(x_list)
    
    print(num_list)
    x_count = 0
    x_list_1 = []
    if(len(x_list) > 0):
        for i in range(len(x_list)):
            str_x = ''
            for k in range(len(x_list[i])):
            
                if(len(x_list[i]) == 1):
                    x_count += 1
                    break
                if(len(x_list[i])-1 == k):
                    break
                str_x += x_list[i][k]
            
            x_list_1.append(str_x)
        
        
        print(x_count)
        print(x_list_1)
    
        for i in range(len(x_list_1)):
            if(x_list_1[i] != ''):
                x_count += int(x_list_1[i])
            
        print(x_count)
        if(x_count != 1):
            answer += str(x_count)
        answer += 'x'
    
    num_list_1 = []
    num = 0
    if(len(num_list) > 0):
        if(len(x_list) > 0):
            answer += " + "
        for i in range(len(num_list)):
            str_x = ''
            for k in range(len(num_list[i])):
                str_x += num_list[i][k]
            num_list_1.append(str_x)
            
        print(num_list_1)
        
        for i in range(len(num_list_1)):
            num += int(num_list_1[i])
        answer += str(num)
        
        
        
        
        
        
        
        
    return answer