import sys
from collections import deque
import copy
# sys.stdin = open("input.txt", "r")

def see():
    for i in range(N+2):
        print(board[i])

def taxiFindCus(x,y):
    """
    택시 출발지에서
    bfs로 모든 승객의 위치를 가져오고
    x,y, cnt
    승객 위치, cnt
    """

    # print("def set" , st_set)

    result = []
    Q = deque()
    vis = [[False for _ in range(N+2)] for _ in range(N+2)]
    cnt = [[0 for _ in range(N+2)] for _ in range(N+2)]
    dx = [0,1,0,-1]
    dy = [1,0,-1,0]


    Q.append([x,y])
    vis[x][y] = True
    if (x,y) in st_set:
        result.append([x,y,0])


    while Q:
        cx, cy = Q.popleft()

        for dr in range(4):
            nx = cx + dx[dr]
            ny = cy + dy[dr]

            if board[nx][ny] == 1:
                continue
            if vis[nx][ny] == True:
                continue

            vis[nx][ny] = True
            Q.append([nx,ny])
            cnt[nx][ny] = cnt[cx][cy] + 1

            # if board[nx][ny] > 1:
            if (nx,ny) in st_set:
                result.append([nx,ny, cnt[nx][ny]])


    result = sorted(result, key= lambda x: (x[2], x[0], x[1]))
    # print(result)
    if len(result) > 0:
        return result[0]
    else:
        return -1, -1, 1e9



def taxiFindGoal(x,y):
    target = board[x][y]
    board[x][y] = 0

    Q = deque()
    Q.append([x,y])

    vis = [[False for _ in range(N + 2)] for _ in range(N + 2)]
    cnt = [[0 for _ in range(N + 2)] for _ in range(N + 2)]

    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]

    tx, ty = 0, 0

    desx, desy = de_dict[(x,y)]

    vis[x][y] = True
    while Q:
        cx, cy = Q.popleft()

        for dr in range(4):
            nx = cx + dx[dr]
            ny = cy + dy[dr]

            if board[nx][ny] == 1:
                continue
            if vis[nx][ny] == True:
                continue

            vis[nx][ny] = True
            Q.append([nx, ny])
            cnt[nx][ny] = cnt[cx][cy] + 1

            if (nx, ny) == (desx, desy):
                # print(nx, ny, cnt[nx][ny])
                tx = nx
                ty = ny

    return tx, ty, cnt[tx][ty]



N, M, F = map(int, input().split())
board = [[1 for _ in range(N+2)] for _ in range(N+2)]

for i in range(1,N+1):
    st = list(map(int, input().split()))

    for k in range(N):

        board[i][k+1] = st[k]

sx, sy = map(int, input().split())

uls = []

st_set = set()
de_dict = {}

for i in range(2,M+2):
    cx, cy, tx, ty = map(int, input().split())
    st_set.add((cx, cy))
    de_dict[(cx,cy)] = (tx,ty)


# print(st_set)
# print(de_dict)
"""
택시 출발지에서 가장 가까운 곳으로 이동
행, 열 순으로 가장 작은 곳으로

한칸 이동 시 1 소모
도착시 소모 연료 2배

목적지 도착 시 연료 바닥은 x

while 

    
    
    taxi find cus
        이동 시 마다 연료 체크 
        여기서 연료 바닥은 계속 체크 
        break
        
    taxi find goal
        중간에 연료 바닥은 체크 
        근데 도착 시에는 예외
        break
        
    모든 유저 배달 끝이면 
    break
    
    
----------
한 칸에 도착지가 중복 이 있을 수 있음 


이러면 board 가 리스트 형태여야 함
근데 -1


"""

# see()




cnt = 0
for _ in range(M):
    # print("-------------")
    # print("tx, ty", sx, sy)
    sx, sy, rf = taxiFindCus(sx,sy)
    # print("First", rf)
    # print("tx, ty", sx, sy)


    F -= rf
    if F <= 0:
        break

    st_set.remove((sx, sy))

    sx, sy, rf = taxiFindGoal(sx, sy)
    F -= rf
    cnt += 1
    if F < 0:
        break
    F += rf * 2
    # print("Second", rf)
    # print("tx, ty", sx, sy)
    # print("remain", F)

if F <= 0:
    print(-1)
else:
    print(F)



"""


\

3 2 3 1





"""