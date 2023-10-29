def solution(k, tangerine):
    answer = 0
    
    tangerine_list = [0 for _ in range(max(tangerine) + 1)]
    
    for i in range(len(tangerine)):
        tangerine_list[tangerine[i]] += 1
        
    tangerine_list.sort(reverse = True)
    
    # print(tangerine_list)
    num = 0
    for i in range(len(tangerine_list)):
        if(k <= num + tangerine_list[i]):
            answer += 1
            return answer
        else:
            
            num += tangerine_list[i]
            answer += 1
            # print(num)
    
    return answer