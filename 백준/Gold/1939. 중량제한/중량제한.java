
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, answer, S, E;

    static List<Pair> ls = new ArrayList<>();


    static int[] p;
    static int[] size;


    static int find(int x) {
        if (p[x] == x) {
            return x;
        }

        return p[x] = find(p[x]);
    }

    static void union(int x, int y) {

        int a = find(x);
        int b = find(y);

        if (a == b) return;

        if (size[a] >= size[b]) {
            p[b] = a;
            size[a] += size[b];
        } else {
            p[a] = b;
            size[b] += size[a];
        }
    }


    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(answer);
    }

    private static void solution() {
        ls.sort((o1, o2) -> {
            return o2.c - o1.c;
        });

        for(int i = 0; i <= N; i++) {
            p[i] = i;
            size[i] = 1;
        }

        for (Pair l : ls) {
            union(l.a, l.b);
            if (find(S) == find(E)) {
                answer = l.c;
                return;
            }
        }

    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        p = new int[N + 1];
        size = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            ls.add(new Pair(a, b, c));
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());


    }

    static int calc(int x, int y) {
        return N * x + y;
    }

    static class Pair {
        int e, v;
        int a, b, c;

        public Pair(int e, int v) {
            this.e = e;
            this.v = v;
        }

        public Pair(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
