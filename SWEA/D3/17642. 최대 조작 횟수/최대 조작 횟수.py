T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):

    answer = -1
    A, B = map(int, input().split())

    num = abs(A - B)

    if (A > B):
        answer = -1
    elif (A == B):
        answer = 0
    elif (A < B):
        if (num <= 1):
            answer = -1

        elif (num % 2 == 1):
            answer = int((num - 1) // 2)
        else:
            answer = int(num // 2)

    print("#", end="")
    print(test_case, end=" ")
    print(answer)