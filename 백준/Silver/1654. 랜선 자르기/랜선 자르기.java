import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int N, M;

    public static List<Integer> ls = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {
        input();

        ls.sort((o1, o2) -> {
            return o1 - o2;
        });

        long l = 0;
        long r = ls.get(N - 1);

        long answer = 0;

        int t = 0;
        for (int i = 0; i < N; i++) {
            t += ls.get(i) / r;
        }

        if (t >= M) {
            answer = Math.max(answer, r);
        }

        while (l < r) {
            long mid = (l + r) / 2;
            int result = 0;

            if(mid == 0) break;

            for (int i = 0; i < N; i++) {
                result += ls.get(i) / mid;
            }

            if (result >= M) {
                answer = Math.max(answer, mid);
            }

            if (result < M) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(answer);

    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ls.add(Integer.parseInt(st.nextToken()));
        }
    }
}