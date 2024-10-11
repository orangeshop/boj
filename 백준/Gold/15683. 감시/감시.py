import sys

# sys.stdin = open("input.txt", "r")

N, M = map(int, input().split())

board = [[6 for _ in range(M + 2)] for _ in range(N + 2)]
vis = [[6 for _ in range(M + 2)] for _ in range(N + 2)]
ls = []
for i in range(1, N + 1):
    st = list(map(int, input().split()))
    for k in range(M):
        board[i][k + 1] = st[k]
        vis[i][k + 1] = 0
        if board[i][k + 1] != 0 and board[i][k + 1] != 6:
            ls.append([board[i][k + 1], i, k + 1])

# print(ls)

# 00 01 02
# 10 11 12
# 20 21 22


dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

answer = 1e9
Tc = len(ls)


def calc():
    cnt = 0

    for i in range(N + 2):
        for k in range(M + 2):
            if vis[i][k] == 0 and board[i][k] != 6:
                cnt += 1
    return cnt


sset = set()


def solve(depth):
    global answer

    if depth == Tc:

        # for i in range(N + 2):
        #     print(vis[i])
        # print()

        answer = min(answer, calc())
        return

    # if (depth, calc()) in sset:
    #     return
    #
    # sset.add((depth, calc()))

    for dr in range(4):
        bfs(ls[depth], dr, 1)
        solve(depth + 1)
        bfs(ls[depth], dr, -1)
    return


from collections import deque


def bfs(tls, dr, num):
    Q = deque()

    Q.append([tls[1], tls[2]])
    vis[tls[1]][tls[2]] += num

    cctv_two = {0: [1, 3], 1: [0, 2], 2: [1, 3], 3: [0, 2]}
    cctv_three = {0: [0, 1], 1: [1, 2], 2: [2, 3], 3: [3, 0]}
    cctv_four = {0: [0, 1, 3], 1: [0, 1, 2], 2: [1, 2, 3], 3: [2, 3, 0]}
    cctv_five = {0: [0, 1, 2, 3], 1: [0, 1, 2, 3], 2: [0, 1, 2, 3], 3: [0, 1, 2, 3]}

    if tls[0] == 1:
        while Q:
            cx, cy = Q.popleft()

            nx = cx + dx[dr]
            ny = cy + dy[dr]

            if board[nx][ny] == 6:
                continue

            vis[nx][ny] += num
            Q.append([nx, ny])

    elif tls[0] == 2:

        for i in cctv_two[dr]:
            while Q:
                cx, cy = Q.popleft()



                nx = cx + dx[i]
                ny = cy + dy[i]

                if board[nx][ny] == 6:
                    continue

                vis[nx][ny] += num
                Q.append([nx, ny])
            Q.append([tls[1], tls[2]])
    elif tls[0] == 3:
        for i in cctv_three[dr]:
            while Q:
                cx, cy = Q.popleft()

                nx = cx + dx[i]
                ny = cy + dy[i]

                if board[nx][ny] == 6:
                    continue

                vis[nx][ny] += num
                Q.append([nx, ny])
            Q.append([tls[1], tls[2]])
    elif tls[0] == 4:
        for i in cctv_four[dr]:
            while Q:
                cx, cy = Q.popleft()

                nx = cx + dx[i]
                ny = cy + dy[i]

                if board[nx][ny] == 6:
                    continue

                vis[nx][ny] += num
                Q.append([nx, ny])
            Q.append([tls[1], tls[2]])
    elif tls[0] == 5:
        for i in cctv_five[dr]:
            while Q:
                cx, cy = Q.popleft()

                nx = cx + dx[i]
                ny = cy + dy[i]

                if board[nx][ny] == 6:
                    continue

                vis[nx][ny] += num
                Q.append([nx, ny])
            Q.append([tls[1], tls[2]])


solve(0)
print(answer)
"""
0은 빈칸

6은 벽

1 ~ 5는 cctv

회전 해야함




"""
