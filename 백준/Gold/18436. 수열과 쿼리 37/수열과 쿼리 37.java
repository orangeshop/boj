import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;

    static int[] arr;

    static Pair[] Tree;

    static class Pair {
        long x, y;

        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
    }

    static void init(int node, int s, int e) {
        if (s == e) {
            if (arr[s] % 2 == 0) {
                Tree[node].x = 1;
                Tree[node].y = 0;
            } else {
                Tree[node].x = 0;
                Tree[node].y = 1;
            }
            return;
        }

        int mid = (s + e) / 2;
        init(node * 2, s, mid);
        init(node * 2 + 1, mid + 1, e);

        Tree[node].x = Tree[node * 2].x + Tree[node * 2 + 1].x;
        Tree[node].y = Tree[node * 2].y + Tree[node * 2 + 1].y;

    }

    static Pair query(int node, int s, int e, int l, int r) {
        if (e < l || s > r) {
            return new Pair(0, 0);
        }

        if (l <= s && e <= r) {
            return Tree[node];
        }

        int mid = (s + e) / 2;

        Pair first = query(node * 2, s, mid, l, r);
        Pair second = query(node * 2 + 1, mid + 1, e, l, r);
        return new Pair(first.x + second.x, first.y + second.y);
    }

    static void update(int node, int s, int e, int idx, int val) {
        if (idx < s || e < idx) {
            return;
        }

        if (s == e) {
            if (val % 2 == 0) {
                Tree[node].x = 1;
                Tree[node].y = 0;
            } else {
                Tree[node].x = 0;
                Tree[node].y = 1;
            }
            return;
        }

        int mid = (s + e) / 2;
        update(node * 2, s, mid, idx, val);
        update(node * 2 + 1, mid + 1, e, idx, val);

        Tree[node].x = Tree[node * 2].x + Tree[node * 2 + 1].x;
        Tree[node].y = Tree[node * 2].y + Tree[node * 2 + 1].y;
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        arr = new int[N * 4];
        Tree = new Pair[N * 4];

        for (int i = 0; i < N * 4; i++) {
            Tree[i] = new Pair(0, 0);
        }

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        init(1, 1, N);

        
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                update(1, 1, N, b, c);
            } else if (a == 2) {
                Pair p = query(1, 1, N, b, c);
                System.out.println(p.x);
            } else {
                Pair p = query(1, 1, N, b, c);
                System.out.println(p.y);
            }


        }
    }
}
