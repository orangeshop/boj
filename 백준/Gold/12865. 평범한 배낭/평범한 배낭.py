
N, M = map(int, input().split())

ls = []
dp = [[-1 for _ in range(100001)] for _ in range(101)]

def go(idx, val):
    if idx >= N:
        return 0
    if dp[idx][val] != -1:
        return dp[idx][val]
    dp[idx][val] = 0
    dp[idx][val] = go(idx+1, val)

    if val >= ls[idx][0]:
        dp[idx][val] = max(dp[idx][val], go(idx+1, val - ls[idx][0]) + ls[idx][1])

    return dp[idx][val]


for i in range(N):
    w, v = map(int,input().split())

    ls.append([w,v])

print(go(0, M))

