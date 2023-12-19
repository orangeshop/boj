from queue import Queue



n, m = map(int, input().split())

# 방향을 알아야함
# m 부분 좌표에서 어디에 철도가 있는지 알아야함
# 그리고 각 철도에 이동 방향 리스트를 작성해야함
board = []
for _ in range(n):
    tmp = list(input())
    board.append(tmp)

# print(board)

start_point = [0, 0]
end_point = [0, 0]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
direction_list = ['up', 'down', 'left', 'right']
now_direction = ''
rail_list = ['|', '-', '+', '1', '2', '3', '4']

# input 기준으로
ver_rail_up = [-1, 0]
ver_rail_down = [1, 0]

hor_rail_left = [0, -1]
hor_rail_right = [0, 1]

cross_rail_up = [-1, 0]
cross_rail_down = [1, 0]
cross_rail_left = [0, -1]
cross_rail_right = [0, 1]

corner_one_rail_up = [0, 1]
corner_one_rail_left = [1, 0]

corner_two_rail_down = [0, 1]
corner_two_rail_left = [-1, 0]

corner_three_rail_right = [-1, 0]
corner_three_rail_down = [0, -1]

corner_four_rail_right = [1, 0]
corner_four_rail_up = [0, -1]

for i in range(n):
    for k in range(m):
        # print(f"{i} {k}")
        if (board[i][k] == 'M'):
            start_point = [i, k]
        if (board[i][k] == 'Z'):
            end_point = [i, k]

Q = Queue()
for dir in range(4):
    nx = start_point[0] + dx[dir]
    ny = start_point[1] + dy[dir]

    if (nx < 0 or nx >= n or ny < 0 or ny >= m):
        continue
    if (board[nx][ny] != '.' and board[nx][ny] != 'Z'):
        now_direction = direction_list[dir]
        Q.put([nx, ny])
        break

