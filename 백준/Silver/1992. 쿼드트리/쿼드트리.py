def solve(x,y, size):
    if size == 1:
        print(board[x][y], end="")
        return
    num = board[x][y]
    for i in range(x, x + size):
        for k in range(y, y + size):
            if num != board[i][k]:
                print("(", end= "")
                size //= 2
                solve(x,y, size)
                solve(x, y + size, size)
                solve(x + size, y, size)
                solve(x + size, y + size, size)
                print(")", end= "")
                return

    print(board[x][y], end = "")
    return


N = int(input())

board = []

for _ in range(N):
    tmp = input()
    tmpArr = []
    for k in range(N):
        tmpArr.append(int(tmp[k]))

    board.append(tmpArr)


solve(0,0,N)