import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T;
    static long[] Tree;

    static void init(int node, int s, int e) {
        if (s == e) {
            return;
        }

        int mid = (s + e) / 2;

        init(node * 2, s, mid);
        init(node * 2 + 1, mid + 1, e);
        Tree[node] = Tree[node * 2] + Tree[node * 2 + 1];
    }

    static long query(int node, int s, int e, int l, int r) {
        if (e < l || s > r) {
            return 0;
        }

        if (l <= s && e <= r) {
            return Tree[node];
        }

        int mid = (s + e) / 2;
        long x = query(node * 2, s, mid, l, r);
        long y = query(node * 2 + 1, mid + 1, e, l, r);
        return x + y;
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
        Tree[node] = Tree[node * 2] + Tree[node * 2 + 1];
    }

    public static void main(String[] args) throws IOException {

        input();
        solve();


        System.out.println(sb.toString());
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        int b, p;
        b = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        Tree = new long[b * 4];
        Arrays.fill(Tree, 1);
        init(1,1,b);

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();


            if (s.equals("A")) {
                int a = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                sb.append(query(1, 1, b, a, c));
                sb.append("\n");
            } else {
                int a = Integer.parseInt(st.nextToken());
                update(1, 1, b, a, 0);
            }

        }
    }

    private static void solve() {

    }


}
