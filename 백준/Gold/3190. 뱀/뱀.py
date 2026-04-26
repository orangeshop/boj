"""

N N  보드
처음에는 오른쪽으로 향한다



"""
def check(nx,ny):
    if nx < 0 or nx >= N or ny < 0 or ny >= N:
        return False
    return True


def solve(x,y, dir):
    dx = [0,1,0,-1]
    dy = [1,0,-1,0]

    Snake = [[x,y]]

    tmpx = x
    tmpy = y

    #[1] 뱀은 매 초 마다 이동을 함
    for time in range(10005):
        #[2] 뱀은 몸 길이를 늘려 머리를 다음칸에 위치시킨다
        # dir에 따라 방향을 정해 줘야 할 듯 함

        # print(f"snake body ${Snake}")

        if moveLs[time] != "":
            if moveLs[time] == "L":
                dir = dir - 1
                if dir < 0:
                    dir = 3
            else:
                dir = dir + 1
                if dir > 3:
                    dir = 0


        nx = tmpx + dx[dir]
        ny = tmpy + dy[dir]

        #[3] 만약 벽이나 자기 자신의 몸과 부딪히면 게임이 끝난다
        if check(nx,ny) == False:
            # print(time)
            return time

        if [nx,ny] in Snake:
            # print(time)
            return time
        #[4] 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다

        if board[nx][ny] == 1:
            board[nx][ny] = 0
            Snake.append([nx, ny])

        #[5] 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다.
        #즉 몸 길이는 변하지 않는다
        elif board[nx][ny] == 0:
            del Snake[0]
            Snake.append([nx, ny])

        #[6] 몇 초에 끝나는지 계산

        tmpx = nx
        tmpy = ny


N = int(input())
K = int(input())
board = [[0 for _ in range(N)] for _ in range(N)]

for i in range(K):
    applex, appley = map(int, input().split())
    board[applex-1][appley-1] = 1

moveLs = ["" for _ in range(10005)]

end = 0
L = int(input())
for i in range(L):
    num, dir = input().split()
    moveLs[int(num)] = dir
    end = max(end, int(num))



print(solve(0,0,0)+1)