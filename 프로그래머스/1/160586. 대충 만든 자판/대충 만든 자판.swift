import Foundation

func solution(_ keymap:[String], _ targets:[String]) -> [Int] {
    var answer : [Int] = []
    
    var key_array : [(String, Int)] = []
    
    for i in 0 ..< keymap.count{
        
        var str : [String] = []
        for k in 0 ..< keymap[i].count{
            str.append(String(keymap[i][keymap[i].index(keymap[i].startIndex, offsetBy : k)]))
        }
        // print(str)
        for k in 0 ..< str.count{
            var check : Bool = false
            for j in 0 ..< key_array.count{
                if(str[k] == key_array[j].0){
                    key_array[j].1 = min(key_array[j].1, k+1)
                    check = true
                    break
                }
            }
            
            if(check == false){
                key_array.append((str[k],k+1))
            }
        }
        // print(key_array)
    }
    
    for i in 0 ..< targets.count{
        var num = 0
        var str : [String] = []
        
        for k in 0 ..< targets[i].count{
            str.append(String(targets[i][targets[i].index(targets[i].startIndex, offsetBy : k)]))
        }
        print(str)
        var result_check = false
        for k in 0 ..< targets[i].count{
            var check = false
            for j in 0 ..< key_array.count{
                if(str[k] == key_array[j].0){
                    num += key_array[j].1
                    check = true
                }
            }
            if(check == false){
                result_check = true
                break
            }
        }
        
        if(result_check == true){
            answer.append(-1)
        }else{
            answer.append(num)
        }
    }
    
    return answer
}