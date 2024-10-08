import sys

# sys.stdin = open("input.txt", "r")

"""
while()
    2중 for문

가장 큰 블록 그룹을 찾는다
일반 블록의 색은 다 같음

0 무지개 
-1 블랙


무지개 블록 개수


좌상단 블록 그룹

점수는 블록 수 제거 ^ 2
제거 된 블록은 -1e9

중력 -> 따로 함수로 뺴야함

반 시계 90

중력

검은 블록 중력 x

블록 그룹 x 시 끝

 2 2 -1 3  1
 3 3  2 0 -1
 0 0  0 1  2
-1 3  1 3  2
 0 3  2 2  1
 
 

"""
from collections import deque
import copy


def see():
    for i in range(N):
        for k in range(N):
            if board[i][k] == -2:
                print(-2, end=" ")
            else:
                print(board[i][k], end=" ")
        print()


def findGroup(x, y, b, vis):
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]



    Q = deque()
    Q.append([x, y])
    vis[x][y] = True
    result = [[[x, y]], 0]

    for i in range(N):
        for k in range(N):
            if board[i][k] == 0:
                vis[i][k] = False

    while Q:
        cx, cy = Q.popleft()

        for dr in range(4):
            nx = cx + dx[dr]
            ny = cy + dy[dr]

            if nx < 0 or nx >= N or ny < 0 or ny >= N:
                continue
            if vis[nx][ny]:
                continue
            if board[nx][ny] < 0:
                continue
            if board[nx][ny] != b and board[nx][ny] != 0:
                continue

            if board[nx][ny] == 0:
                result[1] += 1

            Q.append([nx, ny])
            vis[nx][ny] = True
            result[0].append([nx, ny])

    return result


def rotate():
    global board
    tmp = [[] for _ in range(N)]

    # 04 -> 00
    # 14 -> 01
    # 24 -> 02
    # 34 -> 03
    # 44 -> 04

    for i in range(N - 1, -1, -1):
        for k in range(N):
            # print(i - (N-1), k, i)

            tmp[abs(i - (N - 1))].append(board[k][i])

    board = copy.deepcopy(tmp)


def gravity():
    for i in range(N - 1, -1, -1):
        for k in range(N - 1, -1, -1):

            if board[i][k] != -1 and board[i][k] != -2:
                # print(i, k, board[i][k])
                for j in range(N):
                    if i + j + 1 >= N:
                        break

                    if board[i + j + 1][k] == -1:
                        break

                    if board[i + j + 1][k] >= 0:
                        break

                    tmp = board[i + j + 1][k]
                    board[i + j + 1][k] = board[i + j][k]
                    board[i + j][k] = tmp


def removeBlock(ls):
    num = len(ls)

    for i in ls:
        board[i[0]][i[1]] = -2

    return num * num


N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

answer = 0
cnt = 0

while True:
    # print("---------------")
    tls = []

    vis = [[False for _ in range(N)] for _ in range(N)]

    for i in range(N):
        for k in range(N):
            if board[i][k] > 0:
                rl = findGroup(i, k, board[i][k], vis)

                if len(rl[0]) >= 2:
                    # print("rl", len(rl[0]))
                    tls.append(rl)

    # 여기서 가장 큰 그룹을 찾아야 함
    # 무지개 블록 개수, 좌상단

    find_ls = []
    find_rb = 0

    # print(tls)

    for i in tls:
        if len(i[0]) >= len(find_ls):
            # 그룹의 크기가 같다면?
            # 분기 처리

            xx, yy = 1e9, 1e9

            for cx,cy in i[0]:
                if board[cx][cy] != 0:
                    if cx <= xx:
                        if cx == xx:
                            if cy < yy:
                                xx, yy = cx, cy
                        else:
                            xx, yy = cx, cy

            if len(i[0]) == len(find_ls):
                # 크기가 같다면 무지개 블록으로 구분
                #
                if i[1] >= find_rb:
                    if i[1] == find_rb:
                        # 무지개 블록 개수도 같으니 좌표로 구분

                        # if i[0][0] < find_ls[0]:
                        #     find_ls = i[0]
                        #     find_rb = i[1]

                        if xx >= find_ls[0][0]:
                            # 행의 번호가 더 작다면

                            if xx == find_ls[0][0]:
                                # 열의 번호가 더 작은 것
                                if yy >= find_ls[0][1]:
                                    find_ls = i[0]
                                    find_rb = i[1]


                            else:
                                find_ls = i[0]
                                find_rb = i[1]


                    else:
                        find_ls = i[0]
                        find_rb = i[1]

            else:
                find_ls = i[0]
                find_rb = i[1]
    # print(find_ls)
    if len(find_ls) <= 1:
        break

    answer += removeBlock(find_ls)

    # print(find_ls, find_rb)

    gravity()

    # see()
    # print()

    rotate()

    # see()
    # print()

    gravity()

    # see()
    # print()

    cnt += 1

    # print(answer)

print(answer)
