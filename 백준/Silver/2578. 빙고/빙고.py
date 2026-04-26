def check(myBoard, vis, target):

    cnt = 0

    for i in range(5):
        for k in range(5):
            if myBoard[i][k] == target:
                vis[i][k] = True

    # for i in range(5):
    #     print(vis[i])
    #
    # print(target)
    #
    # print()
    for i in range(5):
        if(vis[i][0] == True
                and vis[i][1] == True
                and vis[i][2] == True
                and vis[i][3] == True
                and vis[i][4] == True):
            cnt += 1

        if (vis[0][i] == True
                and vis[1][i] == True
                and vis[2][i] == True
                and vis[3][i] == True
                and vis[4][i] == True):
            cnt += 1

    if (vis[0][0] == True
            and vis[1][1] == True
            and vis[2][2] == True
            and vis[3][3] == True
            and vis[4][4] == True):
        cnt += 1

    if (vis[0][4] == True
            and vis[1][3] == True
            and vis[2][2] == True
            and vis[3][1] == True
            and vis[4][0] == True):
        cnt += 1

    return cnt

myBoard = []

vis = [[False for _ in range(5)]for _ in range(5)]

for _ in range(5):
    ls = list(map(int, input().split()))
    myBoard.append(ls)


youBoard = []
outCheck = False
for i in range(5):
    ls = list(map(int, input().split()))
    for k in range(5):
        if 3 <= check(myBoard, vis, ls[k]):
            print((i * 5) + k + 1)
            outCheck = True
            break

    if(outCheck == True):
        break

