N = int(input())

board = []

for _ in range(N):
    tmp = list(map(int, input().split(" ")))
    board.append(tmp + [1])

board.append([1] * (N +1))

cnt = [[ [0] * 4 for _ in range(N+1)] for _ in range(N+1)]



cnt[0][1][1] += 1



for i in range(N):
    for k in range(N):
        if(board[i][k] != 1):

            if cnt[i][k][1] != 0:
                if board[i][k + 1] != 1:
                    cnt[i][k+1][1] += cnt[i][k][1]
                if board[i][k+1] != 1 and board[i+1][k] != 1 and board[i + 1][k+1] != 1:
                    cnt[i+1][k + 1][3] += cnt[i][k][1]


            if cnt[i][k][2] != 0:
                if board[i+1][k] != 1:
                    cnt[i+1][k][2] += cnt[i][k][2]
                if board[i][k + 1] != 1 and board[i + 1][k] != 1 and board[i + 1][k+1] != 1:
                    cnt[i + 1][k + 1][3] += cnt[i][k][2]

            if cnt[i][k][3] != 0:
                if board[i][k + 1] != 1:
                    cnt[i][k + 1][1] += cnt[i][k][3]
                if board[i + 1][k] != 1:
                    cnt[i + 1][k][2] += cnt[i][k][3]
                if board[i][k + 1] != 1 and board[i + 1][k] != 1 and board[i + 1][k+1] != 1:
                    cnt[i + 1][k + 1][3] += cnt[i][k][3]



print(sum(cnt[N-1][N-1]))