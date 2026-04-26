N, M = map(int, input().split())

ls = list(map(int, input().split()))

answer = -999999999999999
from collections import deque

Q = deque()

sum1 = 0
for i in range(M):
    Q.append(ls[i])
    sum1 += ls[i]

answer = max(sum1, answer)

for i in range(M, N):
    # print(Q)
    answer = max(sum1, answer)
    sum1 -= Q[0]
    Q.popleft()
    sum1 += ls[i]
    Q.append(ls[i])
answer = max(sum1, answer)
print(answer)