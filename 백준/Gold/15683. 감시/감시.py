"""
감시 카메라는 총 5개

각 감시 카메라는 회전이 가능

접근 방식 감시카메라는 일직선 상으로만 가능

완탐을 때려야하는 문제

나는 방향을 기준으로 잡을려고 함

0 1 2 3 순서로 위 오른쪽 아래 왼쪽이라고 가정함
(
    0 : 은 중심에서 위를 보는 것
    1 : 은 중심에서 오른쪽을 바라보는 것
    2 : 은 중심에서 아래를 바라보는 것
    3 : 은 중심에서 왼쪽을 바라 보는 것
)


N * M 가로 세로 방향을 유의



2번은 항상 감시하는 방향이 반대여야함

3번은 항식 직각이여야함




감시 카메라는 벽 통과가 불가

회전은 항상 90도로 해야함

사각 지대의 최소 크기를 구해야함

0의 개수가 가장 적어야함

"""
import sys
from collections import deque

def permu(depth, n,vis, result, totalResult, board, camerals):
    """
    :param depth: 깊이
    :param vis: 방문
    :param result:
    :param totalResult: 최종 결과
    :return: 없음

    1번 4방향 다 봐야함
    2번 0,2 1,3 중복이기에 0, 1만 봐도 동일
    3번 4방향 다 봐야함
    4번 4방향 다 봐야함
    """

    if depth == n:
        """
            크기 계산
        """
        # print("toresult ", result)
        # clac(board, result[:], camerals)
        totalResult[0] = min(totalResult[0], clac(board, result[:], camerals))
        return


    for k in range(4):
        result.append(k)
        permu(depth+1, n, vis, result, totalResult, board, camerals)
        result.pop()


def Move(board, vis, x, y, dir):
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]
    QQ = deque()

    QQ.append([x,y])
    vis[x][y] = True

    while(len(QQ) != 0):
        cur = QQ.popleft()
        nx = cur[0] + dx[dir]
        ny = cur[1] + dy[dir]
        if nx < 0 or nx >= N or ny < 0 or ny >= M:
            continue
        if board[nx][ny] == 6:
            continue

        vis[nx][ny] = True
        QQ.append([nx,ny])

    return vis

def clac(board, totalResult ,ls):
    result = 0

    vis = [[False for _ in range(len(board[0]))] for _ in range(len(board))]

    Q = deque(ls)
    idx = 0
    # print("result", totalResult)
    # print('ls', ls)

    """
    카메라 리스트가 카메라 번호, x, y로 들어옴
    카메라의 방향 리스트가 들어옴
    
    """
    # print("-----------------")
    while(len(Q) != 0):

        cur = Q.popleft()

        if cur[0] == 1:
            vis = Move(board, vis, cur[1], cur[2], totalResult[idx])

        elif cur[0] == 2:
            if totalResult[idx] == 0 or totalResult[idx] == 2:
                vis = Move(board, vis, cur[1], cur[2], 0)
                vis = Move(board, vis, cur[1], cur[2], 2)
            elif totalResult[idx] == 1 or totalResult[idx] == 3:
                vis = Move(board, vis, cur[1], cur[2], 1)
                vis = Move(board, vis, cur[1], cur[2], 3)

        elif cur[0] == 3:

            if totalResult[idx] == 0:
                vis = Move(board, vis, cur[1], cur[2], 0)
                vis = Move(board, vis, cur[1], cur[2], 1)
            elif totalResult[idx] == 1:
                vis = Move(board, vis, cur[1], cur[2], 1)
                vis = Move(board, vis, cur[1], cur[2], 2)
            elif totalResult[idx] == 2:
                vis = Move(board, vis, cur[1], cur[2], 2)
                vis = Move(board, vis, cur[1], cur[2], 3)
            elif totalResult[idx] == 3:
                vis = Move(board, vis, cur[1], cur[2], 3)
                vis = Move(board, vis, cur[1], cur[2], 0)
        elif cur[0] == 4:

            if totalResult[idx] == 0:
                vis = Move(board, vis, cur[1], cur[2], 0)
                vis = Move(board, vis, cur[1], cur[2], 1)
                vis = Move(board, vis, cur[1], cur[2], 3)

            elif totalResult[idx] == 1:
                vis = Move(board, vis, cur[1], cur[2], 0)
                vis = Move(board, vis, cur[1], cur[2], 1)
                vis = Move(board, vis, cur[1], cur[2], 2)
            elif totalResult[idx] == 2:
                vis = Move(board, vis, cur[1], cur[2], 3)
                vis = Move(board, vis, cur[1], cur[2], 1)
                vis = Move(board, vis, cur[1], cur[2], 2)
            elif totalResult[idx] == 3:
                vis = Move(board, vis, cur[1], cur[2], 0)
                vis = Move(board, vis, cur[1], cur[2], 2)
                vis = Move(board, vis, cur[1], cur[2], 3)
        elif cur[0] == 5:
            vis = Move(board, vis, cur[1], cur[2], 0)
            vis = Move(board, vis, cur[1], cur[2], 1)
            vis = Move(board, vis, cur[1], cur[2], 2)
            vis = Move(board, vis, cur[1], cur[2], 3)

        idx += 1


    for i in range(len(board)):
        # print(vis[i])
        for k in range(len(board[0])):
            if vis[i][k] == False and board[i][k] == 0:
                result += 1


    # print()

    return result

N, M = map(int, input().split())

board = []

cameraCnt = 0
camerals = []
for k in range(N):
    tmp = list(map(int, input().split()))
    for i in range(len(tmp)):
        if 1 <= tmp[i] and tmp[i] <= 5:
            camerals.append([tmp[i], k, i])
    board.append(tmp)


camerals.sort(key= lambda x : x[0])

# print(cameraCnt)
answer = sys.maxsize
totalResult = [answer]
vis = [False for _ in range(cameraCnt)]
result = []
permu(0,len(camerals),vis, result, totalResult, board, camerals)

print(totalResult[0])
