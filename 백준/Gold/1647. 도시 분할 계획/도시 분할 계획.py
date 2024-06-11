import heapq

N,M = map(int, input().split())

un = [i for i in range(N+1)]
sz = [1 for _ in range(N+1)]
Q = []
for i in range(M):
    A,B,C = map(int , input().split())
    # adj[A].append([C, B])
    # adj[B].append([C, A])
    heapq.heappush(Q, [C,A,B])

# for i in range(len(adj)):
#     print(i, adj[i])

def find(x):
    if un[x] == x:
        return x
    else:
        un[x] = find(un[x])
        return un[x]

def union(x,y):
    x = find(x)
    y = find(y)

    if x == y:
        return

    if un[x] >= un[y]:
        sz[x] += sz[y]
        un[y] = x
    else:
        sz[y] += sz[x]
        un[x] = y

"""
분할된 두개의 마을은 내부의 집들이 연결 되어야함
"""
NN = 0
answer = 0
last = 0
while(True):
    if NN == N-1:
        break

    # print(sz)
    cur = heapq.heappop(Q)

    if find(cur[1]) != find(cur[2]):
        union(cur[1], cur[2])
        answer += cur[0]
        last = cur[0]
        NN += 1

print(answer - last)