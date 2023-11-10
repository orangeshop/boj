def check_str(target):
    check = True
    # print(int(ord('A')))
    # print(int(ord('Z')))
    # print(int(ord('a')))
    # print(int(ord('z')))
    # print(int(ord('1')))
    # print(int(ord('9')))
    
    for i in range(len(target)):
        if((65 <= int(ord(target[i])) and int(ord(target[i]))<= 90) or (97 <= int(ord(target[i])) and int(ord(target[i])) <= 122)):
            # result += target[i]
            check = True
        else:
            check = False
            return check
    
    return check


def solution(str1, str2):
    answer = 0
    
    result_str1 = []
    result_str2 = []
    
    for i in range(0, len(str1) - 1):
        temp_str = ''
        temp_str += str1[i]
        temp_str += str1[i + 1]
        result_str1.append(temp_str)
        
    for i in range(0, len(str2) - 1):
        temp_str = ''
        temp_str += str2[i]
        temp_str += str2[i + 1]
        result_str2.append(temp_str)

    af_check_arr_str1 = []
    af_check_arr_str2 = []
    
    for i in range(len(result_str1)):
        if(check_str(result_str1[i]) == True):
            af_check_arr_str1.append(result_str1[i].upper())
            
    for i in range(len(result_str2)):
        if(check_str(result_str2[i]) == True):
            af_check_arr_str2.append(result_str2[i].upper())
    
    print(af_check_arr_str1)
    print(af_check_arr_str2)
    
    
    union = []
    intersection = []
    
    vis = [True for _ in range(len(af_check_arr_str2))]
    
    
    for i in range(len(af_check_arr_str1)):
        intersection.append(af_check_arr_str1[i])
        
    for i in range(len(af_check_arr_str2)):
        intersection.append(af_check_arr_str2[i])
    
    for i in range(len(af_check_arr_str1)):
        for k in range(len(af_check_arr_str2)):
            if(af_check_arr_str1[i] == af_check_arr_str2[k] and vis[k] == True):
                union.append(af_check_arr_str1[i])
                vis[k] = False
                break
            # else:
            #     intersection.append(af_check_arr_str1[i])
            #     intersection.append(af_check_arr_str2[i])
                
    print(union)
    print(intersection)
    
    
    
    if(len(af_check_arr_str1) == 0 and len(af_check_arr_str2) == 0):
        answer = 65536
    else:
        answer = int(int(len(union)) / int(len(intersection) - len(union)) * 65536)
    return answer

#"abab", str2 = "baba"
# ab, ba, ab와 ba, ab, ba에 대하여 자카드 값 0.5로 32768
# 먼저 주어진 문자열을 2칸씩 나눈 후 해당 문자열에 숫자, 특수기호가 들어있으면 제외
# 그 후 계산
# 3번 문제 교 2 합 3