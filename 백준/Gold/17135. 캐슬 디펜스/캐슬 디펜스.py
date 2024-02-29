import copy
def enemyfunc(board):
    tmpLS = []
    for i in range(N):
        for k in range(M):
            if board[i][k] == 1:
                tmpLS.append([i, k])

    return tmpLS


def BFS(ls, board, d):


    """
    궁병 리스트를 돌면서 Disclac가 D 이내라면 제거 가능
    for 궁병
        for 몬스터
            Discalc이 바로 나오면 끝
            같이 때려도 가능

    몬스터 삭제 리스트
    몬스터 한칸 밑으로 내리기

    """

    # print(enemyLs)
    deleteenemyLs = []
    tmpResult = 0
    for _ in range(N):
        enemyLs = enemyfunc(board)
        deleteenemyLs.clear()
        for i in range(len(ls)):
            tmpEnemy = []

            for k in range(len(enemyLs)):
                # print(f"Disclac{Discalc(N, ls[i], enemyLs[k][0], enemyLs[k][1])} D {d}")
                if Discalc(N , ls[i], enemyLs[k][0], enemyLs[k][1]) <= d:
                    tmpEnemy.append([Discalc(N, ls[i], enemyLs[k][0], enemyLs[k][1]), enemyLs[k][0], enemyLs[k][1]])

            tmpEnemy.sort(key=lambda x:(x[0], x[2]))
            # print(f"ls len {ls[i]} sorted e {tmpEnemy}")
            if len(tmpEnemy) > 0:
                deleteenemyLs.append(tmpEnemy[0])

        # print(deleteenemyLs)
        for i in range(len(deleteenemyLs)):
            if board[deleteenemyLs[i][1]][deleteenemyLs[i][2]] != 0:
                # print("hohihi")
                tmpResult += 1
                board[deleteenemyLs[i][1]][deleteenemyLs[i][2]] = 0



        for i in range(N-1, -1, -1):
            for k in range(M):
                if board[i][k] == 1:
                    board[i + 1][k] = 1
                    board[i][k] = 0

        # for i in range(N):
        #     print(board[i])

    return tmpResult

def Discalc(x1, y1, x2, y2):
    return abs(x1 - x2) + abs(y1 - y2)


def makels(depth, M, vis, result, totalResult):
    if len(result) == 3:
        totalResult.append(result[:])
        return

    for i in range(depth, M):
        if vis[i] == False:
            result.append(i)
            vis[i] = True
            makels(i, M, vis, result, totalResult)
            vis[i] = False
            result.pop()

    return

from collections import deque
N, M, D = map(int, input().split())

board = []

for _ in range(N):
    tmp = list(map(int, input().split()))
    board.append(tmp)

appendBowLine = [0 for _ in range(M)]
board.append(appendBowLine)


answer = 0

result = []
totalResult = []
vis = [False for _ in range(M)]

makels(0, M, vis, result, totalResult)

for i in range(len(totalResult)):
    # print(totalResult[i])
    tmpBoard = copy.deepcopy(board)
    answer = max(BFS(totalResult[i], tmpBoard, D), answer)
    # print()
print(answer)

"""
4 4 2
1 1 1 1
1 1 1 0
1 1 0 1
0 1 0 1

4 4 4
1 1 1 0
1 1 1 1
0 0 1 0
0 0 1 1

5 5 2
1 0 1 1 1
0 1 1 1 1
1 0 1 0 1
1 1 0 1 0
1 0 1 0 1

"""