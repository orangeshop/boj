N, M = map(int, input().split())
ls = []
for _ in range(N):
    ls.append(int(input()))


ls = sorted(ls)

left = 0
right = ls[-1] * M

while left < right:
    mid = (left + right) // 2

    tmp = []

    for i in ls:
        tmp.append(mid // i)

    if sum(tmp) < M:
        left = mid + 1
    else:
        right = mid


print(right)