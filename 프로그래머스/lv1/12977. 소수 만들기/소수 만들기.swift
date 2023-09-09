import Foundation

var arr : [Int] = []
var vis : [Bool] = Array(repeating : false, count :55)
var check_duplication : [[Bool]] = [[]]
var check_test_duple : Set<[Bool]> = [[]]
func clac(idx : Int, sum_num : Int , nums : [Int]){
   if(idx == 3){
        for i in 0 ..< check_duplication.count{
            if(check_duplication[i] == vis){
                return
            }
        }
        
        check_duplication.append(vis)
        arr.append(sum_num)
        return
    }

    for k in idx ..< nums.count{
        if(vis[k] != true){
            vis[k] = true
            clac(idx : idx + 1, sum_num : sum_num + nums[k], nums : nums)
            vis[k] = false
        }
    }   
}

var prime : [Bool] = Array(repeating : false, count : 3005)

func prime_num(){
    for i in 2 ..< 2999{
        var j = 2
        while(i * j <= 2999){ 
            if(i * j > 2999){
                break
            }
            prime[i * j] = true
            j += 1
        }
    }
}

func solution(_ nums:[Int]) -> Int {
    var answer = 0
    
    // clac(idx :0, sum_num : 0,nums : nums)
    
    
    prime_num()
    
    for i in 0 ..< nums.count{
        for k in i+1 ..< nums.count{
            for j in k+1 ..< nums.count{
                arr.append(nums[i] + nums[k] + nums[j])
            }
        }
    }
    
    print(arr)
    
    for i in 0 ..< arr.count{
        if(prime[arr[i]] == false){
            answer += 1
        }
    }
    
    return answer
}