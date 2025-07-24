

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,K;
    static int ans;

    static int[][] dp = new int[1005][1005];
    static final int mod = 1_000_000_003;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());


        solution();

        System.out.println(ans);
    }

    private static void solution() {
        for(int i=1; i<1005; i++) {
            dp[i][1] = i;
        }

        for(int i=2; i<1005; i++) {
            for(int j=2; j<=K; j++) {
                if(j > i/2) break;
                dp[i][j] = (dp[i-1][j] + dp[i-2][j-1]) % mod;
            }
        }

        ans = dp[N][K];
    }
}
