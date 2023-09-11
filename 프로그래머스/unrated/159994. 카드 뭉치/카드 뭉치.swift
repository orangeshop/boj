import Foundation

func solution(_ cards1:[String], _ cards2:[String], _ goal:[String]) -> String {
    
    var target_card1 = 0
    var target_card2 = 0
    
    for i in 0 ..< goal.count{
        // print(goal[i])
        if(goal[i] == cards1[target_card1] || goal[i] == cards2[target_card2] ){
            if(goal[i] == cards1[target_card1]){
                print("\(cards1[target_card1]) \(i)")
                target_card1 += 1
                if(target_card1 >= cards1.count){
                    target_card1 = cards1.count - 1
                }
                continue
            }
            
            if(goal[i] == cards2[target_card2]){
                print("\(cards2[target_card2]) \(i)")
                target_card2 += 1
                if(target_card2 >= cards2.count){
                    target_card2 = cards2.count - 1
                }
                continue
            }
            
            
        }
        else{
            return "No"
        }
    }
    
    
    
    return "Yes"
}