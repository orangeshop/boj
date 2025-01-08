import java.util.*;
class Solution {
    
    static boolean[] lVis;
    static boolean[] rVis;
    static boolean[] vis;
    static int answer;
    static int N;
    
    static void dfs(int depth, int cnt){
        if(depth == N){
            answer++;
            return;
        }
        
        for(int i =0; i < N; i++){
            if(!lVis[depth + i] && !rVis[(N+1) + depth - i] && !vis[i]){
                lVis[depth + i] = true;
                rVis[(N+1) + depth - i] = true;
                vis[i] = true;
                dfs(depth + 1, cnt+1);
                lVis[depth + i] = false;
                rVis[(N+1) + depth - i] = false;
                vis[i] = false;
            }
        }   
    }
    
    public int solution(int n) {
        
        lVis = new boolean[n * 2 + 1];
        rVis = new boolean[n * 2 + 1];
        vis = new boolean[n];
        N = n;
        
        dfs(0, 0);
        
        return answer;
    }
}