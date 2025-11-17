import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] dp = new int[1000001];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            int v = Integer.MAX_VALUE;
            int j = 1;

            while (true) {
                int h = j * (2 * j - 1);
                if (h > i) break;
                v = Math.min(v, dp[i - h]);
                j++;
            }

            dp[i] = v + 1;
        }

        System.out.println(dp[N]);

    }
}
