import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static long[] Tree;
    static int[] arr;

    static void init(int node, int s, int e) {
        if (s == e) {
            Tree[node] = arr[e];
            return;
        }

        int mid = (s + e) / 2;

        init(node * 2, s, mid);
        init(node * 2 + 1, mid + 1, e);
        Tree[node] = Math.max(Tree[node * 2], Tree[node * 2 + 1]);
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
        return Math.max(x, y);
    }

    public static void main(String[] args) throws IOException {

        input();
        System.out.println(sb.toString());
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Tree = new long[N * 4];
        arr = new int[N * 4];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        init(1, 1, N);

        for (int i = M; i <= (N-M+1); i++) {
//            System.out.println(i + " " + (i+M));
            sb.append(query(1, 1, N, i - (M-1), i + (M-1))+" ");
        }
    }
}
