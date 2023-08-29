import Foundation

func solution(_ s:String) -> [Int] {
    
    var temp = s.split(separator : "{")
    var temp_2 : [String] = []
    var result : [String] = []
    var total_result : [Int] = []
    // temp_2.append("123")
    for i in 0 ..< temp.count{
        temp[i].popLast()
        temp[i].popLast()
        
        temp_2.append("\(temp[i])")
    }
    
    temp_2.sort{$0.count < $1.count}
    
    for i in 0 ..< temp_2.count{
        var temp_str = temp_2[i].split(separator : ",")
        
      
        if(result.count == 0){
            // print(temp_str)
            result.append(String(temp_str[0]))   
        }
        else{
            // print("else  \(temp_str)")
            for k in 0 ..< temp_str.count{
                for j in 0 ..< result.count{
                    // print("clac : \(temp_str[k]) \(result[j])")
                    if(temp_str[k] == result[j]){
                        break
                    }
                    
                    if(j == result.count - 1){
                        result.append(String(temp_str[k]))
                    }
                }
            }
        }
        
        
    }
    // print(temp_2)
    
    print(result)
    for i in 0 ..< result.count{
        total_result.append(Int(result[i])!)
    }
    return total_result
}

