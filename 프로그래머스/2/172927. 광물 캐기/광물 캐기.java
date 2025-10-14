import java.util.*;
import java.math.*;


class Solution {
    
    static int answer = Integer.MAX_VALUE;
    static int[] arr = new int[15];
    static int pickSize = 0;
    static int mineralsSize = 0;
    static int[] picksTmp = new int[3];
    static String[] mineralsTmp;
     
    
    static int[][] mineBoard = {{1,1,1},{5,1,1},{25,5,1}};
    
    public int solution(int[] picks, String[] minerals) {
        
        for(int i =0; i < picks.length; i++){
            picksTmp[i] = picks[i];
        }
        
        pickSize = picks.length;
        mineralsSize = minerals.length;
        
        mineralsTmp = new String[minerals.length];
        
        for(int i =0; i < minerals.length; i++){
            mineralsTmp[i] = minerals[i];
        }

        Arrays.fill(arr, -1);
        
        solve();
        return answer;
    }
    
    public static void dfs(int depth, int stone, int iron, int dia){
        /*
        minerals가 최대 50
        
        곡괭이 하나당 5
        
        즉 depth가 10
        
        곡괭이를 다 쓰거나 or 곡괭이 * 5의 값이 미내랄의 개수보다 커질 경우
        
        3이 돌
        2가 철
        1이 다이야
        
        */
        
        if((stone == picksTmp[2] && iron == picksTmp[1] && dia == picksTmp[0]) || depth * 5 >= mineralsSize){
            
            int result = 0;
            int idx = 0;
            
            for(int i =0; i < mineralsSize; i++){
                if(i > 0 && i % 5 == 0){ 
                    idx++;
                }
                if(arr[idx] == -1) break;
                
                int num = 0;
                if(mineralsTmp[i].equals("diamond")) num = 0;
                if(mineralsTmp[i].equals("iron")) num = 1;
                if(mineralsTmp[i].equals("stone")) num = 2;
                
                result += mineBoard[arr[idx]][num];   
            }
            answer = Math.min(result, answer);
            
            return;
        }
        
        if(stone < picksTmp[2]){
            arr[depth] = 2;
            dfs(depth + 1, stone + 1, iron, dia);
            arr[depth] = -1;
        }
        
        if(iron < picksTmp[1]){
            arr[depth] = 1;
            dfs(depth + 1, stone, iron + 1, dia);
            arr[depth] = -1;
        }
        
        if(dia < picksTmp[0]){
            arr[depth] = 0;
            dfs(depth + 1, stone, iron, dia + 1);
            arr[depth] = -1;
        }    
    }
    
    
    
    public static void solve(){
        dfs(0,0,0,0);
    }
    
}