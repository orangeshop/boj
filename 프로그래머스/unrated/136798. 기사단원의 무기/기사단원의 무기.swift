import Foundation

func solution(_ number:Int, _ limit:Int, _ power:Int) -> Int {
    
    var arr : [Int] = Array(repeating : 0, count : number + 1)
    var anwser = 0
    
   
    
    for i in 1 ..< number + 1{
        var cnt_num = 0
        for k in 1 ..< Int(sqrt(Double(i)))+1{
            if(i % k == 0){
                // print(k)
                cnt_num += 2
                if(i / k == k){
                    // print("minu \(k)")
                    cnt_num -= 1
                }
            }
            
            
        }
        // print("\(i) \(cnt_num)")
        arr[i] = cnt_num
    }
    
    // print(arr)
    
    for i in 1 ..< number + 1{
        if(arr[i] > limit){
            anwser += power
        }
        else{
            anwser += arr[i]
        }
    }
    
    return anwser
}