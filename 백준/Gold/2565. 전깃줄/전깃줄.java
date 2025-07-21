import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, ans;
    static int[] dp;

    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static List<Pair> ls = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        dp = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ls.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        ls.sort((o1, o2) -> {
            return o1.x - o2.x;
        });

//        for(int i = 0; i < ls.size(); i++) {
//            System.out.println(ls.get(i).x + " " + ls.get(i).y);
//        }


        Arrays.fill(dp, 1);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(ls.get(i).y > ls.get(j).y) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for(int i = 0; i < N; i++) {
            ans = Math.max(dp[i], ans);
        }

        System.out.println(N-ans);
    }
}
