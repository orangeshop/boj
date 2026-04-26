# from collections import deque
from queue import PriorityQueue

pq = PriorityQueue()

N = int(input())
M = int(input())

adj = [[] for _ in range(N+1)]

for i in range(M):
    a,b,c = map(int, input().split())

    if a != b:
        adj[a].append([c,b])
        adj[b].append([c,a])

vis = [False for _ in range(N+1)]
pq.put([0,1])
tmp = 0
cnt = 0
while(pq.empty() != True):

    cur = pq.get()

    if vis[cur[1]] == True:
        continue

    vis[cur[1]] = True
    tmp += cur[0]
    cnt += 1
    if cnt == N:
        break
    for w, n in adj[cur[1]]:
        if vis[n] == True:
            continue
        pq.put([w, n])



print(tmp)
