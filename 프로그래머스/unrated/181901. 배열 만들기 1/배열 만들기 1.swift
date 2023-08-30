import Foundation

func solution(_ n:Int, _ k:Int) -> [Int] {
    
    var arr : [Int] = []
    for i in 1 ..< n+1{
        if(i % k == 0){
            arr.append(i)
        }
    }
    
    return arr
}