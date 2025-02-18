import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static ArrayList<Pair> arr = new ArrayList<>();
    static int[] dp;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        int max = 0;
        for(int i = 0; i < N; i++){
            int a = arr.get(i).x;
            int b = arr.get(i).y;

            if(max < dp[i]){
                max = dp[i];
            }

            if(a + i <= N){
                dp[a + i] = Math.max(dp[a + i], b + max);
            }
        }
        
        System.out.println(Arrays.stream(dp).max().getAsInt());

//        System.out.println(Arrays.toString(dp));
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        dp = new int[N+1];



        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.add(new Pair(a, b));
        }


    }
}
