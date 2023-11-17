def solution(arr, k):
    answer = []
    if k % 2 == 0:
        answer = [arr[i] + k for i in range(len(arr))]
    else:
        answer = [arr[i] * k for i in range(len(arr))]
    return answer