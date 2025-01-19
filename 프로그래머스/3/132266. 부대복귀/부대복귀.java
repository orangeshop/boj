import java.util.*;

class Solution {
    
    static List<Integer>[] adj;
    static List<Integer> result = new ArrayList<>();
    
    static int[] dp = new int[100005];
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer;
        
        adj = new List[n+1];
        
        for(int i =0; i <= n; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int[] nxt : roads){
            adj[nxt[0]].add(nxt[1]);
            adj[nxt[1]].add(nxt[0]);
        }
        
        // dp[2] -> 2 에서 1까지 걸리는 거리
        
        // dp[3] -> 3 에서 1까지 걸리는 거리
        
        ArrayDeque<Pair> Q = new ArrayDeque<>();
        
        Q.add(new Pair(destination, 0));
        boolean[] vis = new boolean[n+1];
        vis[destination] = true;
        dp[destination] = 1;
        
        while(!Q.isEmpty()){
            Pair cur = Q.removeFirst();
            
            for(Integer nxt : adj[cur.x]){
                if(vis[nxt] == true) continue;
                
                Q.add(new Pair(nxt, 0));
                vis[nxt] = true;
                dp[nxt] = dp[cur.x] + 1;
            }
            
        }
        
        for(int s : sources){
            for(int i =0; i <= n ; i++){
                if(s == i){
                    result.add(--dp[i]);
                }
            }
        }
        
        
        answer = new int[result.size()];
        
        for(int i =0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    static class Pair{
        int x,y;
        
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static void see(){
        for(List<Integer> ls : adj){
            for(Integer v : ls){
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}

/*
for(int s : sources){
            
            
            if(s == destination){
                result.add(0);
                continue;
            }
            
            boolean[] vis = new boolean[n+1];    
            Q.add(new Pair(s, 0));
            vis[s] = true;
            
            
            
            while(!Q.isEmpty()){
                Pair cur = Q.removeFirst();
                
                if(dp[cur.x] != 0){
                    
                    System.out.println("* " + dp[cur.x]);
                    
                    result.add(cur.y + dp[cur.x]);
                    dp[s] = dp[cur.x];
                    vis[destination] = true;
                    break;
                }
                
                if(cur.x == destination){
                    result.add(cur.y);
                    dp[s] = cur.y;
                    
                }

                for(Integer nxt : adj[cur.x]){
                    if(vis[nxt] == true) continue;
                    
                    Q.add(new Pair(nxt, cur.y + 1));
                    vis[nxt] = true;
                }
            }
            
            if(vis[destination] == false){
                result.add(-1);
            }
            
            // System.out.println(Arrays.toString(result.toArray()));
            
        }


*/