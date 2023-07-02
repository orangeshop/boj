def solution(A,B):
    answer = 0

    A.sort(reverse = False)
    B.sort(reverse = True)
    sum = 0
    for i in range(len(A)):
        sum += A[i] * B[i]
        
    print(A)
    print(B)
    
    answer = sum
    return answer