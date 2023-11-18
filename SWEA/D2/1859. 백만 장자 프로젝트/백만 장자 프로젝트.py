from collections import deque



T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):

    N = int(input())
    arr = list(map(int, input().split()))
    vis = [False for _ in range(1000000)]
    answer = 0
    check = False
    for i in range(N - 1, -1, -1):
        # print(i)
        if(i == 0):
            break

        for k in range(i - 1, -1, -1):

            # print(f"{arr[i]} {arr[k]}")

            if (arr[i] > arr[k] and vis[k] == False):
                answer += arr[i] - arr[k]
                vis[k] = True

            if (arr[i] <= arr[k]):
                break


    print("#", end="")
    print(test_case, end=" ")
    print(answer)
