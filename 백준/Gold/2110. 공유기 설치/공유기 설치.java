import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int N, M, answer;
    public static List<Integer> ls = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        ls.sort(Comparator.comparingInt(o -> o));

        long l = 1;
        long r = ls.get(N-1) - ls.get(0) + 1;

        while (l < r) {
            long mid = (l + r) / 2;

//            System.out.println(l + " " + r);

            if (calc(mid) < M) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }


        System.out.println(l-1);
    }

    private static long calc(long mid) {
        int num = 1;
        int last = ls.get(0);

        for (int i = 1; i < N; i++) {
            int loc = ls.get(i);

            if (loc - last >= mid) {
                num++;
                last = loc;
            }
        }

        return num;
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
