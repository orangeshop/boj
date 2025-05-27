import java.util.*;
import java.math.*;

class Solution{
    
    public static int[][] dp;
    public static int answer = 0;
    
    
    public int solution(int [][]board){
    
        int n = board.length;
        int m = board[0].length;
        
        dp = new int[n+1][m+1];
        
        for(int i =1; i <= n; i++){
            for(int k = 1; k <= m; k++){
                if(board[i-1][k-1] != 0){
                    int len = Math.min(Math.min(dp[i-1][k], dp[i][k-1]), dp[i-1][k-1]);
                    dp[i][k] = len + 1;
                    
                }
            }
        }
    
        
        for(int i =0; i <= n; i++){
            for(int k =0; k <= m; k++){
                // System.out.print(dp[i][k] + " ");
                
                answer = Math.max(answer, dp[i][k]);
            }
            // System.out.println();
        }

        return answer * answer;
    }
}

/*
0 0 0 0
0 0 2 2
0 2 2 3



*/