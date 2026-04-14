import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static final int max = 1105;

    static int C,N;
    static int[] cost;
    static int[] weight;

    static int[] dp; // [인원] = 비용?

    public static void main(String[] args) throws IOException {
        input();

        dp = new int[max];

        Arrays.fill(dp, Integer.MAX_VALUE - 1000000);

        dp[0] = 0;

        for(int i =0; i < N; i++){
            dp[weight[i]] = cost[i];
        }

        for(int w =0; w < max; w++){
//            System.out.println(w);
            for(int i =0; i < N; i++){
                if(w - weight[i] < 0) continue;
//                if(dp[c - weight[i]] == Integer.MAX_VALUE) continue;

                dp[w] = Math.min(dp[w], dp[w - weight[i]] + cost[i]);


            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i = C; i < max; i++){
            answer  = Math.min(answer, dp[i]);
        }

        System.out.println(answer);

//        System.out.println(Arrays.toString(dp));

    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        cost = new int[N];
        weight = new int[N];

        for(int i =0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());

        }

    }
}
