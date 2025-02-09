import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    static final int SIZE = 1_000_001;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] Tree;

    static void init(int node, int s, int e) {
        if (s == e) {
            Tree[node] = e;
            return;
        }

        int mid = (s + e) / 2;

        init(node * 2, s, mid);
        init(node * 2 + 1, mid + 1, e);

        Tree[node] = Tree[node * 2] + Tree[node * 2 + 1];
    }

    static long query(int node, int s, int e, int t) {

        if (s == e) {
            update(1, 1, SIZE, -1, s);
            return s;
        }

        int mid = (s + e) / 2;

        if (t <= Tree[node * 2]) {
            return query(node * 2, s, mid, t);
        } else {
            return query(node * 2 + 1, mid + 1, e, t - Tree[node * 2]);
        }

    }

    static void update(int node, int s, int e, int val, int idx) {
        if (idx < s || idx > e) {
            return;
        }

        Tree[node] += val;
        if (s == e) {
            return;
        }

        int mid = (s + e) / 2;
        update(node * 2, s, mid, val, idx);
        update(node * 2 + 1, mid + 1, e, val, idx);
//        Tree[node] = Tree[node * 2] + Tree[node * 2 + 1];
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        Tree = new int[SIZE * 4];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 1) {
                int b = Integer.parseInt(st.nextToken());
                System.out.println(query(1, 1, SIZE, b));
            } else {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                update(1, 1, SIZE, c, b);
            }

//            System.out.println(Arrays.toString(Tree));
        }
    }
}
