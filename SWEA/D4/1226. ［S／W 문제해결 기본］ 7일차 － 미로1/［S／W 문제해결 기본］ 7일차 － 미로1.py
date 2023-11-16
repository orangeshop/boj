from collections import deque
import math
T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    num = int(input())
    N = 16
    board = []
    for i in range(N):
        str1 = list(str(input()))
        board.append(str1)
    # for i in range(N):
    #     print(board[i])

    vis = [[False for _ in range(N)] for _ in range(N)]
    # dp = [[999999 for _ in range(N)] for _ in range(N)]

    Q = deque()
    Q.append([1,1])
    vis[1][1] = True
    # dp[0][0] = 0

    dx = [0,1,0,-1]
    dy = [1,0,-1, 0]

    while(len(Q) != 0):
        cur = Q.popleft()
        for dir in range(4):
            nx = cur[0] + dx[dir]
            ny = cur[1] + dy[dir]

            if nx < 0 or nx >= N or ny < 0 or ny >= N:
                continue

            if(vis[nx][ny] == True or board[nx][ny] == '1'):
                continue
            Q.append([nx,ny])
            vis[nx][ny] = True

    check = 0
    for i in range(len(board)):
        for k in range(len(board[i])):
            if(board[i][k] == "3" and vis[i][k] == True):
                check = 1

    # for i in range(len(board)):
    #     print(vis[i])

    print("#", end = "")
    print(num, end= " ")
    print(check)
# 1
# 4
# 0100
# 1110
# 1011
# 1010