import math
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    N = list(map(int, input().split()))
    # arr = [i for i in range(N[0], N[1] + 1)]
    num = N[0]
    for i in range(N[0], N[1] + 1):
        if(num == 1):
            break
        num = math.gcd(num,i)

    # print(N)
    print("#", end= "")
    print(test_case, end= " ")
    print(num)

