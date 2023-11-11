def solution(skill, skill_trees):
    answer = 0
    
    result = []
    
    for i in range(len(skill_trees)):
        str1 = ""
        for k in range(len(skill_trees[i])): 
            for j in range(len(skill)):
                if(skill_trees[i][k] == skill[j]):
                    str1 += skill_trees[i][k]
            
            
        result.append(str1)
        
    print(result)
    vis = [False for _ in range(len(result))]
    result_str = ""
    for i in range(len(skill)):
        result_str += skill[i]
        
        for k in range(len(result)):
            if(result[k] == '' and vis[k] == False):
                answer += 1
                vis[k] = True
            
            if(result_str == result[k] and vis[k] == False):
                vis[k] = True
                answer += 1
    
    
    
    return answer