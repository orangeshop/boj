import Foundation

func prime_num(){
    
}

func clac(_ n : Int, _ k : Int) -> [Int]{
    
    var num = n
    var temp : [Int] = []
    while(true){
        if num == 0{
            break
        }
        else if num == 1{
            temp.append(num)
            break
        }
        var result = 0
        result = num%k
        num = num/k
        temp.append(result)
        
    }
    temp.reverse()
    return temp
}

func solution(_ n:Int, _ k:Int) -> Int {
    var answer : Int = 0
    
    var arr : [Int] = []
    
    arr = clac(n,k)
    
    print(arr)
    
    var result : Int = 0
    
    var result_arr : [Int] = []
    
    for i in 0 ..< arr.count{
        // print(arr[i])
        // print(i)
        if(arr[i] == 0){
            // print(result)
            result_arr.append(result)
            result = 0
        }
        else{
            if(result == 0){
                result += arr[i]
            }
            else{
                result *= 10
                result += arr[i]
            }
        }
    }
    result_arr.append(result)
    
    print(result_arr)
    
    for i in 0 ..< result_arr.count{
        if(result_arr[i] == 0 || result_arr[i] == 1){
            continue
        }
        var check = false
        
        for k in 1 ..< result_arr[i]{
            if(k == 1){
                continue
            }
            if(k == 100){
                break
            }
            
            if(result_arr[i] % k == 0){
                check = true
                break
            }
        }
        
        if(check == false){
            answer += 1
        }
    }
    
    return answer
}

// 100 / 10 = 10
// 10 / 10 = 1