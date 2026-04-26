def solve(depth, ls):

    global v_set, answer



    tmp = ls[:]
    if (depth, "".join(tmp)) in v_set:
        return
    v_set.add((depth, "".join(tmp)))

    # print(ls)
    if depth == K:
        # print(ls)
        tmp = ls[:]
        # print( "".join(tmp) )
        answer = max(answer, int("".join(tmp)))
        return

    for i in range(0,len(ls)-1):
        for k in range(i+1, len(ls)):
            if ls[k] == '0' and i == 0 or ls[i] == '0' and k == 0:
                continue
            ls[i],ls[k] = ls[k],ls[i]
            solve(depth+1, ls)
            ls[k], ls[i] = ls[i], ls[k]

N, k = input().split()
answer = -1
K = int(k)

ls = []
v_set = set()
for i in range(len(N)):
    ls.append(N[i])

# print(len(ls), K)

solve(0, ls)
print(answer)