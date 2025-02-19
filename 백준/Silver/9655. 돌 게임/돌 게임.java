import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[][] dp = new int[2][1005];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 1005; j++) {
                dp[i][j] = -1;
            }
        }

        dp[0][N] = N;
        /*
        * 5
        *
        * 4
        * 2
        *
        *
        * */

        for(int i = N; i >= 0; i--) {
            if(dp[0][i] > 0) {
                
                if(i - 1 >= 0) {
                    dp[1][i - 1] = dp[0][i] - 1;
                }

                if(i - 3 >= 0) {
                    dp[1][i - 3] = dp[0][i] - 3;
                }
                if(dp[1][0] == 0){
                    System.out.println("SK");
                    break;
                }
            }

            if(dp[1][i] > 0) {
                
                if(i - 1 >= 0) {
                    dp[0][i - 1] = dp[1][i] - 1;
                }
                if(i - 3 >= 0) {
                    dp[0][i - 3] = dp[1][i] - 3;
                }

                if(dp[0][0] == 0){
                    System.out.println("CY");
                    break;
                }
            }

           

        }
    }
}
