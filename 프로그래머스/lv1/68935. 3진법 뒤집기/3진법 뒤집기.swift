import Foundation

var arr : [Int] = []
func solution(_ n:Int) -> Int {
    
    var result = 0
    var num = n
    if(n == 1){
        return 1
    }
    else if(n == 2){
        return 2
    }
    else if(n == 3){
        return 10
    }
    
    
    while(num/3 > 0){
        
        arr.append(num % 3)
        num /= 3
        
        // print(num)
    }
    
    arr.append(num % 3)
    // arr.append(num / 3)
    
    print(arr)
    
    
    for i in 0 ..< arr.count{
        var test_num = 1
        for k in 0 ..< arr.count - (i + 1){
            test_num *= 3
        }
        // print(test_num)
        result += Int(test_num * arr[i])
    }
    
    return result
}

// 45/3 = 15 , 0
// 15/3 = 5, 0
// 5/3 = 1, 2
// 2/3 = 

// 1 3 9 54 162 

// 55 165 9

// 229