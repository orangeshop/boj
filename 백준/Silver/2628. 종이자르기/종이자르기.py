from collections import deque


w, h = map(int, input().split())

N = int(input())

ls = [[0,w,0,h]]

calc = []
for _ in range(N):
    tmp = list(map(int, input().split()))
    calc.append(tmp)


calc.sort()

for i in range(len(calc)):
    size = len(ls)
    removeArr = []
    for k in range(size):
        # 가로
        # print(f"{k} {ls[k]}")

        if calc[i][0] == 0 and ls[k][2] <= calc[i][1] and calc[i][1] <= ls[k][3]:
            ls.append([ls[k][0], ls[k][1], ls[k][2], calc[i][1]])
            ls.append([ls[k][0], ls[k][1], calc[i][1], ls[k][3]])
            removeArr.append(ls[k])
        elif calc[i][0] == 1 and ls[k][0] <= calc[i][1] and calc[i][1] <= ls[k][1]:
            ls.append([ls[k][0], calc[i][1], ls[k][2], ls[k][3]])
            ls.append([calc[i][1], ls[k][1], ls[k][2], ls[k][3]])
            removeArr.append(ls[k])

    for k in range(len(removeArr)):
        ls.remove(removeArr[k])


    # print(ls)

answer = -1

for i in range(len(ls)):
    x = abs(ls[i][0] - ls[i][1])
    y = abs(ls[i][2] - ls[i][3])

    answer = max(answer, x * y)

print(answer)


