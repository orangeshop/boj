for test_case in range(1, 11):

    N = int(input())

    arr = list(map(int, input().split()))
    answer = 0
    # print(N)
    # print(len(arr))

    for i in range(N):
        find_max_idx = 0
        find_min_idx = 0

        for k in range(100):
            if arr[k] > arr[find_max_idx]:
                find_max_idx = k

            if arr[k] < arr[find_min_idx]:
                find_min_idx = k

        # print(f'idx {find_max_idx} {find_min_idx}')
        # print(f'num {arr[find_max_idx]} {arr[find_min_idx]}')

        arr[find_max_idx] -= 1
        arr[find_min_idx] += 1

    max_num = -1
    min_num = 999999

    for k in range(100):
        max_num = max(max_num, arr[k])
        min_num = min(min_num, arr[k])

    print("#", end= "")
    print(test_case, end= " ")
    print(max_num - min_num)