"""

R,C
각 칸에 영양분 5씩

한칸에 여러개의 나무가 심어져 있을 수 있음

4계절을 보냄

봄: 나무가 자신의 나이만큼 양분을 먹고, 나이가 1 증가
하나의 칸에 여러개의 나무가 존재한다면 가장 어린 나무가 양분을 먹는다
땅에 양분이 부족해 자신의 나이만큼 양분을 먹ㅁ을 수 없는 나무는 먹지 못하고 죽음

리스트에

여름 :
죽은 나무들이 양분으로 변함
나이 // 2

가을:
나무가 번식을 함.
번식하는 나무는 나이가 5의 배수여야함
인접한 8칸으로 퍼짐

겨울에는 땅에 양분을 추가


"""

import heapq
from collections import deque
import sys
input = sys.stdin.readline


def spring():
    """
    나이가 어린순
    칸에 있는 양분을 먹음
    땅에 양분이 충분 -> 나이 + 1 후 tmp arr에 잠시 넣고 다 끝나면 TreeInfo에 넣음
    땅에 양분이 부족 -> DeathTree에 넣음
    """
    global TreeInfo, grid

    for i in range(N):
        for k in range(N):
            TreeInfo[i][k].sort()
            for j in range(len(TreeInfo[i][k])):
                if grid[i][k] >= TreeInfo[i][k][j]:
                    grid[i][k] -= TreeInfo[i][k][j]
                    TreeInfo[i][k][j] += 1

                else:
                    while j < len(TreeInfo[i][k]):
                        grid[i][k] += (TreeInfo[i][k].pop()//2)
                    break



            #
            # for lk in range(N):
            #     for kl in range(N):
            #         print(TreeInfo[lk][kl], end=" ")
            #     print()
            #
            #
            # print()
            # print()



    return

def summer():

    while(True):
        if len(DeathTree) == 0:
            break

        z,x,y = DeathTree.pop()
        grid[x][y] += z//2

    return

def fall():
    dx = [-1,-1,-1,0,1,1,1,0]
    dy = [-1,0,1,1,1,0,-1,-1]
    tmp = []
    global TreeInfo

    for i in range(N):
        for k in range(N):
            TreeInfo[i][k].sort()
            for j in range(len(TreeInfo[i][k])):
                if TreeInfo[i][k][j] % 5 == 0:
                    for dir in range(8):
                        nx = i + dx[dir]
                        ny = k + dy[dir]
                        if nx < 0 or nx >= N or ny < 0 or ny >= N:
                            continue

                        TreeInfo[nx][ny].append(1)

    # for i in range(len(TreeInfo)):
    #     z, x, y =  TreeInfo[i]
    #     if z % 5 == 0:
    #         for dir in range(8):
    #             nx = x + dx[dir]
    #             ny = y + dy[dir]
    #             if nx < 0 or nx >= N or ny < 0 or ny >= N:
    #                 continue
    #
    #             TreeInfo.append([1,nx,ny])


    # TreeInfo.clear()
    # for z, x, y in tmp:
    #     TreeInfo.append([z, x, y])


    return

def winter():

    for i in range(N):
        for k in range(N):
            grid[i][k] += A[i][k]

    return


def solve(loop):
    global TreeInfo
    for i in range(loop):
        spring()
        # print(f"af sprint ${TreeInfo}")
        # see()
        # summer()
        # print(f"af summer ${TreeInfo}")
        # see()
        fall()
        # print(f"af fall ${TreeInfo}")
        # see()
        winter()
        # print(f"af winter ${TreeInfo}")
        # see()
    return 0

def see():
    print(TreeInfo)
    for i in range(N):
        print(grid[i])


N,M,K = map(int, input().rstrip().split())

A = []
for i in range(N):
    A.append(list(map(int, input().rstrip().split())))



grid = [[5 for _ in range(N)] for _ in range(N)]

DeathTree = []
TreeInfo = [[[] for _ in range(N)]for _ in range(N)]
for i in range(M):
    x,y,z = map(int, input().split())
    # heapq.heappush(TreeInfo, [z,x-1,y-1])
    # TreeInfo.append([z,x-1,y-1])
    TreeInfo[x-1][y-1].append(z)
# print()

# for g in grid:
#     print(g)
solve(K)
ans = 0
for i in range(N):
    for k in range(N):
        # print(TreeInfo[i][k], end=" ")
        # 
        # 
        # print()
        # print()
        ans += len(TreeInfo[i][k])
    # print()

print(ans)