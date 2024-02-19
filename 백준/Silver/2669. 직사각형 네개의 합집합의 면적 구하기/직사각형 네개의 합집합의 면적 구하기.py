
board = [[0 for _ in range(100)]for _ in range(100)]

for i in range(4):
    a = list(map(int, input().split()))

    for k in range(a[0], a[2]):
        for j in range(a[1], a[3]):
            board[k][j] = 1

answer = 0
for i in range(100):
    for k in range(100):
        if board[i][k] == 1:
            answer += 1

print(answer)