dx = [-1,-1,-1,0,1,1,1,0]
dy = [-1,0,1,1,1,0,-1,-1]


# 11,12,13
# 21,22,23
# 31,32,33
def solution(board):
    answer = 0
    
    vis = [[0 for i in range(len(board[0]))] for k in range(len(board))]
    
    
    
    
    for i in range(0, len(board)):
        for k in range(0 , len(board[i])):
            if(board[i][k] == 1):
                vis[i][k] = 1
                for dir in range(8):
                    nx = dx[dir] + i
                    ny = dy[dir] + k
                    if(nx < 0 or nx >= len(board) or ny < 0 or ny >= len(board)):
                        continue
                    vis[nx][ny] = 1
    
    print(vis)
    
    for i in range(0, len(board)):
        for k in range(0 , len(board[i])):
            if(vis[i][k] == 0):
                answer += 1
    
    return answer