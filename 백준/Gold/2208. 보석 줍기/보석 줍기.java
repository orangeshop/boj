

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M; 
    static long answer;
    static int[] arr = new int[100001];
    static long[] prefix = new long[100001];
    static long[] dp = new long[100001];

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
        /*
        * 줍는다 안줍는다 판단
        *
        *
        *
        * */

        dp[M] = prefix[M];

        for(int i = M + 1; i <= N; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i], prefix[i] - prefix[i-M]);
        }

        for(int i =M; i < dp.length; i++) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);

    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            prefix[i] = prefix[i-1] + arr[i];
        }
    }
}
