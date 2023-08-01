def solution(num_list):
    answer = []
    
    for i in range(len(num_list)):
        answer.append(num_list[i])
    
    print(num_list[len(num_list)-2])
    print(num_list[len(num_list)-1])
    if(num_list[len(num_list)-2] < num_list[len(num_list)-1]):
        answer.append((num_list[len(num_list)-2] - num_list[len(num_list)-1]) * -1)
    else:
        answer.append(num_list[len(num_list)-1] * 2)
    return answer