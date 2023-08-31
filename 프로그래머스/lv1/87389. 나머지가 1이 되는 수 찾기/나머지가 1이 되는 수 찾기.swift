import Foundation

func solution(_ n:Int) -> Int {
    var min_num = 999999999
    for i in 1..<n+1{
        if(n % i == 1){
            min_num = min(min_num, i)
        }
    }
    
    
    return min_num
}