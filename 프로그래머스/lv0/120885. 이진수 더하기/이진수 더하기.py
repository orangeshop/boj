def solution(bin1, bin2):
    answer = ''
    
    num1 = 0
    num2 = 0
    for i in range(len(bin1)):
        # print(bin1[i])
        
        if(bin1[i] == "1"):
            # print(i)
            num1 += 2 ** ((len(bin1)-1) - i)
        
    for i in range(len(bin2)):
        
        if(bin2[i] == "1"):
            # print(i)
            num2 += 2 ** ((len(bin2)-1) - i)   
            
    print(num1)
    print(num2)
    
    num3 = num1 + num2
    
    print(bin(num3))
    
    answer = str(bin(num3))
    
    return answer[2:(len(answer))]