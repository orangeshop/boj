import java.util.*;

class Solution {
    static final int INF = Integer.MAX_VALUE - 1000000;
    static int[][] dp; // dp[time][temp] = k : time은 시간, temp는 현재 온도, k는 전기세 
    
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        
        int[] tBoard = new int[onboard.length + 1];
        
        for(int i = 1; i < onboard.length + 1; i++){
            tBoard[i] = onboard[i-1];
        }
        
        int N = tBoard.length;
        int base = 11;
        temperature += base;
        t1 += base;
        t2 += base;
        
        dp = new int[N][55];
        
        for(int i =0; i < N; i++){
            for(int k =0; k < 55; k++){
                dp[i][k] = INF;
            }
        }
        
        dp[0][temperature] = 0;
        
        System.out.println(Arrays.toString(tBoard));
        
        for(int time =1; time < N; time++){
            
            int left, right;
            
            if(tBoard[time] == 0){
                left = 1;
                right = 51;
            }else{
                left = t1;
                right = t2;
            }
            
            for(int temp = left; temp <= right; temp++){
               
                
                // 에어컨 온도가 내려갈 때 경우
                // 현재 온도가 실외 온도보다 클 때
                if(temp - 1 < temperature){
                    // 에어컨 끔
                    dp[time][temp] = Math.min(dp[time][temp], dp[time - 1][temp-1]);
                }else{
                    // 에어컨 킴
                    dp[time][temp] = Math.min(dp[time][temp], dp[time - 1][temp-1] + a);
                }
                
                
                if(temp == temperature){
                    // 에어컨 끔
                    dp[time][temp] = Math.min(dp[time][temp], dp[time - 1][temp]);
                }else{
                    // 에어컨 킴
                    dp[time][temp] = Math.min(dp[time][temp], dp[time - 1][temp] + b);
                }
                
                // 에어컨 온도가 올가갈 경우
                // 현재 온도가 temperature보다 작아야함
                if(temp + 1 > temperature){
                    // 에어컨 끔
                    dp[time][temp] = Math.min(dp[time][temp], dp[time - 1][temp + 1]);
                }else{
                    // 에어컨 킴
                    dp[time][temp] = Math.min(dp[time][temp], dp[time - 1][temp + 1] + a);
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        
        // for(int k = 0; k < N; k++){
        //     for(int i =0; i < 55; i++){
        //         System.out.print(dp[k][i] + " ");
        //     }
        //     System.out.println();
        // }
        
        for(int i =0; i < 55; i++){
            answer = Math.min(answer, dp[N-1][i]);
        }
        
        return answer;
    }
}