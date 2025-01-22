import java.util.*;
import java.math.*;

class Solution {
    
    static ArrayDeque<Pair> Q = new ArrayDeque<>();
    
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    
    static class Pair{
        int x, y;
        int pre, corner, total;
        
        Pair(int x, int y, int pre, int corner, int total){
            this.x = x;
            this.y = y;
            
            this.pre = pre;
            this.corner = corner;
            this.total = total;
            
        }
    }
    
    static int[][] vis;
    
    
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int n = board.length;
        vis = new int[n][n];
        
        for(int i =0; i < n; i++){
            for(int k =0; k < n; k++){
                vis[i][k] = Integer.MAX_VALUE;
            }
        }
        
        Q.add(new Pair(0,0,-1,-1,0));
        vis[0][0] = 1;
        
        while(!Q.isEmpty()){
            Pair cur = Q.removeFirst();
            
            // System.out.println(cur.x + " " + cur.y + " " + cur.pre + " " + cur.total + " " + cur.corner);
            
            if(cur.x == n-1 && cur.y == n-1){
                // System.out.println("end " + cur.total + " " + cur.corner);
                // answer = ((cur.total)- cur.corner) * 100 + (cur.corner * 500);
                answer = Math.min(answer, cur.total * 100 + cur.corner * 500);
                
            }
            
            for(int dir =0; dir < 4; dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                
                int c = cur.corner;
                if(cur.pre != dir){
                    // System.out.println("*** " + nx + " " + ny);
                    c++;
                }
                
                if(vis[nx][ny] < c || board[nx][ny] == 1) continue;
                
                if(c <= vis[nx][ny]){
                    Q.add(new Pair(nx,ny, dir, c, cur.total+1));
                    vis[nx][ny] = c;
                }
                
            }
        }
        
        
        return answer;
    }
}