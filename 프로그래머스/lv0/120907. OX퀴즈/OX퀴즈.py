def solution(quiz):
    answer = []
    
    
    for i in range(len(quiz)):
        str_split = quiz[i].split(' ')
        print(str_split)
        if(str_split[1] == '-'):
            x_num = int(str_split[0])
            y_num = int(str_split[2])
            total = x_num - y_num
            if(total == int(str_split[4])):
                answer.append('O')
            else:
                answer.append('X')
        elif(str_split[1] == '+'):
            x_num = int(str_split[0])
            y_num = int(str_split[2])
            total = x_num + y_num
            if(total == int(str_split[4])):
                answer.append('O')
            else:
                answer.append('X')
        
    
    return answer