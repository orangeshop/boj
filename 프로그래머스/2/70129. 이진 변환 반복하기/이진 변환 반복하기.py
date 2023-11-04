def zero_erase(s):
    zero_cnt = 0
    for i in range(len(s)):
        if(s[i] == "0"):
            zero_cnt += 1
    
    num = len(s) - zero_cnt
    
    print(num)
    
    arr = []
    
    while(num / 2 >= 1):
        arr.append(num%2)
        num /= 2
        num = int(num)
    
    print(num)
    arr.append(num)
    arr.reverse()
    
    
    print(arr)
    string_S = ""
    for i in range(len(arr)):
        string_S += str(arr[i])
    
    return string_S, zero_cnt



def solution(s):
    answer = []
    result = []
    temp_s = s
    cnt = 0
    zero_cnt = 0
    
    while(True):
        if(temp_s == "1"):
            break
        temp_s, temp_zero_cnt = zero_erase(temp_s)
        cnt += 1
        zero_cnt += temp_zero_cnt
    
    
    answer.append(cnt)
    answer.append(zero_cnt)
    
    return answer