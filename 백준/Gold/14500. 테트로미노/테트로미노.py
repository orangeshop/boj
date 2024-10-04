def check(nx,ny):
    if nx < 0 or nx >= N or ny < 0 or ny >= M:
        return False
    return True

def solve(x,y):

    ls = [
        [[x,y], [x,y+1], [x, y+2], [x, y+3]]
        ,[[x,y], [x+1,y], [x+2,y], [x+3,y]]
        ,[[x,y],[x+1,y],[x,y+1],[x+1,y+1]]
        ,[[x,y],[x+1,y],[x+2,y],[x+2,y+1]]
        ,[[x,y],[x,y+1],[x, y+2],[x+1,y]]
        ,[[x,y],[x,y+1],[x+1,y+1], [x+2, y+1]]
        ,[[x,y],[x,y+1],[x,y+2], [x-1, y+2]]
        ,[[x,y],[x+1,y],[x+2,y],[x+2,y-1]]
        ,[[x,y],[x+1,y],[x+1,y+1],[x+1,y+2]]
        ,[[x,y],[x,y+1],[x+1,y],[x+2,y]]
        ,[[x,y],[x,y+1],[x,y+2],[x+1,y+2]]
        ,[[x,y],[x+1,y],[x+1,y+1],[x+2,y+1]]
        ,[[x,y],[x,y+1],[x-1,y+1],[x-1,y+2]]
        ,[[x,y],[x+1,y],[x+1,y-1], [x+2,y-1]]
        ,[[x,y],[x,y+1],[x+1,y+1], [x+1, y+2]]
        ,[[x,y],[x+1,y],[x+2,y],[x+1,y-1]]
        ,[[x,y],[x+1,y-1],[x+1,y],[x+1,y+1]]
        ,[[x,y],[x,y+1],[x,y+2],[x+1,y+1]]
        ,[[x,y],[x+1,y],[x+1,y+1],[x+2,y]]
    ]
    ans = 0
    for i in range(len(ls)):
        cnt = 0
        for k in range(4):
            if check(ls[i][k][0],ls[i][k][1]) == False:
                break
            else:
                cnt+=1

        if(cnt == 4):
            tmp = 0

            for k in range(4):

                tmp += board[ls[i][k][0]][ls[i][k][1]]
            ans = max(ans, tmp)



    return ans

N, M = map(int, input().split())

board = []
for _ in range(N):
    board.append(list(map(int, input().split())))

answer = 0
for i in range(N):
    for k in range(M):
        answer = max(answer, solve(i,k))

print(answer)