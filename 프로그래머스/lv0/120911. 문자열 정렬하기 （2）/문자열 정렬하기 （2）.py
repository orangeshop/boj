def solution(my_string):
    answer = ''
    l = []
    tem = my_string.lower()
    for i in range(len(tem)):
        l.append(tem[i])
        
    l.sort()
    for i in range(len(l)):
        answer += l[i]
    return answer