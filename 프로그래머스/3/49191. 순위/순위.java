import java.util.*;

class Solution {
    
    static ArrayList<Integer>[] adj;
    static int[] indegree;
    
    static TreeSet<Integer>[] win;
    static TreeSet<Integer>[] lose;
    
    static class Pair{
        int x,y;
        
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        adj = new ArrayList[n+1];
        win = new TreeSet[n+1];
        lose = new TreeSet[n+1];
        
        indegree = new int[n+1];
        
        for(int i =0; i <= n; i++){
            adj[i] = new ArrayList<>();
            win[i] = new TreeSet<>();
            lose[i] = new TreeSet<>();
            
        }
        
        for(int[] nxt : results){
            adj[nxt[1]].add(nxt[0]);
            indegree[nxt[0]]++;
            
        }
        
        ArrayDeque<Pair> Q = new ArrayDeque<>();
        
        for(int i =1; i <= n; i++){
            if(indegree[i] == 0){
                Q.add(new Pair(i,-1));
            }
        }
        
        while(!Q.isEmpty()){
            Pair cur = Q.removeFirst();
            
            System.out.println(cur.x + " " + cur.y);
            
            
            for(int nxt : adj[cur.x]){
                indegree[nxt]--;
                
                for(int ss : win[cur.x]){
                    win[nxt].add(ss);
                }
                
                win[nxt].add(cur.x);
                
                if(indegree[nxt] == 0){
                    Q.add(new Pair(nxt, cur.x));
                }
            }
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j) continue;
                if(win[j].contains(i)){
                    lose[i].add(j);
                }
            }
        }
        
        for(int i = 1; i <=n; i++){
            if(win[i].size() + lose[i].size() == n-1) answer++;
        }
        
        return answer;
    }
}

/*

indegree

1 : 1
2 : 1
3 : 1
4 : 2
5 : 0

5 -> 2 -> {1,3} -> {4} 

*/