import Foundation

var zero_count = 0
var one_count = 0

var board : [[Int]] = [[]]
func solution(_ arr:[[Int]]) -> [Int] {
    board = arr
    clac(x: 0, y: 0, n : board.count)
    
    return [zero_count, one_count]
}

func clac(x : Int, y : Int , n : Int){
    
    var zero_check = true
    var one_check = true
    
    for i in x ..< x + n{
        for k in y ..< y + n{
            if(board[i][k] == 1){
                zero_check = false
            }
            if(board[i][k] == 0){
                one_check = false
            }
        }
    }
    
    if(zero_check == true){
        zero_count += 1
        return
    }
    if(one_check == true){
        one_count += 1
        return
    }
    
    
    // print("\(x) \(y + (n/2))")
    clac(x : x, y : y, n : n/2)
    clac(x : x, y : y + (n/2), n : n/2)
    clac(x : x + (n/2), y : y, n : n/2)
    clac(x : x + (n/2), y : y + (n/2), n : n/2)
        
    
    
    
}