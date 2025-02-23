import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, Q;

    static long[] TreeMax;
    static long[] TreeMin;

    static int[] arr;


    static void initMax(int node, int s, int e) {
        if (s == e) {
            TreeMax[node] = Math.max(TreeMax[node], arr[e]);

            return;
        }

        int mid = (s + e) / 2;
        initMax(node * 2, s, mid);
        initMax(node * 2 + 1, mid + 1, e);
        TreeMax[node] = Math.max(TreeMax[node * 2], TreeMax[node * 2 + 1]);
    }

    static void initMin(int node, int s, int e) {
        if (s == e) {
            TreeMin[node] = Math.min(TreeMin[node], arr[e]);

            return;
        }

        int mid = (s + e) / 2;
        initMin(node * 2, s, mid);
        initMin(node * 2 + 1, mid + 1, e);
        TreeMin[node] = Math.min(TreeMin[node * 2], TreeMin[node * 2 + 1]);
    }

    static long queryMax(int node, int s, int e, int l, int r) {
        if (e < l || s > r) {
            return Long.MIN_VALUE;
        }

        if (l <= s && e <= r) {
            return TreeMax[node];
        }

        int mid = (s + e) / 2;
        long x = queryMax(node * 2, s, mid, l, r);
        long y = queryMax(node * 2 + 1, mid + 1, e, l, r);
        return Math.max(x, y);
    }

    static long queryMin(int node, int s, int e, int l, int r) {
        if (e < l || s > r) {
            return Long.MAX_VALUE;
        }

        if (l <= s && e <= r) {
            return TreeMin[node];
        }

        int mid = (s + e) / 2;
        long x = queryMin(node * 2, s, mid, l, r);
        long y = queryMin(node * 2 + 1, mid + 1, e, l, r);
        return Math.min(x, y);
    }


    public static void main(String[] args) throws IOException {
        input();
        System.out.println(sb.toString());
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        TreeMax = new long[N * 4];
        TreeMin = new long[N * 4];
        arr = new int[N * 4];


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(TreeMin, Long.MAX_VALUE);

        initMax(1, 1, N);
        initMin(1, 1, N);

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(queryMax(1, 1, N, a, b) - queryMin(1, 1, N, a, b));
            sb.append("\n");
        }
    }
}
