import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,M;

    static Pair[] arr;
    static Pair[] Tree;

    static class Pair{
        long x, y;

        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static void init(int node, int s,int e){
        if(s == e){
            Tree[node] = arr[e];
            return;
        }

        int mid = (s + e)/2;

        init(node * 2, s, mid);
        init(node * 2 + 1, mid + 1, e);

        if(Tree[node * 2].y > Tree[node * 2 + 1].y){
            Tree[node] = Tree[node * 2 + 1];
        }else{
            Tree[node] = Tree[node * 2];
        }
    }

    static Pair query(int node, int s, int e, int l, int r){
        if(e < l || s > r){
            return new Pair(Long.MAX_VALUE, Long.MAX_VALUE);
        }

        if(l <= s && e <= r){
            return Tree[node];
        }

        int mid = (s + e)/2;
        Pair x = query(node * 2, s, mid, l, r);
        Pair y = query(node * 2 + 1, mid + 1, e, l, r);

        if(x.y > y.y){
            return y;
        }else{
            return x;
        }
    }

    static void update(int node, int s, int e, int idx, int val){
        if(idx < s || e < idx){
            return;
        }

        if(s == e){
            Tree[node].y = val;
            return;
        }

        int mid = (s + e)/2;
        update(node * 2, s , mid, idx, val);
        update(node * 2 + 1, mid + 1, e, idx, val);

        if(Tree[node * 2].y > Tree[node * 2 + 1].y){
            Tree[node] = Tree[node * 2 + 1];
        }else{
            Tree[node] = Tree[node * 2];
        }
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

        arr = new Pair[N*4];
        Tree = new Pair[N*4];

        for(int i = 0; i < N*4; i++){
            arr[i] = new Pair(-1,-1);
            Tree[i] = new Pair(-1, -1);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = new Pair(i, Integer.parseInt(st.nextToken()));
        }

        init(1,1,N);

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 1){
                update(1,1,N,b,c);
            }else{
                Pair cur = query(1,1,N,b,c);

                System.out.println(cur.x);
            }

//            see();
//            System.out.println();

        }
    }

    static void see(){
        for(int i = 0; i < N * 4; i++){
            System.out.println(i + " " + Tree[i].x + " " + Tree[i].y);
        }
    }
}
