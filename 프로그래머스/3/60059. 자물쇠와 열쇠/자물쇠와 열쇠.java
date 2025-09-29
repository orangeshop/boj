import java.util.*;

class Solution {
    
    static int N,M;
    
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        M = key.length;
        N = lock.length;
        
        for(int i = 0; i < 4; i++){
            for(int k = -M; k < N; k++){
                for(int j = -M; j < N; j++){
                    if (solve(key, lock, k, j)) return true;
                }
            }
            
            key = rotate(key);
        }
        
        return false;
    }
    
    static boolean solve(int[][] key, int[][] lock, int x, int y){
        for(int i =0; i < N; i++){
            for(int k =0; k < N; k++){
                int nx = i - x;
                int ny = k - y;
                int v;
                
                if(nx < 0 || nx >= M || ny < 0 || ny >= M) v = 0;
                else v = key[nx][ny];
                if(lock[i][k] == v) return false;
            }
        }
        
        return true;
    }
    
    
    static int[][] rotate(int[][] key){
        int[][] tkey = new int[M][M];
        
        for(int i =0; i < M; i++){
            for(int k = 0; k < M; k++){
                tkey[k][M-1-i] = key[i][k];
            }
        }
        
        return tkey;
    }
}