import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] dp;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        dp = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;

//        System.out.println(Arrays.toString(dp));

        for (int i = n; i >= 1; i--) {
            if (i % 3 == 0) {
                dp[i / 3] = Math.min(dp[i] + 1, dp[i / 3]);
            }
            if (i % 2 == 0) {
                dp[i / 2] = Math.min(dp[i] + 1, dp[i / 2]);
            }

            dp[i - 1] = Math.min(dp[i] + 1, dp[i - 1]);
        }

        System.out.println(dp[1]);

    }
}
