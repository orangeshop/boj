from collections import deque
def solution(A, B):
    answer = 0
    B.sort()
    A.sort()
    # temp_B = deque(B)
    temp_A = deque(A) 
    # print(temp_A)
    
    vis = [False for _ in range(len(A))]
    
    for i in range(len(B)):
        # print(temp_A)
        if(B[i] > temp_A[0]):
            answer += 1
            temp_A.popleft()
    
    
    return answer


# 완탐은 불가능
# from collections import deque
# def solution(A, B):
#     answer = 0
#     B.sort()
#     A.sort()
#     # temp_B = deque(B)
#     temp_A = deque(A) 
#     # print(temp_A)
    
#     vis = [False for _ in range(len(A))]
    
#     for i in range(len(B)):
#         for k in range(len(temp_A)):
#             if(B[i] > A[k] and vis[k] == False):
#                 answer += 1
#                 vis[k] = True
#                 break
    
    
#     return answer

