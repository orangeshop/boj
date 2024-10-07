import sys
# sys.stdin = open("input.txt", "r")

def dfs(x,y):
    global ans
    vis[x][y] = 1
    nx, ny = x + dx[board[x][y]], y + dy[board[x][y]]
    if vis[nx][ny] == 0:
        dfs(nx, ny)
    if vis[nx][ny] == 1:
        ans += 1

    vis[x][y] = 2




N, M = map(int, input().split())
board = [[0 for _ in range(M)] for _ in range(N)]
vis = [[0 for _ in range(M)] for _ in range(N)]

ans = 0

# 00 01 02
# 10 11 12
# 20 21 22

dx = [1,-1,0,0]
dy = [0,0,-1,1]

for i in range(N):
    st = input()
    for k in range(M):
        if st[k] == "D":
            board[i][k] = 0
        elif st[k] == "U":
            board[i][k] = 1
        elif st[k] == "L":
            board[i][k] = 2
        elif st[k] == "R":
            board[i][k] = 3


for i in range(N):
    for k in range(M):
        if vis[i][k] == 0:
            dfs(i,k)

print(ans)