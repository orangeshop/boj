import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, Q;

    static class Pair{
        int idx,x, y, h;
        int s,e;

        public Pair(int idx, int x, int y, int h) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.h = h;
        }

        public Pair(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    static List<Pair> result = new ArrayList<>();
    static List<Pair> ls = new ArrayList<>();

    static int[] p = new int[100005];

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static int find(int x){
        if(p[x] == x) {
            return p[x];
        }
        return p[x] = find(p[x]);
    }

    static void union(int x,int y){
        int a = find(x);
        int b = find(y);
        if(a == b) {return;}

        p[b] = a;
    }

    private static void solution() {
        /**/

        for(int i = 0; i <= N; i++){
            p[i] = i;
        }

        ls.sort((o1,o2) -> {
            return o1.x - o2.x;
        });

        int start = ls.get(0).x;
        int end = ls.get(0).y;

        for(int i = 1; i < N; i++){
            if(ls.get(i).x <= end){
                union(ls.get(i-1).idx, ls.get(i).idx);
                end = Math.max(end,ls.get(i).y);
            }else{
                start = ls.get(i).x;
                end = ls.get(i).y;
            }
        }

        for (Pair pair : result) {

            if(p[pair.s] == p[pair.e]) {
                System.out.println("1");
            }else{
                System.out.println("0");
            }
        }

    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        for(int i =0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            ls.add(new Pair(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }


        for(int i =0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            result.add(new Pair(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1));
        }

    }
}
