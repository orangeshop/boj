def search(cache, target):
    if(len(cache) == 0):
        return -2
    
    
    for i in range(len(cache)):
        if(cache[i].upper() == target.upper()):
            return i
    
    return -1



def solution(cacheSize, cities):
    answer = 0
        
    cache = []
#     print(int(ord('A')))
#     print(int(ord('a')))
    
    for i in range(len(cities)):
        # print(cache)
        if(cacheSize == 0 and len(cache) == 1):
            cache.pop()
        
        if(search(cache, cities[i]) == -2):
            cache.append(cities[i])
            answer += 5
            continue
        
        if(search(cache, cities[i]) == -1 and len(cache) < cacheSize):
            cache.append(cities[i])
            answer += 5
            continue  
        elif(search(cache, cities[i]) == -1 and len(cache) == cacheSize):
            cache.remove(cache[0])
            cache.append(cities[i])
            answer += 5
            continue
            
        if(search(cache, cities[i]) != -1):
            cache.remove(cache[search(cache, cities[i])])
            cache.append(cities[i])
            answer += 1
            
            
    # print(cache)    
    
    return answer


#test 1 LRU
#   1   2       3           4           5           6           7           8           9           10
# jeju Pangyo   Seoul       NewYork     LA          Jeju        Pangyo      Seoul       NewYork     LA
#      jeju     Pangyo      Seoul       NewYork     LA          Jeju        Pangyo      Seoul       NewYork
#               jeju        Pangyo      Seoul       NewYork     LA          Jeju        Pangyo      Seoul


