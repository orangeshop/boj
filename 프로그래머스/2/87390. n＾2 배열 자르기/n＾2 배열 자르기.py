def solution(n, left, right):
    answer = []

    for i in range(left, right + 1):
        first = int(i / n)
        second = int(i % n)
        answer.append(max(first, second) + 1)
        
    
        
    return answer

# 0으로 초기화된 2차원 배열을 만들어도 시간 초과 
# 착각을 한 부분 : n^2이 10^7이라고 착각
# 시뮬레이션으로는 답을 찾을 수 없음.    
#     board = [[0 for _ in range(n)] for _ in range(n)]
#     cnt = 0
#     for i in range(n):
#         for k in range(n):
#             board[i][k] = max(i,k) + 1
#             if cnt >= left and cnt <= right:
#                 answer.append(board[i][k])
#             cnt += 1