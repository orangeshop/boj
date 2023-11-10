from collections import deque

def solution(operations):
    answer = []
    
    # max_num_list = deque()
    # min_num_list = deque()
    
    test_stack = []
    
    for i in range(len(operations)):
        now_num = int(operations[i][2:])
        # print(max_num_list)
        # print(min_num_list)
        # print(test_stack)
        if(operations[i][0] == "I"):
            
            test_stack.append(now_num)
            
            # if(len(max_num_list) == 0):
            #     max_num_list.append(now_num)
            #     continue
            # elif(len(min_num_list) == 0):
            #     min_num_list.append(now_num)
            #     continue
            

            
        if(operations[i][0] == "D"):
            # print(operations[i])
            if(operations[i][2] == "1" and len(test_stack) > 0):
                test_stack.remove(max(test_stack))
            
            if(operations[i][2] == "-" and len(test_stack) > 0):
                test_stack.remove(min(test_stack))
            
            
            # if(operations[i][2] == "1" and len(max_num_list) > 0):
            #     print(len(max_num_list))
            #     # max_num_list.pop()
            #     continue
        
        
        
    print(test_stack)    
    if(len(test_stack) == 0):
        answer.append(0)
        answer.append(0)
    else:
        answer.append(max(test_stack))
        answer.append(min(test_stack))
    return answer