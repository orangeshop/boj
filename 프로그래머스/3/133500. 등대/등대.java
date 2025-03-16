import java.util.*;

class Solution {
    
    
    static ArrayList<Integer>[] adj;
    static int answer = 0, N;
    public int solution(int n, int[][] lighthouse) {
        N = n; 
        adj = new ArrayList[N+1];
        
        for(int i =0; i <=N; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i =0; i < N-1; i++){
            int a = lighthouse[i][0];
            int b = lighthouse[i][1];
            
            adj[a].add(b);
            adj[b].add(a);
        }
        
        dfs(1,0);
        
        return answer;
    }
    
    static int dfs(int node, int prev){
        // System.out.println(node + " " + prev);
        
        if(adj[node].size() == 1 && adj[node].get(0) == prev){
            // System.out.println("*");
            return 1;
        }
        
        int net = 0;
        for(int i = 0; i < adj[node].size(); i++){
            int nxt = adj[node].get(i);
            if(nxt == prev) continue;
            net += dfs(nxt, node);
        }
        
        if(net == 0){
            // System.out.println("**");
            return 1;
        }
        answer++;
        // System.out.println("***");
        return 0;
        
    }
}



