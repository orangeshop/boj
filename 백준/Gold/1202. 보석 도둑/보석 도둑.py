import heapq

N, K = map(int, input().split())
info = []
for i in range(N):
    heapq.heappush(info, list(map(int, input().split())))

C = []
for _ in range(K):
    C.append(int(input()))
C.sort()

answer = 0
tmp = []
for i in C:
    while info and i >= info[0][0]:
        heapq.heappush(tmp, -heapq.heappop(info)[1])
    if tmp:
        answer -= heapq.heappop(tmp)
    elif not info:
        break

print(answer)