import Foundation

func solution(_ s:String) -> Int {
    
    var alpha_bet : [Int] = Array(repeating : 0, count : 30) 
    var result_num : Int = 0
    // print(Int(UnicodeScalar("a").value))
    
    // print(s.count)
    var target_idx : Int = -1
    
    // var target_num : Int = 0
    var other_num : Int = 0
    
    
    for i in 0 ..< s.count{
            
        var ch : Character = s[s.index(s.startIndex, offsetBy : i)]
        
        var num = (ch.unicodeScalars.first?.value)! - 97
        
        if(target_idx == -1){
            target_idx = Int(num)
        }
        
        if(target_idx != Int(num)){
            other_num += 1
        }
        else{
            alpha_bet[target_idx] += 1
        }
        
        if(alpha_bet[target_idx] == other_num){
            for k in 0 ..< 30{
                alpha_bet[k] = 0
            }
            other_num = 0
            result_num += 1
            target_idx = -1
        }
        
        // print(alpha_bet)
        // print(other_num)
    }
    
    for i in 0 ..< 30{
        if(alpha_bet[i] > 0){
            result_num += 1
            break
        }
    }
    
    print(alpha_bet)
    
    return result_num
}
