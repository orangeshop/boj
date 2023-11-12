def solution(genres, plays):
    answer = []
    
    
    temp_genres = list(set(genres))
    dictinct_genres = []
    list_genres = []
    # print(temp_genres)

    for i in range(len(temp_genres)):
        dictinct_genres.append([0 , temp_genres[i]])
        
    # print(dictinct_genres) # [sum, genres]
    for i in range(len(genres)):
        for k in range(len(dictinct_genres)):
            if(dictinct_genres[k][1] == genres[i]):
                dictinct_genres[k][0] += plays[i]
    
    dictinct_genres = sorted(dictinct_genres, key = lambda x: x[0], reverse = True)
    
    # print(dictinct_genres)
    genres_plays_arr = [[] for _ in range(len(dictinct_genres))]
    
    
    for i in range(len(dictinct_genres)):
        for k in range(len(genres)):
            if(dictinct_genres[i][1] == genres[k]):
                genres_plays_arr[i].append([plays[k], k])
    
    
    for i in range(len(genres_plays_arr)):
        genres_plays_arr[i] = sorted(genres_plays_arr[i], key = lambda x : x[0], reverse = True)
    
    
    # print(genres_plays_arr)
    
    # for i in range(len(genres_plays_arr)):
    #     print(genres_plays_arr[i])
    
    for i in range(len(genres_plays_arr)):
        for k in range(len(genres_plays_arr[i])):
            if(k == 2):
                break
            else:
                answer.append(genres_plays_arr[i][k][1])
    
    return answer