
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, X;
    static List<Integer>[] adj;
    static List<Integer>[] radj;

    static int U = 0, V = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        adj = new List[N + 1];
        radj = new List[N + 1];


        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
            radj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[b].add(a);
            radj[a].add(b);

        }

        U = calc(adj);
        V = calc(radj);
        System.out.println(U + " " + ((N-V)+1));
    }

    static int calc(List<Integer>[] m){
        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[N + 1];

        q.add(X);
        vis[X] = true;

        int cnt = 0;

        while (!q.isEmpty()) {
            Integer cur = q.removeFirst();
            cnt++;

            for(Integer nxt : m[cur]){
                if(vis[nxt]) continue;

                vis[nxt] = true;
                q.add(nxt);
            }
        }

        return cnt;
    }
}
