def solution(slice, n):
    answer = 0
    if(n % slice > 0):
        answer = int(n / slice) + 1
    else:
        answer = int(n / slice)
    return answer