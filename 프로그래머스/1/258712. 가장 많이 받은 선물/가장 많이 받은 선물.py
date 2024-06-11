def solution(friends, gifts):
    answer = -1e9
    
    dt = dict()
    
    for i in range(len(friends)):
        dt[friends[i]] = i
        
    giftTable = [[0 for _ in range(len(dt))] for _ in range(len(dt))]
    answerTable = [[0 for _ in range(3)] for _ in range(len(dt))]
    
    for i in range(len(gifts)):
        user, auser = gifts[i].split()
        giftTable[dt[user]][dt[auser]] += 1
    
    for i in range(len(giftTable)):
        Sf = 0
        for k in range(len(giftTable)):
            Sf += giftTable[k][i]
        Ss = sum(giftTable[i])
        answerTable[i][0] = Ss
        answerTable[i][1] = Sf
        answerTable[i][2] = Ss - Sf
    
    ls = [0 for _ in range(len(dt))]
    
    for i in range(len(dt)):
        print(answerTable[i])
        
    for i in range(len(dt)):
        for k in range(len(dt)):
            if i == k:
                continue
                
            if giftTable[i][k] > giftTable[k][i]:
                ls[i] += 1
            
            if giftTable[i][k] == giftTable[k][i]:
                if answerTable[i][2] > answerTable[k][2]:
                    ls[i] += 1
            
            
        
        
    print(ls)
    
    
    
    
    return max(ls)