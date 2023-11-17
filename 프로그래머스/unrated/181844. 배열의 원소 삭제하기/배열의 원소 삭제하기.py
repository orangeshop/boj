def solution(arr, delete_list):
    answer = []
    
    for i in range(len(arr)):
        check = False
        for k in range(len(delete_list)):
            if(arr[i] == delete_list[k]):
                check = True
        
        if(check == False):
            answer.append(arr[i])
    
    return answer