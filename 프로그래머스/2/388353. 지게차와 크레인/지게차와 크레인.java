import java.util.*;

class Solution {
    
    static final int minus = 65;
    
    static int[][] board;
    static boolean[][] vis;
    
    static int N,M,answer;
    
    static ArrayDeque<Pair> Q = new ArrayDeque<>();
    static ArrayDeque<Pair> Q2 = new ArrayDeque<>();
    
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    
    
    static class Pair{
        int x, y;
        
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    
    public int solution(String[] storage, String[] requests) {
        
        
        N = storage.length;
        M = storage[0].length();
        
        board = new int[N+2][M+2];
        vis = new boolean[N+2][M+2];
        
        for(int i = 1; i <= N; i++){
            String str = storage[i-1];
            for(int k = 1; k <= M; k++){
                board[i][k] = str.charAt((k-1))-'A'+1;
            }
        }
        
        for(int i =0; i < requests.length; i++){
            if(requests[i].length() == 1){
                bfsType1(requests[i].charAt(0)-'A'+1);
            }else{
                bfsType2(requests[i].charAt(0)-'A'+1);
            }
        }
        
        see();
        
        
        
        
        return answer;
    }
    
    public static void bfsType1(int num){
    
        for(int i = 0; i < N+2; i++){
            for(int k = 0; k < M+2; k++){
                vis[i][k] = false;
            }   
        }
        
        Q.add(new Pair(0,0));
        vis[0][0] = true;
        
        while(!Q.isEmpty()){
            Pair cur = Q.removeFirst();
            // System.out.println(cur.x + " " + cur.y);
            
            for(int dir = 0; dir < 4; dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                
                if(nx < 0 || nx >= N+2 || ny < 0 || ny >= M+2) continue;
                if(board[nx][ny] != 0) continue;
                if(vis[nx][ny]) continue;
                
                if(0 == board[nx][ny]){
                    Q2.add(new Pair(nx, ny));
                }
                
                Q.add(new Pair(nx,ny));
                vis[nx][ny] = true;
            }
        }
        

        
        while(!Q2.isEmpty()){
            Pair cur = Q2.removeFirst();
            
            for(int dir = 0; dir < 4; dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                
                if(nx < 0 || nx >= N+1 || ny < 0 || ny >= M+1) continue;
                if(vis[nx][ny]) continue;
                
                if(num == board[nx][ny]){
                    board[nx][ny] = 0;
                }
            }
        }
    }
    
    public static void bfsType2(int num){
        for(int i = 0; i <= N+1; i++){
            for(int k = 0; k <= M+1; k++){
                if(board[i][k] == num){
                    board[i][k] = 0;
                }
            }   
        }
    }
    
    public static void see(){
        for(int i = 0; i <= N+1; i++){
            for(int k = 0; k <= M+1; k++){
                System.out.print(board[i][k] + " ");
                if(board[i][k] != 0) answer++;
            }
             System.out.println();
        }
    }
}