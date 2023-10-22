from collections import deque

def solution(queue1, queue2):
    answer = -2
    Q1 = deque(queue1)
    Q2 = deque(queue2)
    sum_Q1 = sum(queue1)
    sum_Q2 = sum(queue2)
    total_sum = sum_Q1 + sum_Q2
    target_num = total_sum/2
    
    print(target_num)
    
    cnt = 0
    while(True):
        if(sum_Q1 == target_num and sum_Q2 == target_num):
            break
        if(cnt >= 300000):
            answer = -1
            return answer 
        
        if(sum_Q1 > target_num):
            # print("q1 if")
            num = Q1.popleft()
            sum_Q2 += num
            sum_Q1 -= num
            Q2.append(num)
            cnt += 1
            
        if(sum_Q2 > target_num):
            # print("q2 if")
            num = Q2.popleft()
            sum_Q1 += num
            sum_Q2 -= num
            Q1.append(num)
            cnt += 1
            
        # print(f'q1 : {Q1}, q2 : {Q2}')
        
    
    answer = cnt
    return answer

# [101, 100], [102, 103]
    