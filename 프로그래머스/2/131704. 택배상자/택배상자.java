import java.util.*;
import java.math.*;

class Solution {
    
    static ArrayDeque<Integer> Q = new ArrayDeque<>();
    static ArrayDeque<Integer> S = new ArrayDeque<>();
    static boolean[] vis;
    
    public int solution(int[] order) {
        int answer = 0;
        int cnt = 0;
        int maxNum = 1;
        
        vis = new boolean[order.length + 1999];
        
        for(int i =0; i < order.length; i++){
            Q.add(order[i]);
        }
        
        /*
        [4, 3, 1, 2, 5]
        
        Q 4, 3, 1, 2, 5
        
        S 4 3 2 1
        
        1 2 4 3 5
        
        
        */
        
        while(true){
            if (cnt >= order.length) break;
            
            
            for(int i = maxNum; i <= Q.getFirst().intValue(); i++){
                if(vis[i] == true) continue;
                // System.out.println(i + " ");
                S.add(i);
                vis[i] = true;
                maxNum = Math.max(i, maxNum);
            }
            
            
            // System.out.println(S.getLast());
            
            if(S.getLast().intValue() == Q.getFirst().intValue()){
                answer++;
                S.removeLast();
                Q.removeFirst();
            }else{
                break;
            }
            
            cnt++;
            
           
        }
        
        
        return answer;
    }
}