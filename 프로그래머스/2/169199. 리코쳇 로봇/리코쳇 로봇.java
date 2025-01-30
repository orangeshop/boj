import java.util.*;

class Solution {
    
    static ArrayDeque<Pair> Q = new ArrayDeque<>();
    
    /*
    00 01 02
    10 11 12
    20 21 22
    */
    
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    
    static int[][] map;
    static Pair end = new Pair(0,0);
    static boolean[][] vis;
    
    static int N,M;
    
    static Pair move(int dir, int x, int y){
        
        int curx = x;
        int cury = y;
        
        while(true){
            // System.out.println(curx + " " + cury);
            int nx = curx + dx[dir];
            int ny = cury + dy[dir];
            
            if(nx < 0 || nx >= N || ny < 0 || ny >= M){
                return new Pair(curx, cury);
            }
            
            if(map[nx][ny] == 1){
                return new Pair(curx ,cury);
            }
            
            curx = nx;
            cury = ny;
        }
    }
    
    public int solution(String[] board) {
        int answer = Integer.MIN_VALUE;
        N = board.length;
        M = board[0].length();
        
        vis = new boolean[N][M];
        
        map = new int[N][M];
        
        for(int i =0; i < board.length; i++){
            for(int k =0; k < board[i].length(); k++){
                if(board[i].charAt(k) == '.'){
                    map[i][k] = 0;
                }else if(board[i].charAt(k) == 'D'){
                    map[i][k] = 1;
                }
                else if(board[i].charAt(k) == 'R'){
                    map[i][k] = 2;
                    Q.add(new Pair(i,k,0));
                    vis[i][k] = true;
                }
                else if(board[i].charAt(k) == 'G'){
                    map[i][k] = 3;
                    end = new Pair(i,k);
                }
            }
        }
        
        
        // Pair t = move(3, Q.getFirst().x, Q.getFirst().y);
        // System.out.println(t.x + " " + t.y);
        
        while(!Q.isEmpty()){
            Pair cur = Q.removeFirst();
            
            if(cur.x == end.x && cur.y == end.y){
                System.out.println(cur.x + " " + cur.y + " " + cur.cnt);
            
                answer = cur.cnt;
                break;
            }
            
            for(int dir = 0; dir < 4; dir++){
                Pair m = move(dir, cur.x, cur.y);
                
                int nx = m.x;
                int ny = m.y;
                
                if(vis[nx][ny]) continue;
                
                vis[nx][ny] = true;
                Q.add(new Pair(nx, ny, cur.cnt+1));
                
            }
        }
        
        if(answer == Integer.MIN_VALUE){
            answer = -1;
        }
        
        return answer;
    }
    
    static class Pair{
        int x, y, cnt;
        
        Pair(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
        
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}