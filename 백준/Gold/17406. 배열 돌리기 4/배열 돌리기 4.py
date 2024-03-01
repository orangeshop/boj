from collections import deque

def per(depth,n, vis, result, totalResult):

    if n == len(result):
        totalResult.append(result[:])
        return

    for i in range(n):
        if vis[i] == False:
            vis[i] = True
            result.append(i)
            per(depth+1, n, vis, result, totalResult)
            vis[i] = False
            result.pop()


def clac(ls, totalResult, board, N, M):
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    # print(ls, totalResult)
    """
    total list의 크기 만큼 돌아야함
    
    탑 좌표와 아래 좌표를 구한 후 
    크기에 대한 2차원 배열을 만듬
    원래 배열을 돌면서 시계 방향으로 돌림
    만들어 지면 해당 배열을 원래 배열에 집어 넣음
    다 돌았다면 행 들의 최솟값을 구함
    
    """



    for i in range(len(totalResult)):
        r = ls[totalResult[i]][0]
        c = ls[totalResult[i]][1]
        s = ls[totalResult[i]][2]


        while(True):
            if s == 0:

                break

            topx = r - s
            topy = c - s
            downx = r + s
            downy = c + s
            Q = deque()
            Q.append([topx, topy])
            now_dir = 0
            tmpBoard = [[-1 for _ in range(M+1)] for _ in range(N+1)]
            while(len(Q) != 0):
                cur = Q.pop()
                nx = cur[0] + dx[now_dir]
                ny = cur[1] + dy[now_dir]

                # print(nx, ny)

                if now_dir == 0 and ny == downy:
                    now_dir = 1
                elif now_dir == 1 and nx == downx:
                    now_dir = 2
                elif now_dir == 2 and ny == topy:
                    now_dir = 3
                elif now_dir == 3 and nx == topx:
                    tmpBoard[nx][ny] = board[cur[0]][cur[1]]
                    break

                # 회전까지 완료
                # 값을 집어 넣어야함
                # print(cur, nx, ny)
                tmpBoard[nx][ny] = board[cur[0]][cur[1]]
                # print(tmpBoard[nx][ny], board[cur[0]][cur[1]])
                Q.append([nx,ny])

            for i in range(N + 1):
                for k in range(M + 1):
                    if tmpBoard[i][k] != -1:
                        board[i][k] = tmpBoard[i][k]

            # for i in range(N + 1):
            #     print(tmpBoard[i])
            #
            # print("-----------")


            s -= 1
    answer = sys.maxsize
    for i in range(1,N+1):
        # print(board[i])
        # print(sum(board[i]))
        answer = min(sum(board[i]), answer)
    # print(answer)
    return answer


import sys
import copy
N, M, K = map(int, input().split())

board = [[0 for i in range(M+1)]]

for i in range(N):
    tmp = list(map(int, input().split()))
    tmp.insert(0,0)
    board.append(tmp)

ls = []

for i in range(K):
    rcs = list(map(int, input().split()))
    ls.append(rcs)

answer = sys.maxsize
result = []
vis = [False for _ in range(K)]
totalResult = []

per(0, K, vis, result, totalResult)



for i in range(len(totalResult)):
    copyboard = copy.deepcopy(board)
    answer = min( clac(ls, totalResult[i], copyboard, N, M), answer)


print(answer)