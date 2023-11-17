import copy

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    x, y, z = map(int, input().split())

    orgzin_x = copy.deepcopy(x)
    orgzin_y = copy.deepcopy(y)
    orgzin_z = copy.deepcopy(z)

    answer = 0
    check = False
    for i in range(0, 1001):
        if(check == True):
            break
        for k in range(0,10):
            num = float(i) + round(k/10, 1)
            # print(num)
            x -= num

            if(y - x == z - y):
                answer = num
                check = True
                break
            x = orgzin_x
            x += num

            if (y - x == z - y):
                answer = num
                check = True
                break

            x = orgzin_x


            y -= num

            if y - x == z - y:
                answer = num
                check = True
                break
            y = orgzin_y

            y += num

            # print(f"{y} {x} == {z} {y}")
            if (y - x == z - y):
                # print("hi")
                answer = num
                check = True
                break

            y = orgzin_y


            z -= num

            if (y - x == z - y):
                answer = num
                check = True
                break
            z = orgzin_z
            z += num

            if (y - x == z - y):
                answer = num
                check = True
                break

            z = orgzin_z


    
    print("#", end = '')
    print(test_case , end= " ")
    print(answer)