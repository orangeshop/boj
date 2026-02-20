import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static long N, M;

    static long[] arr;
    static long sum = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        arr = new long[(int) N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sum += Long.parseLong(st.nextToken());
            arr[i] = sum;
        }

        st = new StringTokenizer(br.readLine());
        M = Long.parseLong(st.nextToken());

        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken()) - 2;
            long b = Long.parseLong(st.nextToken()) - 1;

            if (a < 0) {
                sb.append((arr[(int) b]) + "\n");
            } else {
                sb.append((arr[(int) b] - arr[(int) a]) + "\n");
            }
        }

        System.out.println(sb.toString());
    }
}
