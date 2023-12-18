# time 리스트 -> 해당 초에 갈 수 있는 모든 영역을 표현
# 벽 리스트 배열 -> 청 8초 이내에 살아 남으면 1이라는 접근
# 즉 8초를 버티면 1

from queue import Queue

board = []
time_list = []
wall_list = []

# 0,0 0,1 0,2
# 1,0 1,1 1,2
# 2,0 2,1 2,2

dx = [-1,-1,-1, 0, 1, 1, 1, 0 ,0]
dy = [-1, 0, 1, 1, 1, 0,-1, -1, 0]

for i in range(8):
    board.append(list(input()))

# print(board)

for i in range(8):
    for k in range(8):
        if(board[i][k] == '#'):
            wall_list.append([i,k])

# print(wall_list)
Q = Queue()
Q.put([7,0])
# 흐흠 -> 무빙을 하고 -> 벽을 내린다 -> 이때 겹치는 값들은 제거

# print(Q.empty())
for i in range(8):
    time_list.clear()
    while(Q.empty() != True):
        cur = Q.get()
        # print(cur)

        for dir in range(9):
            nx = dx[dir] + cur[0]
            ny = dy[dir] + cur[1]
            if(nx < 0 or nx >= 8 or ny < 0 or ny >= 8):
                continue

            if [nx,ny] in (wall_list):
                continue

            # print(f"{nx} {ny}")
            time_list.append([nx,ny])
            # Q.put([nx,ny])
            #todo - nx ny 값 넣어줄 리스트 생성
    # break
    for k in range(len(wall_list)):
        # print(wall_list[k][0])
        wall_list[k] = [wall_list[k][0] + 1, wall_list[k][1]]

    # print(wall_list)
    # print(time_list)
    if(len(time_list) >= 100000):
        break

    for k in range(len(time_list)):
        if(time_list[k] in (wall_list)):
            continue
        else:
            Q.put(time_list[k])

if(len(time_list) == 0):
    print(0)
else:
    print(1)