import Foundation

func solution(_ a:Int, _ b:Int, _ n:Int) -> Int {
    
    var answer = 0
    
    var remain_bottle = n
    
    var test = 0
    repeat{
        if(test == 10000){
            break
        }
        var rest_num = remain_bottle % a
        answer += (remain_bottle / a) * b
        remain_bottle = (remain_bottle / a) * b
        remain_bottle += rest_num
        
        // print("ans \(answer), bottle\(remain_bottle), num\(rest_num)")
        test += 1
    }while(true)
    
    return answer
}

// n 을 a로 나눈 수를 answer 과 remain_bottle에 할당
// remain_bottle에는 10이 들어가고 n % a의 나머지 값이 들어가야함
// 그럼 remain_bottle은 최종적으로 10이 된다.

// 그 다음 싸이클에는 remain_bottle에 a를 나눈몫의 값을 할당
// answer = 15, remain_bottle도 5 
// 나머지값은 0 -> remain_bottle의 값은 5
// 