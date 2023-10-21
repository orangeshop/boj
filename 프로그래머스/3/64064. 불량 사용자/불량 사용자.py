def classification(str1, str2):
    # print(f'{str1} {str2}')
    if len(str1) != len(str2):
        return 1
    
    for i in range(len(str1)):
        if(str1[i] == (str1[i] if str2[i] == "*" else str2[i])):
            continue
        else:
            return 1
    
    return 0
    

def dfs(depth, vis, banned_list, user_list, result_str, result):
    
    if(depth == len(banned_list)):
        # print(f'result {result_str}')
        result.append(list(result_str))
        return
    
    for i in range(len(user_list)):
        check = True
        if vis[i] == True:
            continue
            
        
        if(classification(user_list[i], banned_list[depth]) == 0):
            vis[i] = True
            result_str[depth] = user_list[i]
            dfs(depth + 1, vis, banned_list, user_list, result_str, result)
            vis[i] = False
            continue
    return

def solution(user_id, banned_id):
    answer = 0 
    user_id.sort()
    banned_id.sort()
    user_list = user_id
    banned_list = banned_id
    
#     print(user_list)
#     print(banned_list)
    
    vis = [False for _ in range(len(user_id))]
    result_str = ['' for _ in range(len(banned_id))]
    result = []
    
    dfs(0, vis, banned_list, user_list, result_str, result)
    
    for i in range(len(result)):
        result[i].sort()
        
    tuple_result = [] 
    
    for i in range(len(result)):
        tuple_result.append(tuple(result[i]))
    
    set_result= set(tuple_result)
    print(set_result)
    
    return len(set_result)
    