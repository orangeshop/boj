from collections import deque

N, K = map(int, input().split())
ls = deque(list(map(int, input().split())))
robot = deque([False] * (N * 2))
time = 0
while(True):
    time += 1
    ls.rotate(1)
    robot.rotate(1)

    # print(ls)

    robot[N-1] = False
    # check = False
    for i in range(((N*2)-2), -1, -1):
        
        if ls[i+1] > 0 and robot[i+1] == False and robot[i] == True:
            robot[i], robot[i+1] = robot[i+1], robot[i]
            ls[(i+1)%(N*2)] -= 1

        robot[N-1] = False

    if ls[0] > 0:
        robot[0] = True
        ls[0] -= 1

    robot[N-1] = False

    cnt = 0
    for i in range(N*2):
        if ls[i] == 0:
            cnt += 1
    if cnt >= K:
        break

print(time)