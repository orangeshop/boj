import java.util.*;

class Solution {
    static StringBuilder sb = new StringBuilder();
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        for(int i =0; i <= t * m; i++){
            sb.append(Integer.toString(i, n));
        }
        String tmp = sb.toString();
        for(int i = (p-1); i < t * m; i+=m){
            // System.out.println(i);
            answer += tmp.charAt(i)+"";
        }
        
        // System.out.println(sb);
        
        return answer.toUpperCase();
    }
}