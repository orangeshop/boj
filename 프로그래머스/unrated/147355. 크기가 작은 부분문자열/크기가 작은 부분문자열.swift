import Foundation

func solution(_ t:String, _ p:String) -> Int {
    
    let t_count = t.count
    let p_count = p.count
    
    var arr : [String] = []
    // print("t c : \(t_count), p c : \(p_count)")
    for i in 0 ..< t_count - (p_count - 1){ 
        var str = ""
        print(i)
        for k in i ..< i + p_count {
            // print("k \(k) \(t[t.index(t.startIndex, offsetBy : k)] )")
            str += String(t[t.index(t.startIndex, offsetBy : k)])
        }
        arr.append(str)
    }
    
    var result = 0
    for i in 0 ..< arr.count{
//         print(Int(arr[i]))
//         print(Int(p))
        
        if(Int(arr[i])! <= Int(p)!){
            result += 1
        }
    }
    
    return result
}