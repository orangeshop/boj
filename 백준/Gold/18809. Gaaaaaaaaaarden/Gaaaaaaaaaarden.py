

from collections import deque

N, M, G, R = map(int, input().split())

board = [[0 for _ in range(M + 2)] for _ in range(N + 2)]

ls = []


dx = [0,1,0,-1]
dy = [1,0,-1,0]

def bfs(tls):

    global ls
    vis = [[0 for _ in range(M + 2)] for _ in range(N + 2)]
    Q = deque()


    for i in range(len(tls)):
        if tls[i] == 0:
            continue
        tx, ty = ls[i]
        Q.append([tx, ty])
        vis[tx][ty] = tls[i]


    cnt = 0
    while Q:
        cx, cy = Q.popleft()

        if vis[cx][cy] == 25000:
            continue

        for dir in range(4):
            nx = cx + dx[dir]
            ny = cy + dy[dir]

            if board[nx][ny] == 0 or vis[nx][ny] == 25000:
                continue

            if vis[nx][ny] == 0:
                if vis[cx][cy] < 0:
                    vis[nx][ny] = vis[cx][cy] - 1
                    Q.append([nx, ny])
                else:
                    vis[nx][ny] = vis[cx][cy] + 1
                    Q.append([nx, ny])
            else:
                if vis[cx][cy] < 0:
                    if vis[cx][cy] + vis[nx][ny] - 1 == 0:
                        cnt += 1
                        vis[nx][ny] = 25000
                else:
                    if vis[cx][cy] + vis[nx][ny] + 1 == 0:
                        cnt += 1
                        vis[nx][ny] = 25000

    return cnt

def solve(depth, rcnt, gcnt, tls):
    global answer, tc
    if depth == tc:
        if rcnt == R and gcnt == G:

            answer = max(answer, bfs(tls))
        return

    solve(depth + 1, rcnt, gcnt, tls + [0])
    solve(depth + 1, rcnt+1, gcnt, tls + [-1])
    solve(depth + 1, rcnt, gcnt+1, tls + [1])

for i in range(N):
    st = list(map(int, input().split()))
    for k in range(M):
        board[i+1][k+1] = st[k]
        if st[k] == 2:
            ls.append([i+1,k+1])

tc = len(ls)
answer = 0
arr = []
solve(0,0,0, arr)
print(answer)