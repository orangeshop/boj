from collections import deque

import heapq

def calc(arr):

    adj = [[] for _ in range(n+1)]

    for i in range(len(arr)):
        adj[arr[i][1]].append([arr[i][0], arr[i][2]])


    Q = []
    heapq.heappush(Q, [0, c])
    cnt = 0

    time = [1e9 for _ in range(n+1)]
    time[c] = 0

    while Q:
        dist, now = heapq.heappop(Q)

        if time[now] > dist:
            continue

        for next_node, next_cost in adj[now]:
            cost = dist + next_cost

            if time[next_node] > cost:
                time[next_node] = cost
                heapq.heappush(Q, (cost, next_node))

    # print(time)
    sumAnswer = 0
    for i in range(len(time)):
        if time[i] != 1e9:
            cnt += 1
            sumAnswer = max(time[i], sumAnswer)

    print(cnt, sumAnswer)
    return

T = int(input())

for TestCase in range(T):

    n, d, c = map(int, input().split())
    ls = []
    for _ in range(d):
        ls.append(list(map(int, input().split())))


    calc(ls)