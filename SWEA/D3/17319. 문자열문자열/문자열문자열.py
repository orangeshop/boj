T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())
    answer = "Yes"
    check = False
    str1 = input()

    write1 = str1[:int(N/2)]
    result = []

    for i in range(len(str1)):
        result.append(str1[int(i * int(N/2)) :int(i * int(N/2)) + int(N/2)])

    # print(write)
    #
    # print(result)

    for i in range(len(result)):
        if(result[i] != write1 and result[i] != ""):
            check = True

    if(check == True or N == 1):
        answer = "No"

    print("#", end= "")
    print(test_case , end= " ")
    print(answer)