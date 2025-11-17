import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, D;

    static int[] dp;
    static List<List<int[]>> graph = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        dp = new int[D+1];

        for (int i = 0; i <= D; i++) {
            dp[i] = i;
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (b <= D) {
                graph.get(a).add(new int[]{b, c});
            }
        }

        for (int i = 0; i <= D; i++) {
            if (i > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            }
            
            for(int[] nxt : graph.get(i)) {
                int end = nxt[0];
                int dist = nxt[1];
                
                if(dp[end] > dp[i] + dist){
                    dp[end] = dp[i] + dist;
                }
            }
        }

        System.out.println(dp[D]);

    }
}
