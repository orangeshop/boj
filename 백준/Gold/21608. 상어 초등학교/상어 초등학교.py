import sys
# sys.stdin = open("input.txt", "r")


from collections import deque


def subSolveOne(idx):

    """
    비어있는 칸 중에서 좋아하는 학생이
    인접한 칸에 가장 많은 칸으로 자리를 정한다.
    """
    dx = [0,1,0,-1]
    dy = [1,0,-1,0]


    mx = -1
    empty_mx = -1
    for i in range(N):
        for k in range(N):
            if board[i][k] > 0: continue
            cnt = 0
            empty_cnt = 0

            for dr in range(4):
                nx = i + dx[dr]
                ny = k + dy[dr]

                if nx < 0 or nx >= N or ny < 0 or ny >= N:
                    continue
                if board[nx][ny] in vls[idx]:
                    cnt += 1
                if board[nx][ny] == 0:
                    empty_cnt += 1
            if mx < cnt or mx == cnt and empty_mx < empty_cnt:
                mx, empty_mx = cnt, empty_cnt
                ex, ey = i,k
    board[ex][ey] = idx


N = int(input())
vls = [[] for _ in range((N*N + 1))]
tls = [[-1,-1] for _ in range((N*N + 1))]
arr = []
board = [[0 for _ in range(N)] for _ in range(N)]

for i in range(N*N):
    idx, i1, i2, i3, i4 = map(int, input().split())
    arr.append(idx)
    vls[idx].append(i1)
    vls[idx].append(i2)
    vls[idx].append(i3)
    vls[idx].append(i4)

for i in arr:
    subSolveOne(i)

# print(board)

d = [0,1,10,100,1000]
dx = [0,1,0,-1]
dy = [1,0,-1,0]

answer = 0
for i in range(N):
    for k in range(N):

        cnt = 0

        for dr in range(4):
            nx = i + dx[dr]
            ny = k + dy[dr]

            if nx < 0 or nx >= N or ny < 0 or ny >= N:
                continue

            if board[nx][ny] in vls[board[i][k]]:
                cnt += 1

        answer += d[cnt]

print(answer)

