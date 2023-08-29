import Foundation

func solution(_ brown:Int, _ yellow:Int) -> [Int] {
    
    let total_carpet : Int = brown + yellow
    var x : Int = 0
    var y : Int = 0
    
    
    
    for i in 3 ..< brown{
        
        for k in i ..< brown{
            if(i * k == total_carpet){
                // print("\(k) \(i)")
                var num : Int = (i - 2) * (k - 2)
                // print("num : \(num)")
                if(yellow >= num){
                    x = k
                    y = i
                }
                
            }
        }
    }
    
    print("\(x) \(y)")
    print(total_carpet)
    
    return [x, y]
}