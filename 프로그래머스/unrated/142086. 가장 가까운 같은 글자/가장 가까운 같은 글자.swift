import Foundation

func solution(_ s:String) -> [Int] {
    var arr : [(Int,Int)] = Array(repeating : (0,0), count : 30)
    var string_arr : [String] = []
    var answer : [Int] = []
    for i in 0 ..< s.count{
        // print(s[s.index(s.startIndex, offsetBy : i)])
        string_arr.append(String(s[s.index(s.startIndex, offsetBy : i)]))
    }
    
    print(string_arr)
    
    for i in 0 ..< string_arr.count{
        var arr_index = Int(UnicodeScalar(string_arr[i])!.value) - 97
        // print(Int(UnicodeScalar(string_arr[i])!.value) - 97)
        if(arr[arr_index].0 == 0){
            arr[arr_index].0 = -1
            arr[arr_index].1 = i
            
            answer.append(arr[arr_index].0)
            continue
        }
        
        if(arr[arr_index].0 != 0){
            arr[arr_index].0 = i - arr[arr_index].1
            arr[arr_index].1 = i
            
             answer.append(arr[arr_index].0)
        }
        
        
    }
    
    print(arr)
    
    return answer
}