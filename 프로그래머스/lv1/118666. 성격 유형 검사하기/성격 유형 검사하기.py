

def calc(num):
    if(num == 1 or num == 7):
        return 3
    elif(num == 2 or num == 6):
        return 2
    elif(num == 3 or num == 5):
        return 1
    else:
        return 0

def solution(survey, choices):
    answer = ''
    
    chart = [[0,0] , [0,0], [0,0], [0,0]]

    resourse_1 = ['R', 'T'] 
    resourse_2 = ['C', 'F'] 
    resourse_3 = ['J', 'M']
    resourse_4 = ['A', 'N']
    
    
    for i in range(0,len(survey)):
        print(survey[i])
        if(survey[i][0] == 'R' or survey[i][1] == 'R'):
            print("RT OR TR")
            if(survey[i][0] == 'R'):
                if(choices[i] > 4):
                    chart[0][1] += calc(choices[i])
                elif(choices[i] < 4):
                    chart[0][0] += calc(choices[i])
            else:
                if(choices[i] > 4):
                    chart[0][0] += calc(choices[i])
                elif(choices[i] < 4):
                    chart[0][1] += calc(choices[i])
                
                
        elif(survey[i][0] == 'C' or survey[i][1] == 'C'):
            print("CF OR FC")
            if(survey[i][0] == 'C'):
                if(choices[i] > 4):
                    chart[1][1] += calc(choices[i])
                elif(choices[i] < 4):
                    chart[1][0] += calc(choices[i])
            else:
                if(choices[i] > 4):
                    chart[1][0] += calc(choices[i])
                elif(choices[i] < 4):
                    chart[1][1] += calc(choices[i])
        elif(survey[i][0] == 'J' or survey[i][1] == 'J'):
            print("JM OR MJ")
            if(survey[i][0] == 'J'):
                if(choices[i] > 4):
                    chart[2][1] += calc(choices[i])
                elif(choices[i] < 4):
                    chart[2][0] += calc(choices[i])
            else:
                if(choices[i] > 4):
                    chart[2][0] += calc(choices[i])
                elif(choices[i] < 4):
                    chart[2][1] += calc(choices[i])
        elif(survey[i][0] == 'A' or survey[i][1] == 'A'):
            print("AN OR AN")
            if(survey[i][0] == 'A'):
                if(choices[i] > 4):
                    chart[3][1] += calc(choices[i])
                elif(choices[i] < 4):
                    chart[3][0] += calc(choices[i])
            else:
                if(choices[i] > 4):
                    chart[3][0] += calc(choices[i])
                elif(choices[i] < 4):
                    chart[3][1] += calc(choices[i])
            
    
    print(chart)
    
    if(chart[0][0] > chart[0][1]):
        answer = 'R'
    elif(chart[0][0] < chart[0][1]):
        answer = 'T'
    elif(chart[0][0] == chart[0][1]):
        answer = 'R'
    
    if(chart[1][0] > chart[1][1]):
        answer += 'C'
    elif(chart[1][0] < chart[1][1]):
        answer += 'F'
    elif(chart[1][0] == chart[1][1]):
        answer += 'C'
    
    if(chart[2][0] > chart[2][1]):
        answer += 'J'
    elif(chart[2][0] < chart[2][1]):
        answer +='M'
    elif(chart[2][0] == chart[2][1]):
        answer +='J'
    
    
    if(chart[3][0] > chart[3][1]):
        answer += 'A'
    elif(chart[3][0] < chart[3][1]):
        answer += 'N'
    elif(chart[3][0] == chart[3][1]):
        answer += 'A'
    
        
    
    return answer