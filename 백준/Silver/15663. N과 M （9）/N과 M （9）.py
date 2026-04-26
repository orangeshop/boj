N, M = map(int, input().split())

ls = list(map(int, input().split()))


ls.sort()

def back(depth, N, M,result, totalResult, vis):
    # print(result)
    if depth == M:
        # print(result)
        # if result[:] not in totalResult:
        for k in range(len(result)):
            print(result[k], end=" ")
        print()
        # print(result[:])
        # totalResult.append(result[:])
        return

    chk = 0
    for i in range(0, N):
        if vis[i] == False and chk != ls[i]:
            vis[i] = True
            result.append(ls[i])
            chk = ls[i]
            back(depth+1, N, M, result, totalResult, vis)
            result.pop()
            vis[i] = False


result = []
totalResult = []
vis = [False for i in range(N)]
back(0, N, M, result, totalResult, vis)

# for i in range(len(totalResult)):
#     for k in range(len(totalResult[i])):
#         print(totalResult[i][k], end= " ")
#
#     print()