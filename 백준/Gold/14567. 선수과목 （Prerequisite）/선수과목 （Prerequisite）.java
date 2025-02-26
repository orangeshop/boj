import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static ArrayList<Pair>[] adj;
    static int[] ans;

    static class Pair{
        int x,y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] in;

    public static void main(String[] args) throws IOException {
        input();
        solution();

        for(int i = 1; i <= N; i++){
            System.out.print(ans[i] + " ");
        }
    }

    private static void solution() {
        ArrayDeque<Pair> Q = new ArrayDeque<>();

        for(int i = 1; i <= N; i++){
            if(in[i] == 0){
                Q.add(new Pair(1, i));
            }
        }

        while(!Q.isEmpty()){
            Pair cur = Q.removeFirst();

//            System.out.println(cur.x + " " + cur.y);
            ans[cur.y] = cur.x;
            for(Pair nxt : adj[cur.y]){
                in[nxt.y]--;

                if(in[nxt.y] == 0){
                    Q.add(new Pair(cur.x + 1, nxt.y));
                }
            }
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        in = new int[N+1];
        ans = new int[N+1];

        for(int i =0; i <= N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i =0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(new Pair(0, b));
            in[b]++;
        }



    }
}
