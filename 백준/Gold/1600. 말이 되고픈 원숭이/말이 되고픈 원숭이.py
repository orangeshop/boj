from collections import deque

K = int(input())

M, N = map(int, input().split())

board = []

"""
00 01 02 03 04
10 11 12 13 14
20 21 22 23 24
30 31 32 33 34
40 41 42 43 44

-1,-2
-2,-1
-2,1
-1,2
1,2
2,1
2,-1
1,-2
"""

nightdx = [-1,-2,-2,-1,1,2,2,1]
nightdy = [-2,-1,1,2,2,1,-1,-2]

dx = [1,0,-1,0]
dy = [0,1,0,-1]


for i in range(N):
    tmp = list(map(int, input().split()))

    board.append(tmp)

vis = [[[False for _ in range(100)] for _ in range(M)] for _ in range(N)]
cnt = [[float("INF") for _ in range(M)] for _ in range(N)]

answer = float("INF")

# for _ in range(N):
#     print()

Q = deque()
Q.append([0,0,0,0]) # x,y,jumpcnt, movecnt
vis[0][0][0] = True
while(len(Q) != 0):
    # tmp = list(Q)
    # tmp.sort(key=lambda x : x[2])
    # Q = deque(tmp)
    cur = Q.popleft()

    # print(cur)
    # print()
    # for i in range(N):
    #     print(vis[i])
    # 
    # print()

    if cur[0] == N-1 and cur[1] == M-1:
        answer = min(answer, cur[3])


    if cur[2] < K:
        for dir in range(8):
            nx = cur[0] + nightdx[dir]
            ny = cur[1] + nightdy[dir]

            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                continue

            if vis[nx][ny][cur[2]+1] == True or board[nx][ny] == 1:
                continue

            Q.append([nx,ny, cur[2]+1, cur[3]+1])
            vis[nx][ny][cur[2]+1] = True

    for dir in range(4):
        nx = cur[0] + dx[dir]
        ny = cur[1] + dy[dir]

        if nx < 0 or nx >= N or ny < 0 or ny >= M:
            continue

        if vis[nx][ny] == 1:
            Q.append([nx, ny, cur[2], cur[3] + 1])
            vis[nx][ny] = 2
            continue

        if vis[nx][ny][cur[2]] == True or board[nx][ny] == 1:
            continue

        Q.append([nx, ny, cur[2], cur[3] + 1])
        vis[nx][ny][cur[2]] = True


if answer == float("INF"):
    answer = -1
print(answer)