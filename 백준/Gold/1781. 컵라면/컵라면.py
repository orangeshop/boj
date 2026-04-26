
import heapq
from collections import deque
N = int(input())

ls = []

for _ in range(N):
    # ls.append(list(map(int, input().split())))
    heapq.heappush(ls, list(map(int, input().split())))

ls.sort(key = lambda x: (x[0], -x[1]))

# print(ls)

answer = []
time = 0
while ls:
    cur = heapq.heappop(ls)
    # print(cur, time)
    time = cur[0]
    heapq.heappush(answer, cur[1])

    if time < len(answer):
        heapq.heappop(answer)

print(sum(answer))