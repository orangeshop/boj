def permu(depth, n , vis, ls, result, totalResult):

    # print(result)

    totalResult.append(result[:])

    for i in range(depth, n+1):
        if i + ls[i-1][0] <= n+1:
            result.append(ls[i-1][1])
            permu(i+ls[i-1][0], n, vis, ls, result, totalResult)
            result.pop()


N = int(input())

ls = []
for i in range(N):
    tmp = list(map(int, input().split()))
    ls.append(tmp)

# print(ls)
vis = [False for _ in range(N)]
result = []
totalResult = []

permu(1, N, vis, ls, result, totalResult)

answer = 0
for i in range(len(totalResult)):
    answer = max(answer, sum(totalResult[i]))
print(answer)
