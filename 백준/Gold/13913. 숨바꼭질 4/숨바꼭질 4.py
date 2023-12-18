n, m = map(int , input().split())

# print(f"{n} {m}")

dp = [999999 for _ in range(100005)]

for i in range(n, -1, -1):
    dp[i] = abs(i - n)


dp[n] = 0


for k in range(3):
    for i in range(100001):
        if(i * 2 <= 100001):
            dp[i * 2] = min(dp[i * 2], dp[i] + 1)

        dp[i + 1] = min(dp[i + 1], dp[i] + 1)
        dp[i - 1] = min(dp[i - 1], dp[i] + 1)


from queue import Queue
root = [[] for _ in range(100005)]
vis = [False for _ in range(100005)]
Q = Queue()
Q.put(n)
vis[n] = True
while(Q.empty() != True):
    cur = Q.get()
    if(cur == m):
        break
    if(cur -1 >= 0 and vis[cur - 1] != True):
        vis[cur - 1] = True
        root[cur - 1].append(cur)
        Q.put(cur - 1)

    if (cur + 1 <= 100001 and vis[cur + 1] != True):
        vis[cur + 1] = True
        root[cur + 1].append(cur)
        Q.put(cur + 1)

    if (cur * 2 <= 100001 and vis[cur * 2] != True):
        root[cur * 2].append(cur)
        vis[cur * 2] = True
        Q.put(cur * 2)


grahp = Queue()
grahp.put(m)
print(dp[m])
answer = []
while(grahp.empty() != True):

    cur = grahp.get()
    if(len(root[cur]) == 0):
        break
    answer.append(cur)
    grahp.put(root[cur][0])


answer.append(n)
answer.reverse()

# print(answer)
for i in range(len(answer)):
    print(answer[i], end= ' ')