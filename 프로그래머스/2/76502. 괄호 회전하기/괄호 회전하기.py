from collections import deque

def solution(s):
    answer = 0
    
    Q = deque(s)
    
    for i in range(len(Q)):
        # print(Q)
        
        Q.appendleft(Q.pop())
        stack_arr = []
        stack_arr.append(Q[0])
        
        for k in range(1, len(Q)):
            if(len(stack_arr) == 0):
                stack_arr.append(Q[k])
                continue
            
            
            
            if stack_arr[len(stack_arr) -1] == "{" and Q[k] == "}":
                stack_arr.pop()
                continue
            
            elif stack_arr[len(stack_arr) -1] == "[" and Q[k] == "]":
                stack_arr.pop()
                continue
                
            elif stack_arr[len(stack_arr) -1] == "(" and Q[k] == ")":
                stack_arr.pop()
                continue
            else:
                stack_arr.append(Q[k])
                
            
        
        # print(stack_arr)
        
        if(len(stack_arr) == 0):
            answer += 1
        
        
        
    
    return answer