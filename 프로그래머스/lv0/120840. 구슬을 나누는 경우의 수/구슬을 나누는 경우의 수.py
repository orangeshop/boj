import math
def solution(balls, share):
    answer = 0
    
    tem1 = math.factorial(balls)
    tem2 = math.factorial(share)
    tem3 = math.factorial(balls - share)
    
    answer = int(tem1 / (tem2 * tem3))
    
    return answer