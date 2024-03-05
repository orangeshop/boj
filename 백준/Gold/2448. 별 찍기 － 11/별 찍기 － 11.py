N = int(input())

board = [[" " for _ in range((N*2) + 1)] for _ in range(N+1)]

def solution(x,y, num):
    # print(x,y,num)

    if num == 3:
        for i in range(3):
            for k in range(i,5-i):
                if i == 1 and k == 2:
                    continue

                board[x-i][y+k] = "*"

        return

    solution(x, y, num //2)
    solution(x - num//2, y + (num//2), num // 2)
    solution(x, y + (num//2) * 2, num // 2)


solution(N, 0 ,N)

for i in range(1,N+1):
    for k in range(N*2):
        print(board[i][k], end = "")

    print()
