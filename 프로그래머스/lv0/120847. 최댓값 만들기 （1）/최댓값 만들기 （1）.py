def solution(numbers):
    answer = 0
    numbers.sort(reverse = True)
    
    print(numbers)
    
    answer = numbers[0] * numbers[1]
    return answer