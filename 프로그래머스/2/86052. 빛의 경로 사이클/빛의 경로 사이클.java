import java.util.*;

class Solution {
    
    static boolean[][][] vis;
    
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int n;
    static int m;
    
    
    public int[] solution(String[] grid) {
        List<Integer> answer = new ArrayList<>();
        
        n = grid.length;
        m = grid[0].length();
        
        vis = new boolean[n][m][4];
        
        for(int i =0; i < n; i++){
            for(int k =0; k < m; k++){
                for(int j =0; j < 4; j++){
                    int num = bfs(grid, i,k,j);
                    if(num != 0){
                        answer.add(num);
                    }
                    
                }
            }
        }   
        
        return answer.stream().sorted().mapToInt(i->i).toArray();
    }
    
    static int bfs(String[] grid, int x, int y, int d){
        int cnt = 0;
        
        while(!vis[x][y][d]){
            cnt++;
            vis[x][y][d] = true;
            
            if(grid[x].charAt(y) == 'L'){
                d = (d+3) % 4;
            }
            if(grid[x].charAt(y) == 'R'){
                d = (d+1) % 4;
            }
            
            x = (x + dx[d] + n) % n;
            y = (y + dy[d] + m) % m;
            
        }
        
        return cnt;
    }
    
}