import Foundation

func solution(_ dots:[[Int]]) -> Int {
    
    var target_min = [999,999]
    var target_max = [-999,-999]
    
    var col = 0
    var row = 0
    // print(target[0])
    
    for i in 0 ..< dots.count{
        if(target_min[0] >= dots[i][0] && target_min[1] >= dots[i][1])
        {
            target_min = dots[i]
        }
        
        if(target_max[0] <= dots[i][0] && target_max[1] <= dots[i][1] )
        {
            target_max = dots[i]
        }
        
    }
    
    print(target_min)
    print(target_max)
    
    var result = 0
    
    if(target_max[0] - target_min[0] == 0){
        // result = abs(target_max[1] - target_max[0])
        // result *= result
    }
    else if(target_max[1] - target_min[1] == 0){
        // result = abs(target_max[1] - target_max[0])
        // result *= result
    }
    else{
        result = abs(target_max[0] - target_min[0]) * abs(target_max[1] - target_min[1])
    }
    
    
    
    
    
    return result
}