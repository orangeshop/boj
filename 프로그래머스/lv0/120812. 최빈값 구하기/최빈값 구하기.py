def solution(array):
    answer = 0
    
    check_list = []
    for i in range(1001):
        check_list.append(0)
    
    for i in range(len(array)):
        check_list[array[i]] += 1
    
    max_num = 0
    max_check = False
    max_idx = 0
    for i in range(len(check_list)):
        # print(check_list[i])
        temp = max_num
        max_num = max(max_num, check_list[i])
        if(temp != max_num):
            max_idx = i
        
        
    for i in range(len(check_list)):
        if(i == max_idx):
            continue
        if(max_num == check_list[i]):
            max_check = True
    
    if(max_check == True):
        answer = -1
    else:
        answer = max_idx
    return answer