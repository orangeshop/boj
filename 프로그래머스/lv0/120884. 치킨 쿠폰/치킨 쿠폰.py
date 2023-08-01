def solution(chicken):
    answer = -1
    
    answer = func(chicken)
    
    return answer

def func(chicken):
    
    temp = int(chicken/10)
    num = temp
    print(f'mod before{num}')
    num += int(chicken%10)

    if(num < 10):
        return temp
    return temp + func(num)