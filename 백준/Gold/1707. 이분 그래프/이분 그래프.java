import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int K;

    static ArrayList<Integer>[] ls;
    static boolean[] vis;


    static ArrayList<String> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i));
            if (i != ans.size() - 1) {
                System.out.println();
            }
        }
    }

    private static String solution(int a) {

        int[] cnt = new int[a + 1];
        boolean[] subVis = new boolean[a + 1];

        Arrays.fill(cnt, 0);

        for (int j = 1; j <= a; j++) {
            if(cnt[j] == 0) {
                ArrayDeque<Integer> Q = new ArrayDeque<>();
                Q.add(j);
                cnt[j] = 1;

                while (!Q.isEmpty()) {
                    Integer cur = Q.poll();

                    for (int nxt : ls[cur]) {
                        if(cnt[nxt] == 0){
                            Q.add(nxt);
                            cnt[nxt] = -1 * cnt[cur];
                        } else if (cnt[cur] == cnt[nxt]) {
                            return "NO";
                        }


                    }
                }
            }
        }

        return "YES";
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ls = new ArrayList[a + 1];

            for (int j = 0; j <= a; j++) {
                ls[j] = new ArrayList<>();
            }

            vis = new boolean[a + 1];

            for (int j = 0; j < b; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                ls[u].add(v);
                ls[v].add(u);
                vis[u] = true;
            }

            ans.add(solution(a));
        }
    }
}
