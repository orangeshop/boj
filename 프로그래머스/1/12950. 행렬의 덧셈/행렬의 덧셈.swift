func solution(_ arr1:[[Int]], _ arr2:[[Int]]) -> [[Int]] {
    var answer : [[Int]] = Array(repeating : Array(repeating : 0, count : arr1[0].count),count : arr1.count)
    
    // print(answer)
    
    for i in 0 ..< arr1.count{
        for k in 0 ..< arr1[i].count{
            // print(arr1[i][k])
            answer[i][k] = arr1[i][k] + arr2[i][k]  
        }
    }
    return answer
}