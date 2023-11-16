from collections import deque
import math
T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    num = int(input())
    N = 101
    board = []
    for i in range(N -1):
        str1 = list(map(int, input().split()))
        board.append(str1)

    # for i in range(N-1):
    #     print(f"{i} : {board[i]}")

    check = []
    for i in range(N-1):
        if (board[99][i] == 2):
            check = [99,i]

    # print(check)



    Q = deque()
    dx = [0, 0, 1]
    dy = [1,-1, 0]

    answer = 0
    for i in range(len(board)):
        if(board[0][i] == 1):

            # print(f"board {0} {i} : {board[0][i]}")
            vis = [[False for _ in range(N)] for _ in range(N)]
            Q.append([0, i])
            vis[0][i] = True

            while(len(Q) != 0):
                cur = Q.popleft()
                for dir in range(3):
                    nx = cur[0] + dx[dir]
                    ny = cur[1] + dy[dir]
                    # print(f"{nx} {ny}")
                    if nx < 0 or nx >= N-1 or ny < 0 or ny >= N-1:
                        continue

                    if(vis[nx][ny] == True or board[nx][ny] == 0):
                        continue

                    if(check[0] == nx and check[1] == ny):
                        # print(i)
                        answer = i

                    Q.append([nx,ny])
                    vis[nx][ny] = True
                    break


    print("#", end = "")
    print(test_case, end= " ")
    print(answer)
# 1
# 4
# 0100
# 1110
# 1011
# 1010