import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;

    static ArrayList<Pair>[] ls;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {

        Pair u = dfs(1);

        Arrays.fill(vis, false);
        Pair v = dfs(u.y);

        Arrays.fill(vis, false);
        vis[u.y] = true;
        Pair answer1 = dfs(v.y);



        Arrays.fill(vis, false);
        vis[v.y] = true;
        Pair answer2 = dfs(u.y);

        System.out.println(Math.max(answer1.x, answer2.x));

    }

    static Pair dfs(int target){
        // 가장 먼 정점을 보내주면 됨

        ArrayDeque<Pair> S = new ArrayDeque<>();

        Pair result = new Pair(-1,-1);

        S.add(new Pair(0, target));
        vis[target] = true;

        while (!S.isEmpty()) {
            Pair cur = S.removeLast();

            if(cur.x > result.x){
                result = cur;
            }

            for(Pair nxt : ls[cur.y]){
                if(vis[nxt.y]) continue;

                S.push(new Pair(cur.x + nxt.x, nxt.y));
                vis[nxt.y] = true;
            }
        }

        return result;
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        ls = new ArrayList[N+1];
        vis = new boolean[N+1];

        for(int i =0; i <= N; i++){
            ls[i] = new ArrayList<>();
        }

        for(int i =0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            ls[a].add(new Pair(c,b));
            ls[b].add(new Pair(c,a));
        }
    }

    static class Pair{
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
