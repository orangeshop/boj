func solution(_ n:Int, _ arr1:[Int], _ arr2:[Int]) -> [String] {
    var answer: [String] = []
    var answer1: [String] = []
    for i in 0 ..< n{
        var result : String = "" 

        
        var temp1 = Array(String(arr1[i], radix : 2))
        while(temp1.count < n){
            temp1.insert("0", at : 0)
        }
        // print(temp1)
        
        var temp2 = Array(String(arr2[i], radix : 2))
        while(temp2.count < n){
            temp2.insert("0", at : 0)
        }
        // print(temp2)
        
        for k in 0 ..< n{
            if(temp1[k] == "1" || temp2[k] == "1"){
                result += "#"
            }
            else{
                result += " "
            }
        }
        
        // print(result)
        answer.append(result)
        
    }
    
    
    
    return answer
}