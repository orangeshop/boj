T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
def check(board, x ,y):

    for i in range(8):
        if(i == y):
            continue
        if(board[x][i] == 'O'):
            return True

    for i in range(8):
        if (x == i):
            continue
        if (board[i][y] == 'O'):
            return True

    return False


for test_case in range(1, T + 1):

    answer = "yes"

    board = []
    for i in range(8):
        temp = list(map(str, input()))
        board.append(temp)


    # print(board)
    cnt = 0
    out_check = False
    for i in range(8):
        for k in range(8):
            if(check(board, i, k) == True and board[i][k] == 'O'):
                answer = "no"
            if(board[i][k] == 'O'):
                cnt += 1
            

    if(cnt != 8):
        answer = "no"
        
    print("#", end= "")
    print(test_case, end= " ")
    print(answer)