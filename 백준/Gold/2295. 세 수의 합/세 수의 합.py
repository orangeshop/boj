

def binary(tar, num):
    global ans

    left = 0
    right = len(tls) - 1

    while left < right:
        mid = (left + right) // 2

        if tls[mid] < tar:
            left = mid + 1
        else:
            right = mid

    """
    left + mid + right == ls[idx]
    
    """

    # print(tls[right], tar)

    if tls[right] == tar:
        ans = max(num, ans)

    return


# def back(depth, arr):
#
#     if len(arr) == 3:
#         binary(sum(arr))
#         return
#
#     if depth >= N:
#         return
#
#     back(depth + 1, arr + [ls[depth]])
#     back(depth + 1, arr)


N = int(input())

ls = []
ans = -1e9

for _ in range(N):
    ls.append(int(input()))

ls = sorted(ls)
#
# back(0, [])

tls = []

for i in range(N):
    for k in range(N):
        tls.append(ls[i] + ls[k])

tls = sorted(tls)
# print(tls)
for i in range(N):
    for k in range(N):
        # print(ls[i] - ls[k], ls[i], ls[k])
        binary(ls[i] - ls[k], ls[i])


print(ans)
