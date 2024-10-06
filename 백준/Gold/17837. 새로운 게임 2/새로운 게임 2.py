import sys
# sys.stdin = open("input.txt", "r")

def solve():
    for ans in range(1, 1001):

        for i in range(K):
            cx, cy, dr = tls[i]
            nx = cx + dx[dr]
            ny = cy + dy[dr]

            if board[nx][ny] == 2:
                dr = changeDr[dr]
                nx = cx + dx[dr]
                ny = cy + dy[dr]
                tls[i][2] = dr
                if board[nx][ny] == 2:
                    continue

            for idx in range(len(v[cx][cy])):
                if v[cx][cy][idx] == i:
                    mlst = v[cx][cy][idx:]
                    if board[nx][ny] == 1:
                        mlst = mlst[::-1]
                    v[nx][ny] += mlst
                    if len(v[nx][ny]) >= 4:
                        return ans

                    v[cx][cy] = v[cx][cy][:idx]

                    for j in mlst:
                        tls[j][0], tls[j][1] = nx, ny
                    break


    else:
        return -1

N, K = map(int, input().split())

board = [[2] + [2 for _ in range(N)] + [2] for _ in range(N + 2)]

v = [[[]for _ in range(N+2)]for _ in range(N+2)]

for i in range(1,N+1):
    st = list(map(int, input().split()))
    for k in range(N):
        board[i][k+1] = st[k]

# 00 01 02
# 10 11 12
# 20 21 22

dx = [0,0,0,-1,1]
dy = [0,1,-1,0,0]

changeDr = {1:2, 2:1, 3:4, 4:3}
tls = []
for i in range(K):
    x,y,d = map(int, input().split())
    tls.append([x,y,d])
    v[x][y].append(i)


print(solve())