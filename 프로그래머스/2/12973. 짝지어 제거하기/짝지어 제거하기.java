import java.util.*;

class Solution {
    public static int answer = 0;
 
    public static ArrayDeque<String> Q = new ArrayDeque<>();
    public static ArrayDeque<String> tQ = new ArrayDeque<>();
    
    
    public int solution(String s) {
        
        for(int i =0; i < s.length(); i++){
            Q.add(s.charAt(i) + "");
        }    
        
        tQ.add(Q.removeFirst());
        
        while(!Q.isEmpty()){
            String cur = Q.removeFirst();
            
            if(tQ.isEmpty()){
                tQ.add(cur);
                continue;
            }
            
            // System.out.println(tQ.getLast() + " : " + cur);
            
            if(tQ.getLast().contains(cur)){
                tQ.removeLast();
            }else{
                tQ.add(cur);
            }
        }
        
        if(Q.isEmpty() && tQ.isEmpty()){
            answer = 1;
        }
        
        return answer;
    }
}