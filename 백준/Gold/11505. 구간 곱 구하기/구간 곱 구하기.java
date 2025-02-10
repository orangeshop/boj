import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static final long div = 1_000_000_007;
    static int N, M, K;

    static int[] arr;
    static long[] Tree;

    static void init(int node, int s, int e) {
        if (s == e) {
            Tree[node] = arr[s];
            return;
        }

        int mid = (s + e) / 2;

        init(node * 2, s, mid);
        init(node * 2 + 1, mid + 1, e);
        Tree[node] = (Tree[node * 2] * Tree[node * 2 + 1]) % div;
    }

    static long query(int node, int s, int e, int l, int r) {
        if (e < l || s > r) {
            return 1;
        }

        if (l <= s && e <= r) {
            return Tree[node];
        }

        int mid = (s + e) / 2;

        long x = query(node * 2, s, mid, l, r);
        long y = query(node * 2 + 1, mid + 1, e, l, r);

        return (x * y) % div;
    }

    static void update(int node, int s, int e, int idx, int val) {
        if (idx < s || e < idx) {
            return;
        }

        if (s == e) {
            Tree[node] = val;
            return;
        }

        int mid = (s + e) / 2;

        update(node * 2, s, mid, idx, val);
        update(node * 2 + 1, mid + 1, e, idx, val);
        Tree[node] = (Tree[node * 2] * Tree[node * 2 + 1]) % div;
    }

    public static void main(String[] args) throws IOException {
        input();
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Tree = new long[N * 4];
        Arrays.fill(Tree, 1);
        arr = new int[N +1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        init(1, 1, N);



        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                update(1, 1, N, b, c);
            } else {
                System.out.println(query(1, 1, N, b, c));
            }

//            System.out.println(Arrays.toString(Tree));
        }
    }
}
