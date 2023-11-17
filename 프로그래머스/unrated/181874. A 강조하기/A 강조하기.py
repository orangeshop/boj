def solution(myString):
    answer = ''
    temp = myString.lower()
    for i in range(len(temp)):
        if(temp[i] == 'a'):
            answer += "A"
        else:
            answer += temp[i]
    
    return answer