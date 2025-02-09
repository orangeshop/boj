import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int SIZE = 500_000;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static long answer;
    static int[] Tree;

    static ArrayList<Pair> arr = new ArrayList<>();

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static long query(int node, int s, int e, int l, int r) {

        if(e < l || e > r) {
            return 0;
        }

        if(l <= s && e <= r){
            return Tree[node];
        }

        int mid = (s + e) / 2;

        long x = query(node * 2, s, mid, l, r);
        long y = query(node * 2 + 1, mid + 1, e, l, r);
        return x + y;
    }

    static void update(int node, int s, int e, int idx) {
        if (idx < s || idx > e) {
            return;
        }

        if (s == e) {
            Tree[node] = 1;
            return;
        }

        int mid = (s + e) / 2;
        update(node * 2, s, mid, idx);
        update(node * 2 + 1, mid + 1, e, idx);
        Tree[node] = Tree[node * 2] + Tree[node * 2 + 1];
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(answer);
    }

    private static void solution() {

        arr.sort((o1, o2) -> {

            if(o1.x == o2.x) {
                return o1.y - o2.y;
            }

            return o1.x - o2.x;
        });

        for (Pair pair : arr) {
            answer += query(1,1, SIZE, pair.y,SIZE);
            update(1,1, SIZE, pair.y);
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        Tree = new int[SIZE * 4];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr.add(new Pair(Integer.parseInt(st.nextToken()), i));
        }
    }
}
