import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;

    static int[] dp = new int[1_000_005];

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        /*
        * 00
        *
        * 00 1
        * 11 1
        * 1 00
        *
        *
        *
        * */

        dp[4] = 5;

        for(int i =5; i <= N; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
        }

        System.out.println(dp[N]);

    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

    }
}
