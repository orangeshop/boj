
N, L, R = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

"""
2 중 for 문

탐색 -> 가능한 얘들 Q

분배 (2중 for문 끝나면)

while 
    (time 카운트)
    for
        for
            bfs(가능한 친구들)
            (tmp 에 저장)
            
    board = tmp(deep copy)
"""
from collections import deque
import copy
import math
def bfs(x, y):

    global check

    Q = deque()
    Q.append([x,y])
    vis[x][y] = True

    dx = [0,1,0,-1]
    dy = [1,0,-1,0]

    calc = deque()
    calc.append([x,y])

    ssum = board[x][y]

    while Q:
        cx, cy = Q.popleft()

        for dr in range(4):
            nx = cx + dx[dr]
            ny = cy + dy[dr]

            if nx < 0 or nx >= N or ny < 0 or ny >= N:
                continue
            if vis[nx][ny]:
                continue

            if abs(board[cx][cy] - board[nx][ny]) < L or R < abs(board[cx][cy] - board[nx][ny]):
                continue

            # print(abs(board[cx][cy] - board[nx][ny]))
            Q.append([nx,ny])
            vis[nx][ny] = True

            calc.append([nx,ny])
            ssum += board[nx][ny]


    avg = ssum / len(calc)


    while calc:
        cx, cy = calc.popleft()
        tmpBoard[cx][cy] = math.floor(avg)





tmpBoard = [[0 for _ in range(N)] for _ in range(N)]
time = 0



while True:
    check = False
    vis = [[False for _ in range(N)] for _ in range(N)]
    for i in range(N):
        for k in range(N):
            tmpBoard[i][k] = 0

    for i in range(N):
        for k in range(N):
            if vis[i][k] == False:
                bfs(i,k)


    # print(tmpBoard)


    if board == tmpBoard:
        break

    board = copy.deepcopy(tmpBoard)

    # if check == False:
    #     break
    time += 1

print(time)