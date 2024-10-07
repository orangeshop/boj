import sys
# sys.stdin = open("input.txt", "r")

N = int(input())
tls = list(map(int, input().split()))

set_tls = set(tls)

maxNum = max(tls)
arr = [0 for _ in range(maxNum+1)]





for i in tls:
    num = i

    if num == maxNum:
        continue

    for k in range(num * 2, maxNum+1, i):
        if k in set_tls:
            arr[i] += 1
            arr[k] -= 1


for i in tls:
    print(arr[i], end= " ")