# print(now_direction)
answer_dot_x = 0
answer_dot_y = 0
answer_rail_cny = 0
save_dir = ''
while (Q.empty() != True):
    cur = Q.get()
    # print(cur)
    if (board[cur[0]][cur[1]] == '.'):
        # print(f"in dot {cur} {now_direction}")
        answer_dot_x = cur[0]
        answer_dot_y = cur[1]



    if (board[cur[0]][cur[1]] == '|'):

        if (now_direction == 'up'):
            nx = cur[0] + ver_rail_up[0]
            ny = cur[1] + ver_rail_up[1]
            if (nx < 0 or nx >= n or ny < 0 or ny >= m):
                continue
            now_direction = 'up'
            save_dir = now_direction
            Q.put([nx, ny])

        elif (now_direction == 'down'):
            nx = cur[0] + ver_rail_down[0]
            ny = cur[1] + ver_rail_down[1]
            if (nx < 0 or nx >= n or ny < 0 or ny >= m):
                continue
            now_direction = 'down'
            save_dir = now_direction
            Q.put([nx, ny])

    elif (board[cur[0]][cur[1]] == '-'):
        if (now_direction == 'left'):
            nx = cur[0] + hor_rail_left[0]
            ny = cur[1] + hor_rail_left[1]
            if (nx < 0 or nx >= n or ny < 0 or ny >= m):
                continue
            now_direction = 'left'
            save_dir = now_direction
            Q.put([nx, ny])

        elif (now_direction == 'right'):
            nx = cur[0] + hor_rail_right[0]
            ny = cur[1] + hor_rail_right[1]
            if (nx < 0 or nx >= n or ny < 0 or ny >= m):
                continue
            now_direction = 'right'
            save_dir = now_direction
            Q.put([nx, ny])


    elif (board[cur[0]][cur[1]] == '+'):
        if (now_direction == 'left'):
            nx = cur[0] + cross_rail_left[0]
            ny = cur[1] + cross_rail_left[1]
            if (nx < 0 or nx >= n or ny < 0 or ny >= m):
                continue
            now_direction = 'left'
            save_dir = now_direction
            Q.put([nx, ny])

        elif (now_direction == 'right'):
            nx = cur[0] + cross_rail_right[0]
            ny = cur[1] + cross_rail_right[1]
            if (nx < 0 or nx >= n or ny < 0 or ny >= m):
                continue
            now_direction = 'right'
            save_dir = now_direction
            Q.put([nx, ny])

        elif (now_direction == 'up'):
            nx = cur[0] + cross_rail_up[0]
            ny = cur[1] + cross_rail_up[1]
            if (nx < 0 or nx >= n or ny < 0 or ny >= m):
                continue
            now_direction = 'up'
            save_dir = now_direction
            Q.put([nx, ny])

        elif (now_direction == 'down'):
            nx = cur[0] + cross_rail_down[0]
            ny = cur[1] + cross_rail_down[1]
            if (nx < 0 or nx >= n or ny < 0 or ny >= m):
                continue
            now_direction = 'down'
            save_dir = now_direction
            Q.put([nx, ny])


    elif (board[cur[0]][cur[1]] == '1'):

        if (now_direction == 'up'):
            nx = cur[0] + corner_one_rail_up[0]
            ny = cur[1] + corner_one_rail_up[1]
            if (nx < 0 or nx >= n or ny < 0 or ny >= m):
                continue
            now_direction = 'right'
            save_dir = now_direction
            Q.put([nx, ny])
        elif (now_direction == 'left'):
            nx = cur[0] + corner_one_rail_left[0]
            ny = cur[1] + corner_one_rail_left[1]
            if (nx < 0 or nx >= n or ny < 0 or ny >= m):
                continue
            now_direction = 'down'
            save_dir = now_direction
            Q.put([nx, ny])

    elif (board[cur[0]][cur[1]] == '2'):
        if (now_direction == 'down'):
            nx = cur[0] + corner_two_rail_down[0]
            ny = cur[1] + corner_two_rail_down[1]
            if (nx < 0 or nx >= n or ny < 0 or ny >= m):
                continue
            now_direction = 'right'
            save_dir = now_direction
            Q.put([nx, ny])
        elif (now_direction == 'left'):
            nx = cur[0] + corner_two_rail_left[0]
            ny = cur[1] + corner_two_rail_left[1]
            if (nx < 0 or nx >= n or ny < 0 or ny >= m):
                continue
            now_direction = 'up'
            save_dir = now_direction
            Q.put([nx, ny])

    elif (board[cur[0]][cur[1]] == '3'):
        if (now_direction == 'right'):
            nx = cur[0] + corner_three_rail_right[0]
            ny = cur[1] + corner_three_rail_right[1]
            if (nx < 0 or nx >= n or ny < 0 or ny >= m):
                continue
            now_direction = 'up'
            save_dir = now_direction
            Q.put([nx, ny])
        elif (now_direction == 'down'):
            nx = cur[0] + corner_three_rail_down[0]
            ny = cur[1] + corner_three_rail_down[1]
            if (nx < 0 or nx >= n or ny < 0 or ny >= m):
                continue
            now_direction = 'left'

            save_dir = now_direction
            Q.put([nx, ny])

    elif (board[cur[0]][cur[1]] == '4'):
        if (now_direction == 'right'):
            nx = cur[0] + corner_four_rail_right[0]
            ny = cur[1] + corner_four_rail_right[1]
            if (nx < 0 or nx >= n or ny < 0 or ny >= m):
                continue
            now_direction = 'down'
            save_dir = now_direction
            Q.put([nx, ny])
        elif (now_direction == 'up'):
            nx = cur[0] + corner_four_rail_up[0]
            ny = cur[1] + corner_four_rail_up[1]
            if (nx < 0 or nx >= n or ny < 0 or ny >= m):
                continue
            now_direction = 'left'
            save_dir = now_direction
            Q.put([nx, ny])

check = False

