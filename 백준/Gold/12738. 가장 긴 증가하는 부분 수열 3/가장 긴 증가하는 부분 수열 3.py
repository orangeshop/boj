N = int(input())
ls = list(map(int, input().split()))

LIS = [-1000000005]

for item in ls:

    if LIS[-1] < item:
        LIS.append(item)

    else:

        left = 0
        right = len(LIS)

        while left < right:
            mid = (left + right) // 2

            if LIS[mid] < item:
                left = mid + 1
            else:
                right = mid

        LIS[right] = item

print(len(LIS) -1)