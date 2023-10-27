from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer = 0
    
    weight_result = 0
    
    deque_truck_weights = deque(truck_weights)
    
    deque_bridge_now_weight = deque([])
    deque_bridge_now_idx = deque([])
    
    result_list = []
    
    idx = 0
    while(True):
        if len(result_list) == len(truck_weights):
            break
            
        if len(deque_bridge_now_idx) != 0:
            
            if idx - deque_bridge_now_idx[0] >= bridge_length:
                
                deque_bridge_now_idx.popleft()
                deque_bridge_now_weight.popleft()
                result_list.append(-1)
                
        if len(deque_truck_weights) != 0:
            if sum(deque_bridge_now_weight) + deque_truck_weights[0] <= weight:
                deque_bridge_now_weight.append(deque_truck_weights[0])
                deque_truck_weights.popleft()
                deque_bridge_now_idx.append(idx)
        idx += 1
        
        
    
    return idx