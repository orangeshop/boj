import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, Q;
    static Pair[] Tree;
    static Pair[] arr;

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

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        arr = new Pair[N * 4];
        Tree = new Pair[N * 4];

        for (int i = 0; i < N * 4; i++) {
            Tree[i] = new Pair(0, 0);
            arr[i] = new Pair(0, 0);
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new Pair(a, b);
        }


//        for(int i =0; i < N*4; i++){
//            System.out.println(Tree[i].x + " " + Tree[i].y);
//        }

        for (int i = 1; i <= Q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            init(1, 1, N, a);
            System.out.println(query(1, 1, N, b, c).x);

//            for(int k =0; k < N*4; k++){
//                System.out.println(Tree[k].x + " " + Tree[k].y);
//            }
//            System.out.println();
        }

    }

    private static Pair query(int node, int s, int e, int l, int r) {
        if (e < l || s > r) {
            return new Pair(0, 0);
        }

        if (l <= s && e <= r) {
            return Tree[node];
        }

        int mid = (s + e) / 2;
        Pair x = query(node * 2, s, mid, l, r);
        Pair y = query(node * 2 + 1, mid + 1, e, l, r);


//        System.out.println(x.x + " " + x.y + " " + y.x + " " + y.y);
        return new Pair(x.x + y.x, 0);
    }

    private static void init(int node, int s, int e, int t) {
        if (s == e) {
            if(t == arr[s].y){
                Tree[node] = new Pair(arr[s].x/2, arr[s].y);
            }else {
                Tree[node] = arr[s];
            }
            return;
        }

        int mid = (s + e) / 2;
        init(node * 2, s, mid,t);
        init(node * 2 + 1, mid + 1, e,t);

        Tree[node] = new Pair(Tree[node * 2].x + Tree[node * 2 + 1].x, 0);
    }
}
