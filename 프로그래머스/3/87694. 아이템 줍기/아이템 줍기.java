import java.util.*;

class Solution {
    
    static int[][] board = new int[110][110];
    static boolean[][] vis = new boolean[110][110];
    
    static ArrayDeque<Pair> Q = new ArrayDeque<>();
    
    static class Pair{
        int x, y;
        int cnt;
        
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        Pair(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    
    static void fill(int x1, int y1, int x2, int y2){
        for(int i = x1; i <= x2; i++){
            for(int k = y1; k <= y2; k++){
                if(board[i][k] == 2) continue;
                board[i][k] = 2;
                if(i == x1 || i == x2 || k == y1 || k == y2){
                    board[i][k] = 1;
                }
            }
        }
    }
    
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        for(int i =0; i < 55 * 2; i++){
            for(int k =0; k < 55 * 2; k++){
                board[i][k] = -1;
            }
        }
        
        
        for(int i =0; i < rectangle.length; i++){
            
            fill(rectangle[i][0] * 2, rectangle[i][1] * 2, rectangle[i][2] * 2, rectangle[i][3] * 2);
        }
        
        
        
        Q.add(new Pair(characterX * 2, characterY * 2, 0));
        vis[characterX * 2][characterY * 2] = true;
        
        /*
        00 01 02
        10 11 12
        20 21 22
        
        */
        
        while(!Q.isEmpty()){
            Pair cur = Q.removeFirst();
            
                        
            if(cur.x == itemX * 2 && cur.y == itemY * 2){
                answer = cur.cnt;
                break;
            }
            
            // System.out.println(cur.x + " " + cur.y + " " + cur.cnt);
             
            for(int dir =0; dir < 4; dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                
                
                if(nx < 0 || nx >= 110 || ny < 0 || ny >= 110) continue;
                if(vis[nx][ny] == true || board[nx][ny] != 1) continue;
            
                
                Q.add(new Pair(nx, ny, cur.cnt + 1));
                vis[nx][ny] = true;
                
            }
            
        }
        
        return answer / 2;
    }
    
}