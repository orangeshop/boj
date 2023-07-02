def solution(s):
    answer = ''
    s = s.split(' ')
    
    s = list(map(int, s))
    s.sort()
    
    
    
    print(len(s))
    answer = f'{s[0]}' + f' {s[len(s)-1]}'
    return answer