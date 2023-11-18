T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())
    x = 10 ** 9
    y = x - N

    if(N % 2 == 1):
        x -= 1
        y = x - N
    else:
        y = x - N

    print('#', end = "")
    print(test_case , end= " ")
    print(x , end= " ")
    print(y)