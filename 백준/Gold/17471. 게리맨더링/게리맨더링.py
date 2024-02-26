from collections import deque
from sys import stdin
def bfs(ls):
    Q = deque()
    Q.append(ls[0])
    graphVis = [False for _ in range(N+1)]
    graphVis[ls[0]] = True
    num = population[ls[0]-1]
    cnt = 1
    while(len(Q) != 0):
        cur = Q.popleft()

        for dir in range(len(adj[cur])):
            if  adj[cur][dir] in ls and graphVis[adj[cur][dir]] == False:
                num += population[adj[cur][dir]-1]
                Q.append(adj[cur][dir])
                cnt += 1
                graphVis[adj[cur][dir]] = True



    if cnt != len(ls):
        return 9999999
    return num


def back(depth, n, vis):
    global answer
    if depth == n:
        resultA = []
        resultB = []

        for i in range(1,N+1):
            if vis[i] == False:
                resultA.append(i)
            else:
                resultB.append(i)

        # print(resultA, resultB)
        x, y = bfs(resultA), bfs(resultB)
        # print(x, y)
        if x != 9999999 and y != 9999999:
            answer = min(answer, abs(x - y))

        return

    for i in range(1, N+1):
        if vis[i] == False:
            vis[i] = True
            back(depth+1, n, vis)
            vis[i] = False

global N
N = int(stdin.readline())


global population
population = list(map(int, stdin.readline().split()))
global adj
adj = [[] for _ in range(N+1)]

for i in range(1,N+1):
    tmp = deque(map(int, stdin.readline().split()))

    tmp.popleft()
    adj[i] = list(tmp)


global answer
answer = 9999999

for i in range(1, N//2+1):
    vis = [False for _ in range(N+1)]
    back(0, i, vis)

if answer == 9999999:
    answer = -1
print(answer)