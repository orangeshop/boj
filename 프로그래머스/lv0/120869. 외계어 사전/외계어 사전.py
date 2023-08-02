def solution(spell, dic):
    answer = 2
    total_ch = []
    for i in range(len(dic)):
        spell_ch = []
        for j in range(len(spell)):
            spell_ch.append(0)
        for k in range(len(dic[i])):
            for j in range(len(spell)):
                if(dic[i][k] == spell[j]):
                    spell_ch[j] = 1
        
        total_ch.append(spell_ch)
    
    print(total_ch)
    
    for i in range(len(total_ch)):
        total_bool = False
        for k in range(len(total_ch[i])):
            if(total_ch[i][k] == 1):
                total_bool = True
            elif(total_ch[i][k] == 0):
                total_bool = False
                break
        if(total_bool == True):
            answer = 1
                
    
    return answer