
var arr = Array.init(repeating: -1, count: 100001)

func solution(_ n:Int) -> Int {

     if n == 0 { return 0 }
    if n == 1 { return 1 }

    if arr[n] != -1 { return arr[n] }

    let res = solution(n - 1) + solution(n - 2)
    arr[n] = res

    return res % 1234567
}