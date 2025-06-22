import java.util.*;

class Solution {
    
    static class Pair{
        int x, y,z;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        Pair(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    
    
    public int[] solution(String[][] places) {
        
        int N = places.length;
        
        int[] answer = new int[N];
        
        Arrays.fill(answer, 1);
        
        
        for(int j =0; j < N; j++){
            int[][] board = new int[N][N];
            ArrayList<Pair> arr = new ArrayList<>();
            
            
            for(int i = 0; i < N; i++){
                String str = places[j][i];
                for(int k =0; k < N; k++){
                     if(str.charAt(k) == 'P'){
                         board[i][k] = 1;
                         arr.add(new Pair(i,k));
                     }else if(str.charAt(k) == 'O'){
                         board[i][k] = 0;
                     }else{
                         board[i][k] = 2;
                     }
                }
            }
            
            for(int i =0; i < arr.size()-1; i++){
                for(int k = i+1; k < arr.size(); k++){
                    Pair first = arr.get(i);
                    Pair second = arr.get(k);
                    
                    if(calc(first.x, first.y, second.x, second.y)){
                       
                    }else{
                        
                        System.out.println(first.x + " " + first.y + " " + second.x + " " + second.y);
                        
                        // 여기에서  2
                        ArrayDeque<Pair> q = new ArrayDeque<>();
                        boolean[][] vis = new boolean[N][N];
                        
                        q.add(new Pair(first.x, first.y, 0));
                        vis[first.x][first.y] = true;
                        
                        
                        
                        while(!q.isEmpty()){
                            Pair cur = q.removeFirst();
                            
                            if(cur.x == second.x && cur.y == second.y){
                                System.out.println("asd " + cur.z);
                                    
                                if(cur.z <= 2){
                                    answer[j] = 0;
                                }
                                break;
                            }
                            
                            for(int dir = 0; dir < 4; dir++){
                                int nx = cur.x + dx[dir];
                                int ny = cur.y + dy[dir];
                                
                                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                                if(vis[nx][ny] == true || board[nx][ny] == 2) continue;
                                
                                q.add(new Pair(nx,ny, cur.z + 1));
                                vis[nx][ny] = true;
                            }
                            
                        }
                    }
                    
                }
            }
            
            System.out.println();
            
            for(int i =0; i < N; i++){
                for(int k =0; k < N; k++){
                    System.out.print(board[i][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
            
        }
        
        return answer;
    }
    
    private boolean calc(int x1, int y1, int x2, int y2){
        
        
        return Math.abs(x1 - x2) + Math.abs(y1 - y2) > 2 ? true : false;
    }
}