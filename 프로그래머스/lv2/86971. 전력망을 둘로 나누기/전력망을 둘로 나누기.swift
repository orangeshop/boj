import Foundation


var adj : [[Int]] = Array(repeating : Array(repeating : 0, count : 0), count : 105)
var max_num : Int = 0
var vis : [Bool] = Array(repeating : false, count : 105)
var queue : [Int] = []
var check : Bool = false
var pre_num : Int = 0
var nxt_num : Int = 0
var result_num : Int = 9999999
func bfs(now_num : Int, target_break_num : Int){
       
    vis[now_num] = true
    vis[target_break_num] = true
    queue.append(now_num)
   
    while(!queue.isEmpty){
        // print(queue.first)
        if(check == false){
            pre_num += 1
        }
        else{
            nxt_num += 1
        }
        var cur = queue.first!
        
        queue.remove(at : 0)
        for dir in 0 ..< adj[cur].count{
            if(vis[adj[cur][dir]] == true){continue}
            // print("cur : \(cur), dir : \(dir), \(adj[cur][dir]) \(adj[cur].count)")
            
            
            queue.append(adj[cur][dir])
            vis[adj[cur][dir]] = true
        }
    }
    
    // print("pre : \(pre_num) nxt : \(nxt_num)")
}


func solution(_ n:Int, _ wires:[[Int]]) -> Int {
    
    for i in 0 ..< wires.count{
        adj[wires[i][0]].append(wires[i][1])
        adj[wires[i][1]].append(wires[i][0])
        if(max_num < wires[i][0]){
            max_num = wires[i][0]
        }
        if(max_num < wires[i][1]){
            max_num = wires[i][1]
        }
    }
    

    // print(max_num)
    // print(adj)
    
    for i in 0 ..< wires.count{
        bfs(now_num : wires[i][0], target_break_num : wires[i][1])
        vis = Array(repeating : false, count : 105)
        check = true
        bfs(now_num : wires[i][1], target_break_num : wires[i][0])
        
        if(result_num > abs(pre_num - nxt_num)){
            result_num = abs(pre_num - nxt_num)
        }
        
        vis = Array(repeating : false, count : 105)
        pre_num = 0
        nxt_num = 0
        check = false
    }
    
    
    return result_num
}