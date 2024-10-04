def go(direction, cx, cy):

    global dice

    if (direction == 1):
        # 동쪽
        """
        00 01 02
        10 11 12
        20 21 22
        30 31 32
        
        10 -> 11 -> 12 -> 31
        """

        tmp = dice[3][1]

        dice[3][1] = dice[1][2]
        dice[1][2] = dice[1][1]
        dice[1][1] = dice[1][0]
        dice[1][0] = tmp


    elif (direction == 2):
        # 서쪽
        #  10 <- 11 <- 12 <- 31
        tmp = dice[1][0]

        dice[1][0] = dice[1][1]
        dice[1][1] = dice[1][2]
        dice[1][2] = dice[3][1]
        dice[3][1] = tmp

    elif (direction == 3):
        # 북쪽
        # 01 -> 31 -> 21 -> 11
        tmp = dice[1][1]

        dice[1][1] = dice[2][1]
        dice[2][1] = dice[3][1]
        dice[3][1] = dice[0][1]
        dice[0][1] = tmp

    elif (direction == 4):
        # 남쪽
        # 11 -> 21 -> 31 -> 01
        tmp = dice[0][1]

        dice[0][1] = dice[3][1]
        dice[3][1] = dice[2][1]
        dice[2][1] = dice[1][1]
        dice[1][1] = tmp

    if board[cx][cy] == 0:
        board[cx][cy] = dice[3][1]
    else:
        dice[3][1] = board[cx][cy]
        board[cx][cy] = 0

    return dice[1][1]

N, M, x, y, K = map(int, input().split())
board = [[0 for _ in range(M)] for _ in range(N)]

for i in range(N):
    st = list(map(int, input().split()))
    for k in range(M):
        board[i][k] = st[k]


ls = list(map(int, input().split()))

dice = [[0,0,0],[0,0,0],[0,0,0],[0,0,0]]

# print(board)
# print(ls)
# print(dice)

# 00 01 02
# 10 11 12
# 20 21 22

dx = [0, 0,0,-1,1]
dy = [0, 1,-1,0,0]

sx = x
sy = y

for i in range(len(ls)):
    nx = sx + dx[ls[i]]
    ny = sy + dy[ls[i]]

    if nx < 0 or nx >= N or ny < 0 or ny >= M:
        continue

    print(go(ls[i], nx, ny))
    # print(nx, ny)
    # print(dice)
    sx = nx
    sy = ny