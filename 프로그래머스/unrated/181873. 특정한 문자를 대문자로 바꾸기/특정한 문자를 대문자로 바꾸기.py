def solution(my_string, alp):
    answer = ''
    
    for i in range(len(my_string)):
        if(alp == my_string[i]):
            answer += alp.upper()
        else:
            answer += my_string[i]
    
    return answer