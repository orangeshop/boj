import copy
def solution(want, number, discount):
    answer = 0
    
    dictionary = []
    
    for i in range(len(want)):
        dictionary.append([want[i], number[i]])
    
    # print(dictionary)
    
    
    
    
    for i in range(len(discount) - 9):
        temp_dictionary = copy.deepcopy(dictionary)
        for k in range(i, i + 10):
            
            # print(discount[k])
            for j in range(len(temp_dictionary)):
                if(discount[k] == temp_dictionary[j][0]):
                    temp_dictionary[j][1] -= 1
                    
            
        check = True
        for k in range(len(temp_dictionary)):
            if(temp_dictionary[k][1] != 0):
                check = False
        
        if(check == True):
            answer += 1
            
            
        # print(temp_dictionary)
    
    return answer