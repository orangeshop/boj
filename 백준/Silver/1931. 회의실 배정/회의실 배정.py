from collections import deque


def back(depth):
    print("")


n = int(input())

global ls

ls = []

for i in range(n):
    ls.append(list(map(int, input().split())))

answer = 0

ls.sort(key=lambda x: (x[1], x[0]))
# 100_000_000_000
# print(ls)

Q = deque([])
Q.append(ls[0])
for i in range(1, n):

    if Q[len(Q) - 1][1] <= ls[i][0]:
        Q.append(ls[i])
        continue

# print(Q)
print(len(Q))
