import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;

    static long[] arr;

    static long[] minTree;
    static long[] maxTree;

    static void init(int node, int s, int e) {
        if (s == e) {
            maxTree[node] = arr[e];
            minTree[node] = arr[e];
            return;
        }

        int mid = (s + e) / 2;
        init(node * 2, s, mid);
        init(node * 2 + 1, mid + 1, e);

        maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
        minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
    }

    static long query(int node, int s, int e, int l, int r, int type) {
        if (e < l || s > r) {
            if (type == 1) {
                return Long.MIN_VALUE;
            } else {
                return Long.MAX_VALUE;
            }
        }

        if (l <= s && e <= r) {
            if (type == 1) {
                return maxTree[node];
            } else {
                return minTree[node];
            }
        }
        int mid = (s + e) / 2;
        long x = query(node * 2, s, mid, l, r, type);
        long y = query(node * 2 + 1, mid + 1, e, l, r, type);

        if (type == 1) {
            return Math.max(x, y);
        } else {
            return Math.min(x, y);
        }
    }

//    static void update(int node, int s, int e, int idx, int val) {
//        if (idx < s || e < idx) {
//            return;
//        }
//
//        if (s == e) {
//            maxTree[node] = val;
//            minTree[node] = val;
//            return;
//        }
//
//        int mid = (s + e) / 2;
//        update(node * 2, s, mid, idx, val);
//        update(node * 2 + 1, mid + 1, e, idx, val);
//
//        maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
//        minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
//    }

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

        arr = new long[N * 4];
        maxTree = new long[N * 4];
        minTree = new long[N * 4];




        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Long.parseLong(st.nextToken());

        }

        init(1, 1, N);

//        System.out.println(Arrays.toString(maxTree));
//        System.out.println(Arrays.toString(minTree));


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(query(1, 1, N, a, b, -1));
        }
    }
}
