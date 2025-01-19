import java.math.*;
import java.util.*;


class Solution {
    
    static int[] arr = new int[60005];
    static List<Pair> ls = new ArrayList<>();
    
    static class Pair{
        int x,y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] routes) {
        int answer = 0;
        
        for(int[] nxt : routes){
            ls.add(new Pair(nxt[0], nxt[1]));
        }
        
        ls.sort((o1, o2) -> {
           return  o1.y - o2.y; 
        });
        
        
        int preEnd = Integer.MIN_VALUE;
        for(Pair nxt : ls){
            // System.out.println(nxt.x + " " + nxt.y);
            if(preEnd < nxt.x){
                preEnd = nxt.y;
                answer++;
            }
        }
        
        
        
        return answer;
    }
}