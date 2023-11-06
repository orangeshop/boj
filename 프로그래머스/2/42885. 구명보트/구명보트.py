from collections import deque

def solution(people, limit):
    answer = 0
    people.sort()
    temp_people = deque(people)
    
    while(len(temp_people) != 0):
        cur_first = temp_people.pop()
        if(len(temp_people) == 0):
            answer += 1
            break
            
        if(cur_first + temp_people[0] <= limit):
            temp_people.popleft()
        
        answer += 1
    
    return answer