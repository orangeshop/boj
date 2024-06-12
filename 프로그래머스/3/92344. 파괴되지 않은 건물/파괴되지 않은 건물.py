import copy

def skillUse(use, x1, y1, x2, y2, p):
    global tmp, tmpClear
    
    # print(tmp)
    if use == 2:
        p *= -1
    
    tmpClear[x1][y1] += p
    tmpClear[x1][y2+1] += -p
    tmpClear[x2+1][y1] += -p
    tmpClear[x2+1][y2+1] += p
    
    
                
# 250,000,000,000

def solution(board, skill):
    answer = 0
    global tmp, tmpClear
    tmp = copy.deepcopy(board)
    
    tmpClear = [[0 for _ in range(len(board[0])+1)] for _ in range(len(board)+1)]
    
    for i in range(len(skill)):
        skillUse(skill[i][0], skill[i][1], skill[i][2], skill[i][3], skill[i][4], skill[i][5])
        
    
        
    for i in range(len(tmp)):
        for k in range(1,len(tmp[0])+1):
            tmpClear[i][k] += tmpClear[i][k-1]
    # 00 10     
    for i in range(len(tmp[0])):
        for k in range(1,len(tmp)+1):
            tmpClear[k][i] += tmpClear[k-1][i]
    
    
    # for i in range(len(tmp)+1):
    #     print(tmpClear[i])
    
    for i in range(len(tmp)):
        for k in range(len(tmp[0])):
            if tmp[i][k] - tmpClear[i][k] > 0:
                answer += 1
    
    return answer

"""
00000
00000
00000
00000

40000
00000
2000-2
-20002

40000
-20200
2000-2
-20002

4100-1
-20200
2000-2
-20002

45554
-2-2000
22220
-2-2-2-20

45554
23554
45774
23554


000
000
000

000
040
000

20-2
040
-202

20-2
040
-102 100 2

220
044
-102 2 4

220
264
-100 8 






"""
                
    