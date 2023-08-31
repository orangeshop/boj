import Foundation

var board : [[Int]] = Array(repeating : Array(repeating : 0, count : 1005), count : 1005)
var vis : [[Bool]] = Array(repeating : Array(repeating : false, count : 1005), count : 1005)
var result : [Int] = []

var Three_point : [Bool] = [true, false, false]
let down_move_x : Int = 1
let down_move_y : Int = 0

let right_move_x : Int = 0
let right_move_y : Int = 1

let up_move_x : Int = -1
let up_move_y : Int = -1

var Q : [(Int,Int)] = []
var start_num : Int = 1
var check_num : Int = 0
func solution(_ n:Int) -> [Int] {
    
    board[0][0] = 1
    vis[0][0] = true
    Q.append((0,0))
    
    while(!Q.isEmpty){
        if(n == 1 && start_num == 1){
            break
        }
        if(n == 2 && start_num == 3){
            break
        }
        if(n == 3 && start_num == 6){
            break
        }
        
        if(start_num == 1000000){
            break
        }
        var cur = Q.first
        // print("cur x : \(cur!.0), cur y :\(cur!.1)")
        Q.remove(at : 0)
        start_num += 1
        
        if(Three_point[0] == true){
            
            var nx = cur!.0 + down_move_x
            var ny = cur!.1 + down_move_y
            // print("nx : \(nx), yy :\(ny)")
            if(vis[nx][ny] == true) {
                Q.append((cur!.0,cur!.1))
                Three_point[0] = false
                Three_point[1] = true
                check_num = 0
                continue
            }
            board[nx][ny] = board[cur!.0][cur!.1] + 1
            vis[nx][ny] = true
            check_num += 1
            Q.append((nx,ny))
            
            if(check_num == n-1){
                
                Three_point[0] = false
                Three_point[1] = true
                check_num = 0
                continue
            }
        }
        
        if(Three_point[1] == true){
            
            var nx = cur!.0 + right_move_x
            var ny = cur!.1 + right_move_y
            
            if(vis[nx][ny] == true) {
                Q.append((cur!.0,cur!.1))
                Three_point[1] = false
                Three_point[2] = true
                check_num = 0
                continue
            }
            board[nx][ny] = board[cur!.0][cur!.1] + 1
            vis[nx][ny] = true
            check_num += 1
            Q.append((nx,ny))
            
            if(check_num == n-1){
                Three_point[1] = false
                Three_point[2] = true
                check_num = 0
                continue
            }
        }
        
        if(Three_point[2] == true){
            
            var nx = cur!.0 + up_move_x
            var ny = cur!.1 + up_move_y
            
            if(vis[nx][ny] == true) {
                Q.append((cur!.0,cur!.1))
                Three_point[2] = false
                Three_point[0] = true
                check_num = 0
                continue
            }
            
            board[nx][ny] = board[cur!.0][cur!.1] + 1
            vis[nx][ny] = true
            check_num += 1
            Q.append((nx,ny))
            
            if(check_num == n-1){
                Three_point[2] = false
                Three_point[0] = true
                check_num = 0
                continue
            }
        }
    }
    
    for i in 0 ..< 1000{
        for k in 0 ..< 1000{
            // print("\(board[i][k]) ", terminator : "")
            if(board[i][k] != 0){
                result.append(board[i][k])
            }
        }
        // print("\n")
        
    }
    
    return result
}