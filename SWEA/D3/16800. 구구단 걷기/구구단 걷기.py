import math

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())
    answer = 10**12


    for i in range(1, int(math.sqrt(N)) + 1):
        if(N % i == 0):
            # print(f"{answer} {int(N / i)} {i}")
            answer = min(answer, (int(N / i) - 1) + (i - 1))


    print("#", end= "")
    print(test_case , end= " ")
    print(answer)




