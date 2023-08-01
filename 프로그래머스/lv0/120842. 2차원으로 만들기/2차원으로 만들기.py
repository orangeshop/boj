def solution(num_list, n):
    answer = [[]]
    k = 0;
    for i in range(len(num_list)):
        answer[k].append(num_list[i])
        print(len(answer[k]))
        if(int(len(answer[k])) % n == 0 and i != len(num_list)-1):
            k += 1
            answer.append([])
    
    return answer