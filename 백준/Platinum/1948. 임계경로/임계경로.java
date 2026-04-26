import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static List<Pair>[] adj;
    static List<Pair>[] radj;

    static int[] inDegree;
    static int[] rinDegree;

    static int[] distance;
    static int[] rdistance;

    static int N, M, S, E;

    static int ansOne = 0;
    static int ansTwo = 0;

    public static void main(String[] args) throws IOException {
        init();
        solution();


        System.out.println(ansOne);
        System.out.println(ansTwo);
    }

    private static void solution() {
        ArrayDeque<Integer> q = new ArrayDeque<>();

        q.add(S);

        while (!q.isEmpty()) {
            int cur = q.removeFirst();
            for (Pair nxt : adj[cur]) {
                inDegree[nxt.y]--;
                if (inDegree[nxt.y] == 0) {
                    q.add(nxt.y);
                }
                distance[nxt.y] = Math.max(distance[nxt.y], distance[cur] + nxt.x);
            }
        }

        ansOne = distance[E];

        q.clear();

        q.add(E);

        while (!q.isEmpty()) {
            int cur = q.removeFirst();
            for (Pair nxt : radj[cur]) {
                rinDegree[nxt.y]--;
                if (rinDegree[nxt.y] == 0) {
                    q.add(nxt.y);
                }

                if ((rdistance[cur] + nxt.x) + distance[nxt.y] == ansOne) {
                    ansTwo++;
                }

                rdistance[nxt.y] = Math.max(rdistance[nxt.y], rdistance[cur] + nxt.x);
            }
        }
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        adj = new List[N + 1];
        radj = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            adj[i] = new ArrayList<>();
            radj[i] = new ArrayList<>();
        }
        inDegree = new int[N + 1];
        rinDegree = new int[N + 1];

        distance = new int[N + 1];
        rdistance = new int[N + 1];


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new Pair(c, b));
            radj[b].add(new Pair(c, a));
            inDegree[b]++;
            rinDegree[a]++;
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
