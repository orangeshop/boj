import Foundation

func solution(_ num_list:[Int]) -> Int64{
    
    if(num_list.count >= 11){
        var num = 0
        for i in 0 ..< num_list.count{
            num += num_list[i]
        } 
        return Int64(num)
    }
    else{
        var num = 1
        for i in 0 ..< num_list.count{
            num *= num_list[i]
        } 
        return Int64(num)
    }
    
    
}