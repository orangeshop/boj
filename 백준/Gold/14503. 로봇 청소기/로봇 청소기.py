
from collections import deque

Q = deque()


def solveOne(x, y):
    global ans, vis
    if (board[x][y] == 0 and vis[x][y] == False):
        # board[x][y] = 1

        ans += 1

        vis[x][y] = True


        return True
    else:
        return False


def solveTwo(x, y, d):
    nx = x + dx[(d + 2) % 4]
    ny = y + dy[(d + 2) % 4]
    if nx < 0 or nx >= N or ny < 0 or ny >= M:
        return -1, -1, -1
    if board[nx][ny] == 1:
        return -1, -1, -1


    return nx, ny, d


def solveThree(x, y, d):
    d += -1
    if d < 0:
        d = 3

    nx = x + dx[d]
    ny = y + dy[d]

    if nx < 0 or nx >= N or ny < 0 or ny >= M:
        return x, y, d
    if vis[nx][ny] == False:
        return nx, ny, d
    else:
        return x, y, d


N, M = map(int, input().split())

x, y, d = map(int, input().split())

board = [[0 for _ in range(M)] for _ in range(N)]
vis = [[False for _ in range(M)] for _ in range(N)]

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

maxCnt = 0

for i in range(N):
    st = list(map(int, input().split()))
    for k in range(M):
        board[i][k] = st[k]
        if st[k] == 0:
            maxCnt+=1
        else:
            vis[i][k] = True

# print(N, M)
# print(x, y, d)
# print(board)



Q.append([x, y, d])
ans = 0
ii = 0
while Q:
    

    cx, cy, cd = Q.popleft()
    # print(cx, cy, cd)
    solveOne(cx, cy)



    roundCheck = False
    # False면 주위가 모두 청소
    # True면 주위에 빈칸

    for dir in range(4):
        nx = dx[dir] + cx
        ny = dy[dir] + cy
        if nx < 0 or nx >= N or ny < 0 or ny >= M:
            continue
        if vis[nx][ny] == True:
            continue
        if vis[nx][ny] == False:
            roundCheck = True
            break

    if roundCheck == False:
        rx, ry, rd = solveTwo(cx, cy, cd)
        if rx == -1 and ry == -1 and rd == -1:
            break
        else:
            Q.append([rx, ry, rd])
    else:
        rx, ry, rd = solveThree(cx, cy, cd)
        Q.append([rx, ry, rd])

print(ans, end="")

# for i in range(N):
#     print(vis[i])
