# def solution(phone_book):
#     answer = False
    
#     ph_d = dict()
    
#     for i in range(len(phone_book)):
#         ph_d[phone_book[i]] = 1
    
#     for i in range(len(phone_book)):
#         if ph_d == phone_book[i]:
#             print("dd")
            
    
#     print(ph_d)
    
#     return answer


# 완탐 불가능 투포인터 불가능
def func(str1, str2):
    
    # print(f"{str1} {str2} {check}")
    if(str1 == str2[:len(str1)]):
        return True
    
    return False

def solution(phone_book):
    answer = True
    phone_book.sort()
    for i in range(len(phone_book) -1):
        # last_idx = len(phone_book) - 1
        
        # print(f"{i} {last_idx}")
        
        for k in range(i + 1, i + 2):
            # print(last_idx)
            # if(k == last_idx):
            #     break
            
            if(True == func(phone_book[i],phone_book[k])):
                return False
               
            # last_idx -= 1
    return answer


# 119 119552~ 가 같으면 