def solution(myString):
    answer = []
    
    result = myString.split('x')
    
    # print(result)
    
    for i in range(len(result)):
        answer.append(len(result[i]))
    
    return answer