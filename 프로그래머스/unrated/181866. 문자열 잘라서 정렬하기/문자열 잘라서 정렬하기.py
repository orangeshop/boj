def solution(myString):
    answer = []
    result = myString.split('x')
    
    result.sort()
    
    for i in range(len(result)):
        if(result[i] != ""):
            answer.append(result[i])
    
    return answer