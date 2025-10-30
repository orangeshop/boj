import java.util.*;

class Solution {
    static int answer = 0;
    static ArrayDeque<Integer> adj[];    
    
    static int[][] board;
    
    public int solution(int n, int w, int num) {
        
        int h = n % w == 0 ? (n/w) : (n/w)+1; 
        System.out.println(h);
        adj = new ArrayDeque[h];
        
        board = new int[h][w];
        
        for(int i =0; i < h; i++){
            adj[i] = new ArrayDeque<>();
        }
        
        
        int idx = 0;
        for(int i = 1; i <= n; i++){
            if(idx % 2 == 0){
                adj[idx].add(i);
            }else{
                adj[idx].addFirst(i);
            }
            
            if(i % w == 0){
                idx++;
            }
        }
        
        if(idx >= h){
            idx--;
        }
        int size = adj[idx].size();
        if(idx % 2 == 0){
            for(int i = 0; i < w - size; i++){
                adj[idx].add(0);
            }
        }else{
            for(int i = 0; i < w - size; i++){
                adj[idx].addFirst(0);
            }
        }
        
        for(int i =0; i < h; i++){
            for(int k =0; k < w; k++){
                board[i][k] = adj[i].removeFirst();
            }
        }
        
        for(int i =0; i < h; i++){
            for(int k =0; k < w; k++){
                // System.out.print(board[i][k] + " ");
                if(board[i][k] == num){
                    for(int j = i; j < h; j++){
                        if(board[j][k] == 0){
                            break;
                        }
                        answer++;
                        // System.out.println(j + " " + k);
                    }
                }
            }
            // System.out.println();
        }
        
        return answer;
    }
}