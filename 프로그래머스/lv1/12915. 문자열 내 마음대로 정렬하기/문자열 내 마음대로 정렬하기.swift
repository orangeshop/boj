func solution(_ strings:[String], _ n:Int) -> [String] {
    
    
    return strings.sorted(by : { (str1, str2) -> Bool in
                           let char1 = Array(str1)[n]
                           let char2 = Array(str2)[n]
                           
                           if(char1 == char2){
                               return str1 < str2
                           }
                           
                           return char1 < char2
                           
                           
    })
}