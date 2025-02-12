import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, Q;
    static long[] Tree;

    public static void main(String[] args) throws IOException {
        input();
    }

    static long query(int node, int s, int e, long l, long r){
        if(e < l || s > r){
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

    static void update(int node, int s, int e, long idx, long val){
        if(idx < s || e < idx){
            return;
        }

        if(s == e){
            Tree[node] += val;
            return;
        }

        int mid = (s + e) /2;
        update(node * 2, s, mid, idx, val);
        update(node * 2 + 1, mid + 1, e, idx, val);
        Tree[node] = Tree[node * 2] + Tree[node * 2 + 1];
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        Tree = new long[N * 4];

        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1){
                update(1,1,N,b,c);
            }else{
                System.out.println(query(1,1,N,b,c));
            }
        }

    }
}
