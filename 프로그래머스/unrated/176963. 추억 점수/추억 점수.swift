import Foundation

func solution(_ name:[String], _ yearning:[Int], _ photo:[[String]]) -> [Int] {
    
    
    var total_list : [(String, Int)] = []
    var result_list : [Int] = []
    for i in 0 ..< name.count{
        total_list.append((name[i], yearning[i]))
    }
    print(total_list[0].0)
    
    for i in 0 ..< photo.count{
        var Int_sum = 0
        for k in 0 ..< photo[i].count{
            for j in 0 ..< total_list.count{
                if(total_list[j].0 == photo[i][k]){
                    Int_sum += total_list[j].1
                }
            }
        }
        
        result_list.append(Int_sum)
    }
    
    return result_list
}