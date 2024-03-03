def permu(depth,t, size):
    global arr, M, vis, answer, homeLs, marketLs
    if depth == M:
        # print(arr)
        tmpsum = [9999999 for _ in range(len(homeLs))]

        for k in range(M):
            # print(marketLs[totalResult[i][k]][0])
            for j in range(len(homeLs)):
                tmpsum[j] = min(tmpsum[j],clca(marketLs[arr[k]][0], homeLs[j][0], marketLs[arr[k]][1],homeLs[j][1]))

        # print(tmpsum)
        answer = min(answer, sum(tmpsum))
        return

    for i in range(t, size):
        # print(i, depth)
        if vis[i] == False:
            vis[i] = True
            arr.append(i)
            permu(depth+1,i+1, size)
            arr.pop()
            vis[i] = False

def clca(x1, x2, y1, y2):
    return abs(x1-x2) + abs(y1-y2)

N, M = map(int, input().split())
board = []
answer = 99999999
homeLs = []
marketLs = []
for i in range(N):
    tmp = list(map(int, input().split()))
    for k in range(len(tmp)):
        if tmp[k] == 1:
            homeLs.append([i,k])
        if tmp[k] == 2:
            marketLs.append([i, k])

totalResult = []
vis = [False for _ in range(len(marketLs))]
arr = []
permu(0,0, len(marketLs))

print(answer)