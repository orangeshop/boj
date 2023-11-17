def solution(str_list, ex):
    answer = ''
    
    vis = [False for _ in range(len(str_list))]
    
    for i in range(len(str_list)):
        
        for k in range(len(str_list[i]) + 1):
            print(str_list[i][k: len(ex)])
            if(ex == str_list[i][k: len(ex) + k]):
                vis[i] = True
                
                
    print(vis)
    
    for i in range(len(vis)):
        if(vis[i] == False):
            answer += str_list[i]
    
    return answer