def solution(num, total):
    answer = []
    temp_result = 0
    for i in range(-1000,total+1):
        temp_result = 0
        for k in range(num):
            temp_result += i + k
        print(temp_result)
        for k in range(num):
            if(temp_result == total):
                answer.append(i + k)
        
    return answer 