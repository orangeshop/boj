import Foundation

var result : Set<Int> = []

var current_plus_num = 0
var dp : [(Int, Int)] = []
func solution(_ elements:[Int]) -> Int {
    
    var result_num = 0
    
    
    for i in 0 ..< elements.count{
        var current = i + 1
        if(current >= elements.count){
            current = 0 
        }
        dp.append((elements[i], current))
        // result[dp[i].0] = true
        result.insert(dp[i].0)
    }
    
    // for i in 0 ..< dp.count{
    //     if(result[i] == true){
    //         result_num += 1
    //     }
    // }
    
    for i in 1 ..< elements.count{
        for k in 0 ..< elements.count{
            
            var current = dp[k].1 + 1
            if(current >= elements.count){
                current = 0 
            }
            dp[k].0 = dp[k].0 + elements[dp[k].1]
            dp[k].1 = current
            // print("\(dp[k].0)")
            // result[dp[k].0] = true
            result.insert(dp[k].0)
        }
        
        // print(dp)
    }
    
    
    
    // print(result)
    
    return result.count
}