def solution(before, after):
    answer = 1
    
    be_list = []
    af_list = []
    
    print(ord('a'))
    
    for i in range(30):
        be_list.append(0)
        af_list.append(0)
        
    for i in range(len(before)):
        be_list[ord(before[i])-97] += 1
        af_list[ord(after[i])-97] += 1
    
    print(be_list)
    print(af_list)
    
    for i in range(30):
        if(af_list[i] != be_list[i]):
            answer = 0
            break
    
    return answer