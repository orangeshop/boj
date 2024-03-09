N = int(input())

ls = list(map(int, input().split()))
ls.sort()

answer = 0
for i in range(len(ls)):
    leftPoint = 0
    rightPoint = len(ls)-1

    while(True):

        if leftPoint == i:
            leftPoint += 1

        if rightPoint == i:
            rightPoint -= 1

        if leftPoint >= rightPoint:
            break


        # print(ls[leftPoint], leftPoint, ls[rightPoint], rightPoint)

        if ls[leftPoint] + ls[rightPoint] == ls[i]:
            # print(ls[leftPoint], leftPoint, ls[rightPoint], rightPoint)
            answer += 1
            break

        if ls[leftPoint] + ls[rightPoint] > ls[i]:
            rightPoint -= 1
        else:
            leftPoint += 1


print(answer)