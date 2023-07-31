def solution(numbers, direction):
    answer = []
    
    if(direction == "right"):
        temp = numbers[len(numbers)-1]
        answer.append(temp)
        for i in range(len(numbers)-1):
            answer.append(numbers[i])
    else:
        temp = numbers[0]
        
        for i in range(len(numbers)-1):
            answer.append(numbers[i+1])
        answer.append(temp)
    return answer