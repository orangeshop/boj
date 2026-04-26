def move(x, y, dir):
    back = -1

    for i in range(1,10):
        nx, ny = x + dx[dir] * i, y + dy[dir] * i
        if board[nx][ny] == "#":
            return i + back
        if board[nx][ny] == "O":

            return i

        if board[nx][ny] == "B" or board[nx][ny] == "R":
            back -= 1

def solve(depth, rx, ry, bx, by):

    global answer, v_set
    if depth > answer:
        return 
    
    if (depth, rx, ry, bx, by) in v_set:
        return
    v_set.add((depth, rx, ry, bx, by))

    if depth >= 11:
        return

    for dir in range(4):
        r_cnt = move(rx, ry, dir)
        b_cnt = move(bx, by, dir)

        if r_cnt == 0 and b_cnt == 0:
            continue

        nrx, nry = rx + dx[dir] * r_cnt, ry + dy[dir] * r_cnt
        nbx, nby = bx + dx[dir] * b_cnt, by + dy[dir] * b_cnt


        if board[nbx][nby] == 'O':

            continue
        elif board[nrx][nry] == 'O':
            answer = min(answer, depth)
            return

        board[rx][ry], board[bx][by] = ".", "."
        board[nrx][nry], board[nbx][nby] = "R", "B"

        solve(depth+1, nrx, nry, nbx, nby)

        board[nrx][nry], board[nbx][nby] = ".", "."
        board[rx][ry], board[bx][by] = "R", "B"

dx = [0,1,0,-1]
dy = [1,0,-1,0]
N, M = map(int, input().split())

board = []
for _ in range(N):
    board.append(list(map(str, input())))

rbx = rby = bbx = bby = 0
for i in range(N):
    for k in range(M):
        if board[i][k] == "R":
            rbx, rby = i, k

        if board[i][k] == "B":
            bbx, bby = i, k


answer = 11
v_set = set()

solve(1, rbx, rby, bbx, bby)
if answer == 11:
    answer = -1

print(answer)