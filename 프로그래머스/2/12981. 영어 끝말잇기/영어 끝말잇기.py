def solution(n, words):
    answer = []

    
    temp_words = words
    
    for i in range(1, len(temp_words)):
        for k in range(0, i):
            if(temp_words[i] == temp_words[k]):
                answer.append(int((i%n)+1))
                answer.append(int((i/n)+1))
                return answer
                
    
    for i in range(1, len(temp_words)):
        # print(f'{temp_words[i][0]} {temp_words[i - 1][int(len(temp_words[i - 1])) - 1]}')
        if(temp_words[i][0] != temp_words[i - 1][int(len(temp_words[i - 1])) - 1]):
            answer.append(int((i%n)+1))
            answer.append(int((i/n)+1))
            return answer
                
    if(len(answer) == 0):
        answer.append(0)
        answer.append(0)
        
    return answer