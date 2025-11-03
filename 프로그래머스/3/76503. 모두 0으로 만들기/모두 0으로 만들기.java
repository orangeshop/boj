import java.util.*;

class Solution {
    static long answer = 0;
    
    static ArrayList<Integer>[] adj;
    static int N = 0;
    
    static long[] indegree;
    static long[] result;
    
    public long solution(int[] a, int[][] edges) {
        
        if(Arrays.stream(a).sum() != 0){
            return -1;
        }
        
        N = a.length;
        adj = new ArrayList[N + 1];
        indegree = new long[N];
        result = new long[N];
        
        for(int i =0; i < N; i++){
            result[i] = a[i];
        }
        
        for(int i =0; i <= N; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int[] nxt : edges){
            adj[nxt[0]].add(nxt[1]);
            adj[nxt[1]].add(nxt[0]);
            indegree[nxt[0]]++;
            indegree[nxt[1]]++;
        }
        
        solve();
        
        return answer;
    }
    
    static void solve(){
        boolean[] vis = new boolean[N];
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i =0; i < N; i++){
            if(indegree[i] == 1){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            Integer cur = q.removeFirst();
            vis[cur] = true;
            
            for(Integer nxt : adj[cur]){
                if(vis[nxt]) continue;
                indegree[nxt]--;
                
                result[nxt] += result[cur];
                answer += Math.abs(result[cur]);
                result[cur] = 0;
                if(indegree[nxt] == 1){
                    q.add(nxt);
                }
            }
        }
        
        // System.out.println(Arrays.toString(q.toArray()));
    }
}