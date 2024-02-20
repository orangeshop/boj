def CheckFish(SkarkSize):
    if nowSharkWeight >= SkarkSize:
        return True
    else:
        return False

def FishCntFunc(nowPointX, nowPointY, n):
    Q = deque()
    Q.append([nowPointX, nowPointY])
    vis = [[False for _ in range(n)] for _ in range(n)]

    FishCnt = 0
    while(len(Q) != 0):
        cur = Q.popleft()

        for dir in range(4):
            nx = cur[0] + dx[dir]
            ny = cur[1] + dy[dir]

            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue

            if vis[nx][ny] == True:
                continue

            if(board[nx][ny] != 0 and board[nx][ny] != 9 and CheckFish(board[nx][ny])):
                FishCnt += 1


            Q.append([nx,ny])
            vis[nx][ny] = True

    if(FishCnt == 0):
        return 0


def TargetFish(nowPointX, nowPointY):
    # print()
    dp = [[0 for _ in range(n)]for _ in range(n)]
    vis = [[False for _ in range(n)] for _ in range(n)]
    vis[nowPointX][nowPointY] = True
    Q = deque()
    Q.append([nowPointX, nowPointY])

    ls = []

    while (len(Q) != 0):
        cur = Q.popleft()

        for dir in range(4):
            nx = cur[0] + dx[dir]
            ny = cur[1] + dy[dir]

            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue
            # print(f"{nx} {ny}")
            if vis[nx][ny] == True or nowSharkWeight < board[nx][ny]:
                continue



            dp[nx][ny] = dp[cur[0]][cur[1]] + 1

            if board[nx][ny] != 0 and board[nx][ny] != 9 and nowSharkWeight > board[nx][ny]:
                ls.append([dp[nx][ny], nx, ny, board[nx][ny]])

            Q.append([nx, ny])
            vis[nx][ny] = True




    ls.sort(key= lambda x : (x[0], x[1], x[2], x[3]))

    # print(f"ls fish {ls}")
    #
    # for i in range(n):
    #     print(dp[i])

    # checkingWeight = False
    # if ls[0][0] == nowSharkWeight:
    #     checkingWeight = True
    if(len(ls) == 0):
        return -1, -1, -1
    board[nowPointX][nowPointY] = 0
    board[ls[0][1]][ls[0][2]] = 0
    return dp[ls[0][1]][ls[0][2]], ls[0][1],  ls[0][2]

from collections import deque
n = int(input())

global board
board = []

global dx
global dy

dx = [1,0,-1,0]
dy = [0,1,0,-1]


nowPointX = 0
nowPointY = 0

global nowSharkWeight
nowSharkWeight = 2


for i in range(n):
    tmp = list(map(int, input().split()))
    board.append(tmp)
    for k in range(n):
        if(tmp[k] == 9):
            nowPointX = i
            nowPointY = k

answer = 0
CNT = 0
EATCnt = 0
while(True):

    num = FishCntFunc(nowPointX, nowPointY, n)

    if num == 0:
        # print("No fish")
        break
    elif num == 1:
        # print("one fish")
        num, nowPointX, nowPointY = TargetFish(nowPointX, nowPointY)
        if(num == -1):
            break
        answer += num

        EATCnt += 1
    else:
        # print("lot of fish")
        num, nowPointX, nowPointY = TargetFish(nowPointX, nowPointY)
        if (num == -1):
            break
        answer += num
        EATCnt += 1

    # print(answer)

    if(EATCnt == nowSharkWeight):
        nowSharkWeight += 1
        EATCnt = 0

print(answer)

"""
BFS 상하좌우

1. 더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.
2. 먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
3. 먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
4. 거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다.
5. 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.


아기 상어와 물고기는 모두 크기를 가지고 있고, 이 크기는 자연수이다. 
가장 처음에 아기 상어의 크기는 2이고, 아기 상어는 1초에 상하좌우로 인접한 한 칸씩 이동한다.

아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없고, 
나머지 칸은 모두 지나갈 수 있다. 아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다. 
따라서, 크기가 같은 물고기는 먹을 수 없지만, 그 물고기가 있는 칸은 지나갈 수 있다.

아기 상어가 어디로 이동할지 결정하는 방법은 아래와 같다.

1. 더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.
2. 먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
3. 먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
4. 거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다.
5. 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.

아기 상어의 이동은 1초 걸리고, 물고기를 먹는데 걸리는 시간은 없다고 가정한다. 
즉, 아기 상어가 먹을 수 있는 물고기가 있는 칸으로 이동했다면, 이동과 동시에 물고기를 먹는다. 물고기를 먹으면, 그 칸은 빈 칸이 된다.

아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한다. 예를 들어, 크기가 2인 아기 상어는 물고기를 2마리 먹으면 크기가 3이 된다.

공간의 상태가 주어졌을 때, 아기 상어가 몇 초 동안 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는지 구하는 프로그램을 작성하시오.
"""