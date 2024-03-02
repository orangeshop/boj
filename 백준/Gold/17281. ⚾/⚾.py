import sys
from itertools import permutations
from collections import deque

input = sys.stdin.readline

def simul(board, memberls):
    result = 0
    hitMember = 0
    Q = deque()

    for i in board:
        outCNT = 0

        b1, b2, b3 = 0,0,0

        while (True):

            if i[memberls[hitMember]] == 0:
                outCNT += 1
            elif i[memberls[hitMember]] == 1:
                # Q.appendleft(1)
                #
                # if len(Q) >= 4:
                #     if Q[len(Q)-1] == 1:
                #         result += 1
                #     Q.pop()
                result += b3

                b1, b2, b3 = 1,b1,b2

            elif i[memberls[hitMember]] == 2:

                result += (b2+ b3)

                b1, b2, b3 = 0, 1,b1


            elif i[memberls[hitMember]] == 3:

                result += (b1 + b2 + b3)

                b1, b2, b3 = 0, 0, 1


            elif i[memberls[hitMember]] == 4:

                result += (1+ b1 + b2 + b3)

                b1, b2, b3 = 0, 0, 0

            hitMember += 1

            if hitMember == 9:
                hitMember = 0

            if outCNT == 3:
                Q.clear()
                break

    return result


def per(depth, vis, result, totalResult, board, answerls):
    # print(result)
    if depth == 8:
        result.insert(3,0)
        answerls[0] = max(answerls[0], simul(board,result))
        del result[3]
        return

    for i in range(1, 9):
        if vis[i] == False:
            vis[i] = True
            result.append(i)
            per(depth + 1, vis, result, totalResult, board, answerls)
            result.pop()
            vis[i] = False


N = int(input())

board = []
for i in range(N):
    tmp = list(map(int, input().split()))
    board.append(tmp)

result = []
totalResult = []
vis = [False for _ in range(10)]
answerls = [-float("INF")]

per(0, vis, result, totalResult, board, answerls)

print(answerls[0])
