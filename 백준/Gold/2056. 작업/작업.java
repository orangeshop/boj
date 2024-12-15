import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;

    static List<Pair>[] adj;
    static int[] inDegree;
    static int[] timeArr;
    static int answer;

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        solution();

        System.out.print(answer);
    }

    private static void solution() {

        ArrayDeque<Integer> Q = new ArrayDeque<>();
        int[] result = new int[N + 1];
        for (int i = 1; i <= N; i++) {

            result[i] = timeArr[i];

            if (inDegree[i] == 0) {
                Q.add(i);
            }
        }

        while (!Q.isEmpty()) {
            int cur = Q.poll();

            for (Pair nxt : adj[cur]) {
                int time = nxt.x;
                int nxtNode = nxt.y;

                inDegree[nxtNode]--;
                result[nxtNode] = Math.max(result[nxtNode], result[cur] + timeArr[nxtNode]);

                if (inDegree[nxtNode] == 0) {
                    Q.add(nxtNode);
                }
            }

        }

        for(int i=1;i<=N;i++) {
            answer = Math.max(answer, result[i]);
        }
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        adj = new List[N + 1];

        for (int i = 0; i < N + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        inDegree = new int[N + 1];
        timeArr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            timeArr[i] = a;
            for (int j = 0; j < b; j++) {
                int c = Integer.parseInt(st.nextToken());
                adj[c].add(new Pair(a, i));
                inDegree[i]++;
            }
        }
    }
}
