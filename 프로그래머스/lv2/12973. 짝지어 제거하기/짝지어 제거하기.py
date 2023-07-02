def solution(s):
    answer = -1

    stack = []
    stack.append(s[0])
    for i in range(1, len(s)):
        if len(stack) == 0:
            stack.append(s[i])
            continue
        if stack[len(stack)-1] == s[i]:
            stack.pop()
            continue
        else:
            stack.append(s[i])
            continue

        
    print(stack)
    
    if len(stack) == 0:
        answer = 1
    else:
        answer = 0
    
    return answer