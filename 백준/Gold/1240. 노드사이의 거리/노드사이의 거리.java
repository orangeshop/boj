

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int answer;

    static List<Pair>[] adj;

    public static void main(String[] args) throws IOException {
        init();

    }

    private static int solution(int a, int b) {
        ArrayDeque<Pair> Q = new ArrayDeque<>();
        Q.add(new Pair(0, a));
        int[] vis = new int[N+1];

        while (!Q.isEmpty()) {
            Pair pair = Q.poll();
//            System.out.println(pair.x + " " + pair.y);
            for(Pair nxt : adj[pair.y]){
                if(vis[nxt.y] != 0 || nxt.y == a) continue;

                vis[nxt.y] = nxt.x + pair.x;
                Q.add(new Pair(nxt.x + pair.x, nxt.y));
            }
        }

//        for (int vi : vis) {
//            System.out.print(vi + " ");
//        }
//        System.out.println();

        return vis[b];
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new List[N + 1];

        for(int i=0; i<=N; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new Pair(c,b));
            adj[b].add(new Pair(c,a));
        }

//        for(int i=0; i<=N; i++) {
//            System.out.print(i + " : ");
//            for(int j=0; j< adj[i].size(); j++) {
//                System.out.print(adj[i].get(j).y + " ");
//            }
//            System.out.println();
//        }

        for(int i =0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(solution(a,b));
        }
    }

    static class Pair {
        int x,y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
