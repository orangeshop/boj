import Foundation



func solution(_ park:[String], _ routes:[String]) -> [Int] {
    
    var start_point = (0,0)
    var vis : [[Bool]] = Array(repeating : Array(repeating : false, count : 55) , count : 55)
    let dx = [0,1,0, -1]
    let dy = [1,0, -1, 0]
    
    for i in 0 ..< park.count{
        for k in 0 ..< park[i].count{
            // print(park[i][park[i].index(park[i].startIndex, offsetBy : k)])
            if(park[i][park[i].index(park[i].startIndex, offsetBy : k)] == "S"){
                start_point = (i,k)
            }
            if(park[i][park[i].index(park[i].startIndex, offsetBy : k)] == "X"){
                vis[i][k] = true
            }
        }
    }
    
    // print(start_point)
    // print(vis)
    
    // print(Int(String(routes[0][routes[0].index(routes[0].startIndex, offsetBy : 2)])))
    
    for i in 0 ..< routes.count{
        // print(start_point)
        
        if(routes[i][routes[i].index(routes[i].startIndex, offsetBy : 0)] == "E"){
            // 동
            var check = false
            var temp_point = start_point
            
            for dir in 0 ..< Int(String(routes[i][routes[i].index(routes[i].startIndex, offsetBy : 2)]))!{
//                 print(dir)
                var nx = start_point.0 + dx[0]
                var ny = start_point.1 + dy[0]
                // print("nx \(nx) ny \(ny) \(park.count)")
                if(nx < 0 || nx >= park.count || ny < 0 || ny >= park[0].count){
                    // print("hihi")
                    check = true
                    continue
                }
                if(vis[nx][ny] == true){
                    print("hihi")
                    check = true
                    continue
                }
                
                start_point = (nx,ny)
            }
            
            if(check == true){
                start_point = temp_point
            }
            else{
                // start_point = temp_point
            }
            
        }
        else if(routes[i][routes[i].index(routes[i].startIndex, offsetBy : 0)] == "S"){
            // 남
            
            var check = false
            var temp_point = start_point
            
            for dir in 0 ..< Int(String(routes[i][routes[i].index(routes[i].startIndex, offsetBy : 2)]))!{
//                 print(dir)
                var nx = start_point.0 + dx[1]
                var ny = start_point.1 + dy[1]
                
                if(nx < 0 || nx >= park.count || ny < 0 || ny >= park[0].count){
                    check = true
                    continue
                }
                if(vis[nx][ny] == true){
                    check = true
                    continue
                }
                
                start_point = (nx,ny)
            }
            
            if(check == true){
                start_point = temp_point
            }
            else{
                // start_point = temp_point
            }
        }
        else if(routes[i][routes[i].index(routes[i].startIndex, offsetBy : 0)] == "W"){
            // 서
            
            var check = false
            var temp_point = start_point
            
            for dir in 0 ..< Int(String(routes[i][routes[i].index(routes[i].startIndex, offsetBy : 2)]))!{
//                 print(dir)
                var nx = start_point.0 + dx[2]
                var ny = start_point.1 + dy[2]
                
                if(nx < 0 || nx >= park.count || ny < 0 || ny >= park[0].count){
                    check = true
                    continue
                }
                if(vis[nx][ny] == true){
                    check = true
                    continue
                }
                
                start_point = (nx,ny)
            }
            
            if(check == true){
                start_point = temp_point
            }
            else{
                // start_point = temp_point
            }
            
        }
        else if(routes[i][routes[i].index(routes[i].startIndex, offsetBy : 0)] == "N"){
            // 북
            
            var check = false
            var temp_point = start_point
            
            for dir in 0 ..< Int(String(routes[i][routes[i].index(routes[i].startIndex, offsetBy : 2)]))!{
//                 print(dir)
                var nx = start_point.0 + dx[3]
                var ny = start_point.1 + dy[3]
                
                if(nx < 0 || nx >= park.count || ny < 0 || ny >= park[0].count){
                    check = true
                    continue
                }
                if(vis[nx][ny] == true){
                    check = true
                    continue
                }
                
                start_point = (nx,ny)
            }
            
            if(check == true){
                start_point = temp_point
            }
            else{
                // start_point = temp_point
            }
        }
    }
    
    // print(start_point)
    
    
    return [start_point.0, start_point.1]
}