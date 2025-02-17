import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;

    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        dp = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        /*
        * 1
        * 1 1
        * 2 2
        * 3 3
        * 4 4
        * dp[i] = max(dp[i], dp[i - j] + arr[j])
        *
        * 2
        * 2 5
        * 3 6
        * 4 10
        *
        * 3
        * 3 6
        * 4 7
        *
        * 4
        * 4 7
        *
        *
        *
        * */

        for(int i = 1; i <= N; i++) {
            for(int j = i; j <= N; j++) {
//                System.out.println(i + " " + j + " " + arr[j]);
                dp[j] = Math.max(dp[j], dp[j-i] + arr[i]);
            }

//            System.out.println(Arrays.toString(dp));
        }

        System.out.println(dp[N]);
    }
}
