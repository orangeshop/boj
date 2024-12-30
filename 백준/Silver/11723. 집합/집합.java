
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    static int N;

    static int answer;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String a = st.nextToken();


            if (a.equals("add")) {
                int b = Integer.parseInt(st.nextToken());
                answer |= (1 << (b - 1));
            }

            if (a.equals("check")) {
                int b = Integer.parseInt(st.nextToken());
//                System.out.println((answer >> (b - 1)) & 1);
                sb.append((answer >> (b - 1)) & 1).append("\n");
            }

            if (a.equals("remove")) {
                int b = Integer.parseInt(st.nextToken());
                answer &= (~(1 << (b - 1)));
            }

            if (a.equals("toggle")) {
                int b = Integer.parseInt(st.nextToken());
                answer ^= (1 << (b - 1));
            }

            if (a.equals("all")) {
                answer = 0xfffff;
            }

            if (a.equals("empty")) {
                answer = 0;
            }
        }

        System.out.println(sb);
    }
}
