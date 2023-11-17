T = int(input())
global result
result = 0
def backtracking(depth, N, vis):
    global result
    # for i in range(N):
    #     print(vis[i])
    #
    # print()

    if(depth == N):
        cnt = 0
        for i in range(len(vis)):
            for k in range(len(vis)):
                if(vis[i][k] == True):
                    cnt += 1
        # print(f"cnt {cnt}")
        if(cnt == N):
            result += 1
            return

        return


    for i in range(N):
        # print(f"i { i }")
        if(vis[depth][i] == False):
            check = 0
            out_check = False
            for k in range(depth, -1, -1):
                # print(f"{k} {i + check} {i - check}")
                # print(vis[k][i - check])

                if(vis[k][i] == True):
                    # print(f"in i up  {vis[k][i]} {k} {i}")
                    out_check = True
                    break

                if(i + check < N and vis[k][i + check] == True):
                    # print(f"in i + ch {vis[k][i + check]} {k} {i + check}")
                    out_check = True
                    break

                if(i - check >= 0 and vis[k][i - check] == True):
                    # print(f"in i - ch {vis[k][i - check]} {k} {i - check}")
                    out_check = True
                    break

                check += 1

            if(out_check == True):
                # print("hi")
                continue

            vis[depth][i] = True
            backtracking(depth + 1, N, vis)
            vis[depth][i] = False



    return

for test_case in range(1, T + 1):
    N = int(input())
    vis = [[False for _ in range(N)] for _ in range(N)]
    result = 0
    backtracking(0, N, vis)

    print("#", end= "")
    print(test_case , end= " ")
    print(result)