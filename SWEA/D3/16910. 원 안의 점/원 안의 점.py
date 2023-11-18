T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())

    x = [i for i in range(N + 1)]

    y = [i for i in range(N + 1)]

    # print(x)
    # print(y)

    cnt = 0

    for i in range(len(x)):
        for k in range(len(y)):
            if( x[i] ** 2 + y[k] ** 2 <= N ** 2):
                if(x[i] == 0 and y[k] == 0):
                    continue
                # print(f"{x[i]} {y[k]}")

                cnt += 1


    print("#", end= "")
    print(test_case, end=" ")
    print(((cnt* 4) + 1) - 4 * N)

# 5 12 = 7
# 317 360 = 43
# 31820 - 31417 = 403
#     0,1
# 0,1 0,0 0,1
#     0,1