# print(f"answer {answer_dot_x} {answer_dot_y} {save_dir}")
for i in range(len(rail_list)):
    if(check == True):
        break
    board[answer_dot_x][answer_dot_y] = rail_list[i]
    now_direction = save_dir
    Q.put([answer_dot_x, answer_dot_y])
    while (Q.empty() != True):
        cur = Q.get()
        # print(cur)
        if (board[cur[0]][cur[1]] == 'Z'):
            # print(f"in Z {cur}")

            answer_rail_cny = i
            check = True
            break

        if (board[cur[0]][cur[1]] == '|'):
            if (now_direction == 'up'):
                nx = cur[0] + ver_rail_up[0]
                ny = cur[1] + ver_rail_up[1]
                if(nx < 0 or nx >= n or ny < 0 or ny >= m):
                    continue
                now_direction = 'up'
                Q.put([nx, ny])

            elif (now_direction == 'down'):
                nx = cur[0] + ver_rail_down[0]
                ny = cur[1] + ver_rail_down[1]
                if (nx < 0 or nx >= n or ny < 0 or ny >= m):
                    continue
                now_direction = 'down'
                Q.put([nx, ny])

        elif (board[cur[0]][cur[1]] == '-'):
            if (now_direction == 'left'):
                nx = cur[0] + hor_rail_left[0]
                ny = cur[1] + hor_rail_left[1]
                if (nx < 0 or nx >= n or ny < 0 or ny >= m):
                    continue
                now_direction = 'left'
                Q.put([nx, ny])

            elif (now_direction == 'right'):
                nx = cur[0] + hor_rail_right[0]
                ny = cur[1] + hor_rail_right[1]
                if (nx < 0 or nx >= n or ny < 0 or ny >= m):
                    continue
                now_direction = 'right'
                Q.put([nx, ny])


        elif (board[cur[0]][cur[1]] == '+'):
            if (now_direction == 'left'):
                nx = cur[0] + cross_rail_left[0]
                ny = cur[1] + cross_rail_left[1]
                if (nx < 0 or nx >= n or ny < 0 or ny >= m):
                    continue
                now_direction = 'left'
                Q.put([nx, ny])

            elif (now_direction == 'right'):
                nx = cur[0] + cross_rail_right[0]
                ny = cur[1] + cross_rail_right[1]
                if (nx < 0 or nx >= n or ny < 0 or ny >= m):
                    continue
                now_direction = 'right'
                Q.put([nx, ny])

            elif (now_direction == 'up'):
                nx = cur[0] + cross_rail_up[0]
                ny = cur[1] + cross_rail_up[1]
                if (nx < 0 or nx >= n or ny < 0 or ny >= m):
                    continue
                now_direction = 'up'
                Q.put([nx, ny])

            elif (now_direction == 'down'):
                nx = cur[0] + cross_rail_down[0]
                ny = cur[1] + cross_rail_down[1]
                if (nx < 0 or nx >= n or ny < 0 or ny >= m):
                    continue
                now_direction = 'down'
                Q.put([nx, ny])


        elif (board[cur[0]][cur[1]] == '1'):
            if (now_direction == 'up'):
                nx = cur[0] + corner_one_rail_up[0]
                ny = cur[1] + corner_one_rail_up[1]
                if (nx < 0 or nx >= n or ny < 0 or ny >= m):
                    continue
                now_direction = 'right'
                Q.put([nx, ny])
            elif (now_direction == 'left'):
                nx = cur[0] + corner_one_rail_left[0]
                ny = cur[1] + corner_one_rail_left[1]
                if (nx < 0 or nx >= n or ny < 0 or ny >= m):
                    continue
                now_direction = 'down'
                Q.put([nx, ny])

        elif (board[cur[0]][cur[1]] == '2'):
            if (now_direction == 'down'):
                nx = cur[0] + corner_two_rail_down[0]
                ny = cur[1] + corner_two_rail_down[1]
                if (nx < 0 or nx >= n or ny < 0 or ny >= m):
                    continue
                now_direction = 'right'
                Q.put([nx, ny])
            elif (now_direction == 'left'):
                nx = cur[0] + corner_two_rail_left[0]
                ny = cur[1] + corner_two_rail_left[1]
                if (nx < 0 or nx >= n or ny < 0 or ny >= m):
                    continue
                now_direction = 'up'
                Q.put([nx, ny])

        elif (board[cur[0]][cur[1]] == '3'):
            if (now_direction == 'right'):
                nx = cur[0] + corner_three_rail_right[0]
                ny = cur[1] + corner_three_rail_right[1]
                if (nx < 0 or nx >= n or ny < 0 or ny >= m):
                    continue
                now_direction = 'up'
                Q.put([nx, ny])
            elif (now_direction == 'down'):
                nx = cur[0] + corner_three_rail_down[0]
                ny = cur[1] + corner_three_rail_down[1]
                if (nx < 0 or nx >= n or ny < 0 or ny >= m):
                    continue
                now_direction = 'left'
                Q.put([nx, ny])

        elif (board[cur[0]][cur[1]] == '4'):
            if (now_direction == 'right'):
                nx = cur[0] + corner_four_rail_right[0]
                ny = cur[1] + corner_four_rail_right[1]
                if (nx < 0 or nx >= n or ny < 0 or ny >= m):
                    continue
                now_direction = 'down'
                Q.put([nx, ny])
            elif (now_direction == 'up'):
                nx = cur[0] + corner_four_rail_up[0]
                ny = cur[1] + corner_four_rail_up[1]
                if (nx < 0 or nx >= n or ny < 0 or ny >= m):
                    continue
                now_direction = 'left'
                Q.put([nx, ny])

print(f"{answer_dot_x + 1} {answer_dot_y + 1} {rail_list[answer_rail_cny]}", end= '')