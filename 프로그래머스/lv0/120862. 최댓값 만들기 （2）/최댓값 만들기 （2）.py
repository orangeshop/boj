def solution(numbers):
    answer = 0
    
    # for i in range(len(numbers)):
    #     if(numbers[i] < 0):
    #         numbers[i] *= -1
    
    numbers.sort(reverse =True)
    temp1 =  numbers[0] * numbers[1]
    temp2 =  numbers[len(numbers)-2] * numbers[len(numbers)-1]
    answer = max(temp1, temp2)
    
    return answer