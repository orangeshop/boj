
def check(lst, v):
    cnt = 1
    for i in range(1, len(lst)):
        if lst[i-1] == lst[i]:
            cnt += 1
        elif lst[i-1]+1 == lst[i] and cnt >= L and v[i-L:i] == [0] * L:
            cnt = 1
            v[i-L:i] = [1]*L
        elif lst[i-1] > lst[i]:
            cnt = 1
        else:
            return False

    return True

N, L = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(N)]

answer = 0

for _ in range(2):
    for lst in board:
        v = [0] * (len(lst))

        if check(lst, v) and check(lst[::-1], v[::-1]):
            answer += 1

    board = list(map(list, zip(*board)))

print(answer)