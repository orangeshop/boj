def solution(s):
    answer = ''
    ch = []
    tem = []
    for i in range(30):
        ch.append(0)
    for i in range(len(s)):
        ch[int(ord(s[i]) -97)] += 1
        
    print(ch)
    print(chr(97))
    for i in range(30):
        if(ch[i] == 1):
            tem.append(chr(i+97))
    
    tem.sort()
    
    print(tem)
    
    for i in range(len(tem)):
        answer += tem[i]
    
    return answer