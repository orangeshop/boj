from collections import deque
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

for test_case in range(1, T + 1):
    N = int(input())
    board = []
    dp = [[99999 for _ in range(N)] for _ in range(N + 1)]
    vis = [[False for _ in range(N)] for _ in range(N + 1)]
    for i in range(N):
        board.append(list(input()))

    # print(board)
    Q = deque()
    Q.append([0,0])
    dp[0][0] = 0
    vis[0][0] = True
    result = []
    while(len(Q) != 0):
        cur = Q.popleft()
        # print(cur)

        for i in range(len(dx)):
            nx = cur[0] + dx[i]
            ny = cur[1] + dy[i]
            # print(f"{nx} {ny}")
            if nx < 0 or nx >= N or ny < 0 or ny >= N:
                continue

            # print(f"{int(board[nx][ny])} {dp[cur[0]][cur[1]]} {dp[nx][ny]}")
            if int(board[nx][ny]) + dp[cur[0]][cur[1]] < dp[nx][ny]:
                Q.append([nx, ny])
                vis[nx][ny] = True

            dp[nx][ny] = min(int(board[nx][ny]) + dp[cur[0]][cur[1]], dp[nx][ny])

            if (vis[nx][ny] == True):
                continue

            Q.append([nx,ny])
            vis[nx][ny] = True

    # for i in range(N):
    #     print(dp[i])
    print('#', end= '')
    print(test_case, end = ' ')
    print(dp[N-1][N-1])
    # print(f"{test_case}# {dp[N-1][N-1]}")