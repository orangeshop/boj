

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;

    static int[] up = new int[105];
    static int[] down = new int[105];
    static boolean[] vis = new boolean[105];

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {

        ArrayDeque<Pair> Q = new ArrayDeque<>();

        Q.add(new Pair(1, 0));
        vis[1] = true;

        while (!Q.isEmpty()) {
            Pair cur = Q.removeFirst();

            if(cur.x == 100){
                System.out.println(cur.cnt);
                break;
            }

            for(int dir = 1; dir <= 6; dir++) {

                if(cur.x + dir > 100) continue;
                if(vis[cur.x + dir]) continue;

                if(up[cur.x + dir] != 0){
                    Q.add(new Pair(up[cur.x + dir], cur.cnt + 1));
                    vis[up[cur.x + dir]] = true;
                }
                else if(down[cur.x + dir] != 0){
                    Q.add(new Pair(down[cur.x + dir], cur.cnt + 1));
                    vis[down[cur.x + dir]] = true;
                }else{
                    Q.add(new Pair(cur.x + dir, cur.cnt + 1));
                    vis[cur.x + dir] = true;
                }
            }
        }
    }

    static class Pair{
        int x, cnt;

        public Pair(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i =0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            up[a] = b;
        }

        for(int i =0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            down[a] = b;
        }

    }
}
