import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] arr;
    static int[] dp;

    static ArrayList<Integer> ls = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        dp[0] = 1;
        int maxSize = 1;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxSize = Math.max(maxSize, dp[i]);
                }
            }
        }

        System.out.println(maxSize);

        for(int i = N -1; i >= 0; i--) {
            if(dp[i] == maxSize) {
                ls.add(arr[i]);
                maxSize--;
            }
        }

        ls.sort(Integer::compareTo);

        ls.forEach(integer -> System.out.print(integer + " "));

    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        arr = new int[N];
        dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

    }
}
