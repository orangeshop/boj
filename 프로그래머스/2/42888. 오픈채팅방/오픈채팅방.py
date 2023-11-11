def enter(str1, answer):
    # print(str1 , end = "")
    # print("님이 들어왔습니다.")
    make_str = str1 + "님이 들어왔습니다."
    answer.append(make_str)
    return

def leave(str1, answer):
    # print(str1 , end = "")
    # print("님이 나갔습니다.")
    make_str = str1 + "님이 나갔습니다."
    answer.append(make_str)
    return


def solution(record):
    answer = []
    action = []
    Uid_list = dict() # [Uid, name]
    for i in range(len(record)):
        if(record[i].split()[0] == "Enter" or record[i].split()[0] == "Change"):
            # print("enter")
            # Uid_list.append([record[i].split()[1], record[i].split()[2]])
            Uid_list[record[i].split()[1]] = record[i].split()[2] 
        if(record[i].split()[0] == "Enter"):
            action.append(["Enter", record[i].split()[1]])
        elif(record[i].split()[0] == "Leave"):
            action.append(["Leave", record[i].split()[1]])
    
    
    # print(Uid_list)
    # print(action)
    
    
    for i in range(len(action)):
        if(action[i][0] == "Enter"):
            enter(Uid_list[action[i][1]], answer)
        elif(action[i][0] == "Leave"):
            leave(Uid_list[action[i][1]], answer)
            
            
    return answer