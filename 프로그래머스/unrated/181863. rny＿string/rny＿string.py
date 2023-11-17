def solution(rny_string):
    answer = ''
    result = []
    for i in range(len(rny_string)):
        if(rny_string[i] == "m"):
            result.append("r")
            result.append("n")
        else:
            result.append(rny_string[i])
    
    for i in range(len(result)):
        answer += result[i]
    
    return answer