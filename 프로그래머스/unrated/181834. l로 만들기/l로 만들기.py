def solution(myString):
    answer = ''
    
    for i in range(len(myString)):
        if(ord(myString[i]) - ord('l') < 0):
            answer += 'l'
        else:
            answer += myString[i]
    return answer