from collections import deque

def move(clst,dir,count):
    global nxtCloud
    # print(dir, count)
    for i in range(len(clst)):
        nx = clst[i][0] + ((count%N) * dx[dir])
        ny = clst[i][1] + ((count%N)  * dy[dir])

        if nx < 0:

            nx += N

        if ny < 0:

            ny += N

        if nx >= N:

            nx -= N

        if ny >= N:

            ny -= N

        # print(nx,ny , clst[i])
        nxtCloud.append([nx,ny])

dx = [0, 0,-1,-1,-1,0,1,1, 1]
dy = [0,-1,-1, 0, 1,1,1,0,-1]

N, M = map(int, input().split())
A = []

for _ in range(N):
    A.append(list(map(int, input().split())))

# A.append([0 for _ in range(N+2)])

ls = []

for _ in range(M):
    ls.append(list(map(int, input().split())))
    # a,b = map(int, input().split())
    # print(a,b)
    # ls.append([a-1,b-1])


cloud = deque([[N-1, 0],[N-1, 1],[N-2, 0],[N-2, 1]])

nxtCloud = deque()

for loop in range(M):
    # [1] 구름의 이동
    #     nxtcloud에 넣음

    move(cloud, ls[loop][0], ls[loop][1])

    # [2] 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
    # print(f"nxtcould{loop} {nxtCloud}")
    vis = [[False for _ in range(N)]for _ in range(N)]
    for i in range(len(nxtCloud)):
        A[nxtCloud[i][0]][nxtCloud[i][1]] += 1
        vis[nxtCloud[i][0]][nxtCloud[i][1]] = True
    # [3] 구름이 모두 사라진다.
    # 여기서 cloud 초기화
    # nxt Cloud 아직
    cloud.clear()

    # [3] 물복사버그 마법을 시전한다.
    #     경계를 넘어가면 안됨
    #     바로 갱신시 문제가 생길 가능성 존재
    for i in range(len(nxtCloud)):
        for dir in range(2,9,2):

            nx = nxtCloud[i][0] + dx[dir]
            ny = nxtCloud[i][1] + dy[dir]


            if nx < 0 or nx >= N or ny < 0 or ny >= N:
                continue

            if A[nx][ny] > 0:
                # print(nx,ny, nxtCloud[i])
                A[nxtCloud[i][0]][nxtCloud[i][1]] += 1


    # [4] 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다.
    #     이때 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 한다.
    #     생기는 구름은 cloud에 넣음
    #     여기서 nxtcloud 초기화
    # print(nxtCloud)
    for i in range(N):
        for k in range(N):
            if A[i][k] >= 2 and vis[i][k] == False:

                cloud.append([i,k])
                A[i][k] -= 2

    nxtCloud.clear()


answer = 0
for i in range(N):
    for k in range(N):
        answer += A[i][k]

print(answer)