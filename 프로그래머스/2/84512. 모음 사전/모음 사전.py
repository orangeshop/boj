def func(str_list, word):
    
    # print(str_list)
    
    temp_str = ""
    for i in range(len(str_list)):
        temp_str += str_list[i]
        
    if(temp_str == word):
        # print(temp_str)
        return True
    
    return False

def solution(word):
    answer = 0
    
    temp = ["A", "E", "I", "O", "U"]
    
    print(temp)
    test_str = ["" for _ in range(5)]
    cnt = 0
    for first in range(0,len(temp)):
        test_str[0] = temp[first]
        cnt += 1
        if(func(test_str, word) == True):
            answer = cnt
            return answer
        
        for second in range(0, len(temp)):
            test_str[1] =temp[second]
            cnt += 1
            if(func(test_str, word) == True):
                answer = cnt
                return answer
        
            for third in range(0, len(temp)):
                test_str[2] = temp[third]
                cnt += 1
                if(func(test_str, word) == True):
                    answer = cnt
                    return answer
            
                for forth in range(0, len(temp)):
                    test_str[3] = temp[forth]
                    cnt += 1
                    if(func(test_str, word) == True):
                        answer = cnt
                        return answer
                    
                    for fiveth in range(0, len(temp)):
                        test_str[4] = temp[fiveth]
                        cnt += 1
                        if(func(test_str, word) == True):
                            answer = cnt
                            return answer
                    
                    test_str[4] = ""
                test_str[3] = ""  
            test_str[2] = ""
        test_str[1] = ""
    
    return answer