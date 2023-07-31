def solution(my_string):
    answer = []
    
    for i in range(len(my_string)):
        if(my_string[i] == "1"):
            answer.append(1)
        elif(my_string[i] == "2"):
            answer.append(2)
        elif(my_string[i] == "3"):
            answer.append(3)
        elif(my_string[i] == "4"):
            answer.append(4)
        elif(my_string[i] == "5"):
            answer.append(5)
        elif(my_string[i] == "6"):
            answer.append(6)
        elif(my_string[i] == "7"):
            answer.append(7)
        elif(my_string[i] == "8"):
            answer.append(8)
        elif(my_string[i] == "9"):
            answer.append(9)
        elif(my_string[i] == "0"):
            answer.append(0)
            
    answer.sort()
    return answer