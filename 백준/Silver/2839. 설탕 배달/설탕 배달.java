import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] dp = new int[5010];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());


        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[3] = 1;
        dp[5] = 1;
        
        if(N == 3){
            System.out.println(1);
            return;
        }

        if(N < 5){
            System.out.println(-1);
            return;
        }

        for(int i = 6; i <= N; i++) {
            if(dp[i-3] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i-3]+1);
            }

            if(dp[i-5] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i-5]+1);
            }
        }
//        System.out.println(Arrays.toString(dp));
        if(dp[N] != Integer.MAX_VALUE) {
            System.out.println(dp[N]);
        }else{
            System.out.println(-1);
        }


    }
}
