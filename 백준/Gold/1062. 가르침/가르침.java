import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K, answer;
    static String[] arr;

    static int word;

    public static void main(String[] args) throws IOException {
        init();
        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        } else {
            solution();
            System.out.println(answer);
            return;
        }
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        word |= 1 << ('a' - 'a');
        word |= 1 << ('c' - 'a');
        word |= 1 << ('i' - 'a');
        word |= 1 << ('n' - 'a');
        word |= 1 << ('t' - 'a');

        arr = new String[N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            arr[i] = str.substring(4, str.length() - 4);
        }
    }

    private static void solution() {

        dfs(0, 0, word);
    }

    private static void dfs(int depth, int st, int ll) {
        if (depth == K - 5) {
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                boolean vis = true;

                for (int j = 0; j < arr[i].length(); j++) {
                    if ((ll & 1 << (arr[i].charAt(j) - 'a')) == 0) {
                        vis = false;
                        break;
                    }
                }
                if (vis) {
                    cnt++;
                }
            }

            answer = Math.max(answer, cnt);
            return;
        }

        for (int i = st; i < 26; ++i) {
            if ((ll & 1 << i) != 0) continue;
            dfs(depth + 1, i + 1, ll | 1 << i);
        }
    }
}
