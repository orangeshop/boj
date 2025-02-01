
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;

    static long[] Tree;

    static void init(int node, int s, int e) {
        if (s == e) {
            Tree[node] = s;
            return;
        }

        int mid = (s + e) / 2;

        init(node * 2, s, mid);
        init(node * 2 + 1, mid + 1, e);

        Tree[node] = Tree[node * 2] + Tree[node * 2 + 1];
    }

    static long query(int node, int s, int e, int i, int j) {
        if (e < i || s > j) {
            return 0;
        }

        if (i <= s && e <= j) {
            return Tree[node];
        }

        int mid = (s + e) / 2;
        long l = query(node * 2, s, mid, i, j);
        long r = query(node * 2 + 1, mid + 1, e, i, j);

        return l + r;
    }

    static void update(int node, int s, int e, int idx, int val) {
        if (idx < s || idx > e) {
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
        solution();
    }

    private static void solution() {
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Tree = new long[N * 5];
//        System.out.println(Arrays.toString(Tree));
////        init(1, 1, N);
//        System.out.println(Arrays.toString(Tree));
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {

                update(1, 1, N, b, c);
            } else {
                if (b > c){
                    int temp = b;
                    b = c;
                    c = temp;
                }
                System.out.println(query(1, 1, N, b, c));
            }

//            System.out.println(Arrays.toString(Tree));
        }
    }
}
