def solution(myString, pat):
    answer = 0
    str1 = myString.upper()
    pat1 = pat.upper()
    for i in range(len(str1)):
        if(str1[i : i + len(pat1)] == pat1):
            answer = 1
    
    return answer