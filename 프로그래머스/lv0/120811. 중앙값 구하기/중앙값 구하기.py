def solution(array):
    answer = 0
    array.sort()
    print(int(len(array)/2))
    answer = array[int(len(array)/2)]
    
    return answer