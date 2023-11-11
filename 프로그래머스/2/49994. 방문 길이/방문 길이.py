from queue import Queue

def go_to_x_y(str1):
    if(str1 == "U"):
        return [-1, 0]
    elif(str1 == "D"):
        return [1, 0]
    elif(str1 == "L"):
        return [0, -1]
    elif(str1 == "R"):
        return [0, 1]
    

def solution(dirs):
    answer = 1

    Q = Queue()
    Q.put([5,5, 5 + go_to_x_y(dirs[0])[0], 5 + go_to_x_y(dirs[0])[1]])
    vis = []
    vis.append([5,5, 5 + go_to_x_y(dirs[0])[0], 5 + go_to_x_y(dirs[0])[1]])
    vis.append([5 + go_to_x_y(dirs[0])[0], 5 + go_to_x_y(dirs[0])[1], 5, 5])
    
    # print(vis)
    
    
    for i in range(1, len(dirs)):
        # if(Q.empty()):
        #     break
        cur = Q.get()
        
        nx = cur[2] + go_to_x_y(dirs[i])[0]
        ny = cur[3] + go_to_x_y(dirs[i])[1]
        # print(f'{nx} {ny}')
        # print("------------------")
        if(nx < 0 or nx >= 11 or ny < 0 or ny >= 11):
            Q.put(cur)
            continue
        check = True
        for k in range(len(vis)):
            # print(f"cur {[cur[2],cur[3], nx, ny]} {vis[k]}")
            if([cur[2],cur[3], nx, ny] == vis[k]):
                # print("hi")
                # print(cur)
                Q.put([cur[2],cur[3], nx, ny])
                check = False
                break
        if(check == False):
            # print("con")
            continue
                
        
        answer += 1
        # print(answer)
        vis.append([cur[2], cur[3], nx,ny])
        vis.append([nx,ny, cur[2], cur[3]])
        Q.put([cur[2], cur[3], nx,ny])
    
    
    # for i in range(len(vis)):
    #     print(vis[i])
    return answer


