def backtracking(depth , k, dungeons, vis, result):
    
    # if depth == len(dungeons):
    cnt = 0
    for i in range(len(vis)):
        if(vis[i] == True):
            cnt += 1
        
    result.append(cnt)
        # return
    
    for i in range(len(dungeons)):
        if vis[i] == False:
            
            if k >= dungeons[i][0]:
                if k - dungeons[i][1] >= 0:
                    vis[i] = True
                    backtracking(depth + 1 , k - dungeons[i][1], dungeons, vis, result)
                    vis[i] = False
    return

def solution(k, dungeons):
    
    answer = -1
    
    temp_dungeons = dungeons
    temp_dungeons.sort()
    vis = [False for _ in range(len(dungeons))]
    result = [0]
    backtracking(0, k ,temp_dungeons, vis, result)
    
    # print(result)
    return int(max(result))