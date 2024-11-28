import java.util.*;
import java.math.*;


class Solution {
    
    static Deque<Integer> S1 = new ArrayDeque<>();
    static Deque<Integer> S2 = new ArrayDeque<>();
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        for(int i =0; i < n; i++){
            for(int k=0; k < deliveries[i]; k++){
                S1.addFirst(i+1);
            }
            
            for(int k=0; k < pickups[i]; k++){
                S2.addFirst(i+1);
            }   
        }
        
        while(S1.size() != 0 && S2.size() != 0){
            int s1Item = S1.getFirst();
            int s2Item = S2.getFirst();
            
            for(int i =0; i < cap; i++){
                if(S1.size() != 0) S1.removeFirst();
                if(S2.size() != 0) S2.removeFirst();
            }
            
            answer += Math.max(s1Item, s2Item) * 2L;
        }
        
        while(S1.size() != 0){
            int s1Item = S1.getFirst();
            
            for(int i =0; i < cap; i++){
                if(S1.size() != 0) S1.removeFirst();
            }
            
            answer += s1Item * 2L;
        }
        
        while(S2.size() != 0){
            int s2Item = S2.getFirst();
            
            for(int i =0; i < cap; i++){
                if(S2.size() != 0) S2.removeFirst();
            }
            
            answer += s2Item * 2L;
        }
        
        
        
        return answer;
    }
}