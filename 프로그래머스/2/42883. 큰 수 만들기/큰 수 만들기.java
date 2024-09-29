import java.util.*;

class Solution {
    
    static Stack<Character> S = new Stack<>();
   
    
    public String solution(String number, int k) {
        String answer = "";
        int length = number.length() - k;
        
        for (int i =0; i < number.length(); i++){
            
            char a = number.charAt(i);
            
            while (!S.isEmpty() && S.peek() < a && k > 0){
                S.pop();
                k--;
            }
            
            S.push(a);
            
        }
        
        
        
        StringBuilder sb = new StringBuilder();
        while (!S.isEmpty()) {
            sb.append(S.pop());
        }

        return sb.reverse().substring(0, length);
    }
}