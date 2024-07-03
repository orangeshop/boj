from collections import deque
import copy

dx = [0,0,1,-1]
dy = [1,-1,0,0]

def bfs(x,y,l,w,h, check):
    Q = deque()
    result = []
    
    
    global cLand, vis
    Q.append([x,y])
    vis[x][y] = True
    cnt = 1
    
    while Q:
        cur = Q.popleft()
        result.append(cur)
        
        for dir in range(4):
            nx = cur[0] + dx[dir]
            ny = cur[1] + dy[dir]
            
            if nx < 0 or nx >= h or ny < 0 or ny >= w:
                continue
            if l[nx][ny] == 0 or vis[nx][ny] == True:
                continue
            
            Q.append([nx,ny])
            
            vis[nx][ny] = True
            cnt += 1
    
    for i in range(len(result)):
        cLand[result[i][0]][result[i][1]] = [cnt, check]

def solution(land):
    answer = 0
    global cLand, vis
    
    h = len(land)
    w = len(land[0])
    vis = [[0 for _ in range(w)] for _ in range(h)]
    cLand = [[0 for _ in range(w)] for _ in range(h)]
    check = 1
    
    
    
    for i in range(h):
        for k in range(w):
            if land[i][k] == 1 and cLand[i][k] == 0:
                bfs(i,k,land, w,h, check)
                check += 1
    
    for i in range(w):
        ch = []
        r = 0
        for k in range(h):
            if cLand[k][i] != 0:
                if cLand[k][i][1] not in ch:
                    ch.append(cLand[k][i][1])
                    r += cLand[k][i][0]
        print(r)
        answer = max(answer, r)
    
    return answer