func solution(_ n:Int) -> Int {
    
    var arr : [Bool] = Array(repeating : false, count :1000001)
    var answer = 0
    for i in 2 ..< n+1{
        if(arr[i] == true){continue}
        for k in 1 ..< 500001{
            if(i * k > n) {break}
            arr[i * k] = true
        }
        answer += 1
    }
    
    
    return answer
}