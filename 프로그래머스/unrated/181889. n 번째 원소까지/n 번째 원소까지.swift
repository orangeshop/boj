import Foundation

func solution(_ num_list:[Int], _ n:Int) -> [Int] {
    var arr: [Int] = []
    
    for i in 0 ..< n{
        arr.append(num_list[i])
    }
    
    return arr
}