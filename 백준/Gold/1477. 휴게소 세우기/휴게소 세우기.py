N, M, L = map(int, input().split())

ls = list(map(int, input().split()))
ls.append(0)
ls.append(L)
ls.sort()
leftPoint = 1
rightPoint = L
answer = 0
while(True):
    if leftPoint > rightPoint:
        break

    count =0
    mid = (leftPoint + rightPoint) // 2

    for i in range(1, len(ls)):

        if (ls[i] - ls[i-1] > mid):
            count += (ls[i]-ls[i-1]-1)//mid

    if count > M:
        leftPoint = mid + 1

    else:
        rightPoint = mid - 1



print(leftPoint)