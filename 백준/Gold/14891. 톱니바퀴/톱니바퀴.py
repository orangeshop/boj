def solve(target, rot, vis):

    # target에 해당하는 기어가 돌아감

    # rot를 기준으로
    # 1이 시계
    # -1 반시계
    reverRot = 0
    if rot == 1:
        reverRot = -1
    else:
        reverRot = 1


    if target == 0 and vis[target] == False:

        if gear[0][2] != gear[1][6]:
            vis[target] = True

            solve(1, reverRot, vis)


        if rot == 1:
            gear[target].appendleft(gear[target].pop())
        else:
            gear[target].append(gear[target].popleft())

    elif target == 1 and vis[target] == False:

        if gear[0][2] != gear[1][6]:
            vis[target] = True
            solve(0, reverRot, vis)

        if gear[2][6] != gear[1][2]:
            vis[target] = True
            solve(2, reverRot, vis)

        if rot == 1:
            gear[target].appendleft(gear[target].pop())
        else:
            gear[target].append(gear[target].popleft())

    elif target == 2 and vis[target] == False:

        if gear[2][6] != gear[1][2]:
            vis[target] = True
            solve(1, reverRot, vis)

        if gear[2][2] != gear[3][6]:
            vis[target] = True
            solve(3, reverRot, vis)

        if rot == 1:
            gear[target].appendleft(gear[target].pop())
        else:
            gear[target].append(gear[target].popleft())

    elif target == 3 and vis[target] == False:

        if gear[2][2] != gear[3][6]:
            vis[target] = True
            solve(2, reverRot, vis)

        if rot == 1:
            gear[target].appendleft(gear[target].pop())
        else:
            gear[target].append(gear[target].popleft())


from collections import deque
gear = []
for i in range(4):
    tmpArr = deque()
    tmp = input()
    for k in range(8):
        tmpArr.append(tmp[k])

    gear.append(tmpArr)

N = int(input())

ls = []

for _ in range(N):
    ls.append(list(map(int, input().split())))

for i in range(N):
    solve(ls[i][0]-1, ls[i][1],  [False] * 4)
    # break

# solve(2,-1, [False] * 4)

answer = 0
for i in range(4):
    if gear[i][0] == '1':
        answer += 2 ** i

# for i in range(4):
#     print(gear[i])
# print(ls)
print(answer)