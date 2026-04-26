import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[] parent;
    static int[] root;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        root = new int[M];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int t = Integer.parseInt(st.nextToken());
                if (t == 1) {
                    union(i, j);
                }
            }
        }


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            root[i] = Integer.parseInt(st.nextToken());
        }


        int firstRoot = find(root[0]);
        for (int i = 1; i < M; i++) {
            if (firstRoot != find(root[i])) {
                System.out.println("NO");
                return;
            }
        }


//        System.out.println(Arrays.toString(parent));
        System.out.println("YES");
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x != y) {
            parent[y] = x;
        }
    }
}
