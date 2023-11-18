T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.

for test_case in range(1, T + 1):

    answer = 0

    str1 = input()

    alphabet = [chr(i) for i in range(97 , 123)]
    str2 = ''

    for i in range(len(alphabet)):
        str2 += alphabet[i]
    # print(str2)
    for i in range(len(str1)):
        if(str1[:i+1] == str2[:i+1]):
            # print(f"{str1[:i]} {str2[:i]}")
            answer += 1




    print("#", end= "")
    print(test_case, end= " ")
    print(answer)