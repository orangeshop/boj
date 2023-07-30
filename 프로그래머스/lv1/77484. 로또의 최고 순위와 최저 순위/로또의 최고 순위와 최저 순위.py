def clac(num):
    
    if(num == 1 or num == 0):
        return 6
    elif(num == 2):
        return 5
    elif(num == 3):
        return 4
    elif(num == 4):
        return 3
    elif(num == 5):
        return 2
    elif(num == 6):
        return 1

def solution(lottos, win_nums):
    answer = []
    
    find_zero = 0
    
    find_corr = 0
    
    for i in range(len(lottos)):
        if(lottos[i] == 0):
            find_zero += 1
    
    for i in range(len(lottos)):
        for k in range(len(win_nums)):
            if(lottos[i] == win_nums[k]):
                find_corr += 1
    
    print(find_zero)
    print(find_corr)
    
    if(find_zero == 0):
        answer.append(clac(find_corr))
        answer.append(clac(find_corr))
    else:
        answer.append(clac(find_zero + find_corr))
        answer.append(clac(find_corr))
        
    return answer


