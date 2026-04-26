N, M = map(int, input().split())
adj = []
d = [1e9] * (N + 1)
for i in range(M):
    a,b,c = map(int, input().split())
    adj.append([a,b,c])

def bf(start):
    d[start] = 0
    for i in range(N):
        for k in range(M):
            cur = adj[k][0]
            nxt = adj[k][1]
            cost = adj[k][2]

            if d[cur] != 1e9 and d[nxt] > d[cur] + cost:
                d[nxt] = d[cur] + cost

                if i == N-1:
                    return True

    return False

negative_cycle = bf(1)



if negative_cycle:
    print(-1)

else:
    for i in range(2,N+1):

        if d[i] == 1e9:
            print(-1)
        else:
            print(d[i])