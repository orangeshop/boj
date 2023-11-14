from collections import deque
import heapq
import math
def solution(n, works):
    answer = 99999999
    
    heap = []
    
    for i in range(len(works)):
        heapq.heappush(heap, -works[i])
    
    for i in range(n):
        if heap[0] != 0:
            heapq.heappush(heap, (heapq.heappop(heap) + 1))
    
    
    # print(heap)
    
    arr = [i ** 2 for i in heap]
    
    return sum(arr)