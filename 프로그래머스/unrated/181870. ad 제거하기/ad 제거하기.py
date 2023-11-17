def solution(strArr):
    answer = []
    
    vis = [False for _ in range(len(strArr))]
    
    for i in range(len(strArr)):
        for k in range(len(strArr[i])):
            if(strArr[i][k : 2+k] == "ad"):
                vis[i] = True
    
    print(vis)
    
    for i in range(len(vis)):
        if(vis[i] == False):
            answer.append(strArr[i])
    
    return answer