from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer = 0
    
    weight_result = 0
    
    deque_truck_weights = deque(truck_weights)
    
    deque_bridge_now_weight = deque([])
    deque_bridge_now_idx = deque([])
    
    result_list = []
    
    print(len(result_list))
    print(len(truck_weights))
    
    cnt = 0
    idx = 0
    while(True):
        if len(result_list) == len(truck_weights):
            break
        # if(cnt == 14):
        #     break
        # print(f'{deque_bridge_now_weight} {deque_bridge_now_idx} {idx}')
        
        if len(deque_bridge_now_idx) != 0:
             # print(f"{idx} {deque_bridge_now_idx[0]} {bridge_length}")
            if idx - deque_bridge_now_idx[0] >= bridge_length:
                # print("hi")
                deque_bridge_now_idx.popleft()
                deque_bridge_now_weight.popleft()
                result_list.append(-1)
                # idx += 1
                
        if len(deque_truck_weights) != 0:
            if sum(deque_bridge_now_weight) + deque_truck_weights[0] <= weight:
                deque_bridge_now_weight.append(deque_truck_weights[0])
                deque_truck_weights.popleft()
                # result_list.append(-1)
                deque_bridge_now_idx.append(idx)
        
        cnt += 1
        idx += 1
        
        
    
    return idx