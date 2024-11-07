# import sys
# sys.stdin = open("input.txt", "r")
 
from collections import deque
from sys import stdin

def input():
    return stdin.readline().rstrip()

def bfs(x):
    Q = deque()

    vis[x] = True
    Q.append(x)

    while Q:
        cur = Q.popleft()

        for nxt in adj[cur]:
            if vis[nxt] == False:
                vis[nxt] = True
                table[nxt][0] = cur
                depth[nxt] = depth[cur] + 1
                Q.append(nxt)




def lca(x,y):
    if depth[x] < depth[y]:
        x, y = y, x

    for i in range(16, -1, -1):
        if depth[x] - (1 << i) >= depth[y]:
            x = table[x][i]

    if x == y:
        return x

    for i in range(16, -1,-1):
        if table[x][i] != table[y][i]:
            x = table[x][i]
            y = table[y][i]


    return table[x][0]





N = int(input())

table = [[0 for _ in range(18)] for _ in range(100001)]
vis = [False for _ in range(100001)]
depth = [0 for _ in range(100001)]
adj = [[] for _ in range(N+1)]

for i in range(N-1):
    x, y = map(int, input().split())
    adj[x].append(y)
    adj[y].append(x)

bfs(1)

j = 1
while (1 << j) < N:
    for i in range(1, N + 1):
        if table[i][j - 1] != 0:
            table[i][j] = table[table[i][j - 1]][j - 1]
    j += 1

M = int(input())

for i in range(M):
    x,y = map(int, input().split())
    print(lca(x,y))