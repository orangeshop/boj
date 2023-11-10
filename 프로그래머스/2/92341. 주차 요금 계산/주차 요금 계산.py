import math
def time_func(str1):
    total_time = 0
    
    total_time = int(str1.split(':')[0]) * 60 + int(str1.split(':')[1])
    
    return total_time

def solution(fees, records):
    answer = []
    
    IN_car = []
    Result_Car = []
    
    for i in range(len(records)):
        # print(records[i].split())
        if(records[i].split()[2] == "IN"):
            IN_car.append([time_func(records[i].split()[0]) , records[i].split()[1]])
            check = False
            for k in range(len(Result_Car)):
                if(Result_Car[k][0] == records[i].split()[1]):
                    check = True

            if(check == False):
                Result_Car.append([str(records[i].split()[1]), 0])
            
        elif(records[i].split()[2] == "OUT"):
            for k in range(len(IN_car)):
                # IN car 배열에서 이미 들어온 차를 찾아야함
                if(IN_car[k][1] == records[i].split()[1]):
#                     In car 배열에서 out과 같은 차 번호를 찾아야함
                    # print(f'in car == records {records[i].split()[1]}')
                    # print(k)
                  
                    
                    for j in range(len(Result_Car)):
                
                        if(Result_Car[j][0] == records[i].split()[1]):
                            Result_Car[j][1] +=  time_func(records[i].split()[0]) - IN_car[k][0]
            
                            break
                    
                    
                    del IN_car[k]
                    break
    
    
    print(Result_Car)
    print(IN_car)
    for i in range(len(IN_car)):
        for k in range(len(Result_Car)):
            if(Result_Car[k][0] == IN_car[i][1]):
                Result_Car[k][1] += time_func("23:59") - IN_car[i][0]
                break
        
    
    Result_Car.sort()
    print(Result_Car)
    
    print(fees)
    
    for i in range(len(Result_Car)):
        if(int(Result_Car[i][1]) < fees[0]):
            answer.append(fees[1])
        else:
            answer.append(fees[1] + math.ceil(int(Result_Car[i][1] - fees[0])/fees[2]) * fees[3])
    
    
    
    return answer