import sys
# sys.stdin = open("input.txt", "r")

input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))
M = int(input())
d = [[0 for _ in range(N)] for _ in range(N)]

for i in range(N):
    for s in range(N-i):
        e = s + i

        if s == e:
            d[s][e] = 1
        elif arr[s] == arr[e]:

            if s+1 == e:
                d[s][e] = 1
            elif d[s+1][e-1] == 1:
                d[s][e] = 1

for i in range(M):
    s, e = map(int, input().split())
    print(d[s-1][e-1])