import java.util.*;


class Solution {
    static int answer = Integer.MAX_VALUE;
    
    static int N, M;
    static int[][] gInfo;
    static Set<String> s = new HashSet<>();
    
    static void dfs(int depth, int a, int b){
        
        if(a >= answer){
            return;
        }
        
        if(s.contains(depth+"_"+a + "_" + b)){
           
            return;
        }
        
        if(a >= N || b >= M){
            return;
        }
        
        if(depth == gInfo.length){
            answer = Math.min(answer, a);
            
            return;
        }
        
        
        dfs(depth + 1, a + gInfo[depth][0], b);
        dfs(depth + 1, a, b + gInfo[depth][1]);
        
         s.add(depth+"_"+a + "_" + b);
    }
    
    public int solution(int[][] info, int n, int m) {
        N = n;
        M = m;
        
        gInfo = info.clone();
        
        
        
        dfs(0,0,0);
        
        if(answer == Integer.MAX_VALUE){
            answer = -1;
        }
        
        return answer;
    }
}