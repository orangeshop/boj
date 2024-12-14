import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static List<Integer>[] adj;
    static int[] depth;

    static long answer = 0;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.print(answer);
    }

    static void dfs(int cur, int pre){
        for (Integer nxt : adj[cur]) {
            if (pre != nxt){
                if(depth[nxt] == 0){
                    depth[nxt] = depth[cur] + 1;
                    dfs(nxt, cur);
                }else if(depth[cur] > depth[nxt]){
                    int s = depth[cur] - depth[nxt] + 1;
                    answer += (long) s * s;
                }
            }
        }
    }

    private static void solution() {
        dfs(1,0);
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new List[N+1];
        depth = new int[N+1];

        for(int i = 0; i < N+1; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            int a,b,c;

            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
    }

}
