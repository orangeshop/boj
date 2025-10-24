import java.util.*;

class Solution {
    
    
    static int M, N, answer = 0;;
    static int[][] gBoard;
    
    static Map<String, Integer> map = new HashMap<>();
    static ArrayDeque<Pair> rm = new ArrayDeque<>();
    
    static class Pair{
        int x;
        int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int m, int n, String[] board) {
        N = m;
        M = n;
        gBoard = new int[N][M];
        init();
        
        for(int i =0; i < N; i++){
            String str = board[i];
            // System.out.println(str);
            for(int k =0; k < M; k++){
                // System.out.println(map.get(str.charAt(k)+""));
                gBoard[i][k] = map.get(str.charAt(k)+""); 
            }
        }
        

        for(;;){
            // if(cnt == 2) break;
            int result = remove();
            if(result == 0) break;
            downBlock();
        }
        
       
        
        for(int i =0; i < N; i++){
            for(int k =0; k < M; k++){
                // System.out.print(gBoard[i][k] + " ");
                if(gBoard[i][k] == 0) answer++;
            }
            // System.out.println();
        }
        
        return answer;
    }
    
    static int remove(){
        for(int i =0; i < N-1; i++){
            for(int k =0; k < M-1; k++){
                int cur = gBoard[i][k];
                if(cur == 0) continue;
                if(gBoard[i][k + 1] == cur && gBoard[i + 1][k] == cur && gBoard[i + 1][k + 1] == cur){
                    rm.add(new Pair(i,k));
                    rm.add(new Pair(i + 1,k));
                    rm.add(new Pair(i,k + 1));
                    rm.add(new Pair(i + 1,k + 1));
                }
            }
        }
        int s = rm.size();
        
        while(!rm.isEmpty()){
            Pair cur = rm.removeFirst();
            gBoard[cur.x][cur.y] = 0;
        }
        
        return s;
    }
    
    static void downBlock(){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i =0; i < M; i++){
            
            for(int k = N -1; k >= 0; k--){
                if(gBoard[k][i] == 0) continue;
                q.add(gBoard[k][i]);
            }
            
            for(int k =0; k < N; k++){
                gBoard[k][i] = 0;
            }
            
            int idx = N-1;
            while(!q.isEmpty()){
                Integer cur = q.removeFirst();
                gBoard[idx][i] = cur;
                idx--;
            }
        }
    }
    
    static void init(){
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        map.put("E", 5);
        map.put("F", 6);
        map.put("G", 7);
        map.put("H", 8);
        map.put("I", 9);
        map.put("J", 10);
        map.put("K", 11);
        map.put("L", 12);
        map.put("M", 13);
        map.put("N", 14);
        map.put("O", 15);
        map.put("P", 16);
        map.put("Q", 17);
        map.put("R", 18);
        map.put("S", 19);
        map.put("T", 20);
        map.put("U", 21);
        map.put("V", 22);
        map.put("W", 23);
        map.put("X", 24);
        map.put("Y", 25);
        map.put("Z", 26);
        
        
    }
}