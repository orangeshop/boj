from collections import deque
import copy
def check(movels):
    global answer
    dx = [-1,0,1,0]
    dy = [0,1,0,-1]

    Q = deque()
    tmp = copy.deepcopy(board)
    for i in range(len(movels)):

        # for k in range(N):
        #     print(tmp[k])
        # print()

        # print(Q)

        vis = [[False for _ in range(N)] for _ in range(N)]

        if movels[i] == 0:
            # 위
            for r in range(N):
                for c in range(N):
                    if tmp[r][c] != 0:
                        Q.append([r, c])

            while Q:
                cur = Q.popleft()
                nx = cur[0] + dx[0]
                ny = cur[1] + dy[0]
                if nx < 0 or nx >= N or ny < 0 or ny >= N:
                    continue
                if tmp[nx][ny] == tmp[cur[0]][cur[1]] and vis[nx][ny] == False:
                    tmp[nx][ny] += tmp[cur[0]][cur[1]]
                    tmp[cur[0]][cur[1]] = 0
                    vis[nx][ny] = True
                    # Q.append([nx,ny])
                elif tmp[nx][ny] == 0:
                    tmp[nx][ny] += tmp[cur[0]][cur[1]]
                    tmp[cur[0]][cur[1]] = 0
                    Q.append([nx, ny])
                else:
                    continue

        elif movels[i] == 1:
            for r in range(N-1, -1, -1):
                for c in range(N):
                    if tmp[c][r] != 0:
                        Q.append([c, r])
            """
            03
            13
            23
            33
            """
            while Q:
                cur = Q.popleft()
                nx = cur[0] + dx[1]
                ny = cur[1] + dy[1]
                if nx < 0 or nx >= N or ny < 0 or ny >= N:
                    continue
                if tmp[nx][ny] == tmp[cur[0]][cur[1]] and vis[nx][ny] == False:
                    tmp[nx][ny] += tmp[cur[0]][cur[1]]
                    tmp[cur[0]][cur[1]] = 0
                    vis[nx][ny] = True
                    # Q.append([nx,ny])
                elif tmp[nx][ny] == 0:
                    tmp[nx][ny] += tmp[cur[0]][cur[1]]
                    tmp[cur[0]][cur[1]] = 0
                    Q.append([nx, ny])
                else:
                    continue

        elif movels[i] == 2:
            for r in range(N-1,-1,-1):
                for c in range(N):
                    if tmp[r][c] != 0:
                        Q.append([r, c])

            """
            30
            31
            32
            33
            """
            while Q:
                cur = Q.popleft()
                nx = cur[0] + dx[2]
                ny = cur[1] + dy[2]
                if nx < 0 or nx >= N or ny < 0 or ny >= N:
                    continue
                if tmp[nx][ny] == tmp[cur[0]][cur[1]] and vis[nx][ny] == False:
                    tmp[nx][ny] += tmp[cur[0]][cur[1]]
                    tmp[cur[0]][cur[1]] = 0
                    vis[nx][ny] = True
                    # Q.append([nx, ny])
                elif tmp[nx][ny] == 0:
                    tmp[nx][ny] += tmp[cur[0]][cur[1]]
                    tmp[cur[0]][cur[1]] = 0
                    Q.append([nx, ny])
                else:
                    continue
        elif movels[i] == 3:
            for r in range(N):
                for c in range(N):
                    if tmp[c][r] != 0:
                        Q.append([c, r])
            """
            00
            10
            20
            30
            """
            while Q:
                cur = Q.popleft()
                nx = cur[0] + dx[3]
                ny = cur[1] + dy[3]
                if nx < 0 or nx >= N or ny < 0 or ny >= N:
                    continue
                if tmp[nx][ny] == tmp[cur[0]][cur[1]] and vis[nx][ny] == False:
                    tmp[nx][ny] += tmp[cur[0]][cur[1]]
                    tmp[cur[0]][cur[1]] = 0
                    vis[nx][ny] = True
                    # Q.append([nx, ny])
                elif tmp[nx][ny] == 0:
                    tmp[nx][ny] += tmp[cur[0]][cur[1]]
                    tmp[cur[0]][cur[1]] = 0
                    Q.append([nx, ny])
                else:
                    continue

    for i in range(N):
        # print(tmp[i])
        for k in range(N):
            answer = max(answer, tmp[i][k])

    # if answer == 64:
    #     print(movels)
    #     print()
    #     for i in range(N):
    #         print(tmp[i])
    # 
    #     print("-------------")
    return

def solve(depth, arr):

    if depth == 5:
        # print(arr)
        check(arr)
        return

    solve(depth + 1, arr + [0])
    solve(depth + 1, arr + [1])
    solve(depth + 1, arr + [2])
    solve(depth + 1, arr + [3])
    # solve(depth + 1, arr)


N = int(input())

board = []

for _ in range(N):
    board.append(list(map(int, input().split())))

answer = 0
solve(0, [])
# 0 위
# 1 오
# 2 아
# 3 왼
# check([0, 0, 3, 2, 1])
print(answer)