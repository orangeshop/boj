def solution(participant, completion):
    answer = ''
    
    temp_participant = participant
    temp_completion = completion
    
    temp_participant.sort()
    temp_completion.sort()
    
    # print(temp_participant)
    # print(temp_completion)
    
    for i in range(len(temp_participant)):
        if(i == len(temp_completion)):
            break
        if(temp_participant[i] != temp_completion[i]):
            answer = temp_participant[i]
            break
    
    
    if(answer == ''):
        answer = temp_participant[len(temp_participant)-1]
    return answer