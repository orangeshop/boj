import math
def solution(numer1, denom1, numer2, denom2):
    answer = []
    temp = denom1
    numer1 *= denom2
    denom1 *= denom2
    
    numer2 *= temp
    denom2 *= temp
    
    print(f'{numer1} {denom1} {numer2} {denom2} ')
    
    result_numer = numer1 + numer2
    result_denom = denom1
    
    mod = math.gcd(result_numer, result_denom)
    print(mod)
    print(f'{result_numer} {result_denom}')
    
    answer.append(result_numer/mod)
    answer.append(result_denom/mod)
    
    return answer