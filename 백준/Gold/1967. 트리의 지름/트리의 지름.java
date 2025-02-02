import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static ArrayList<Pair>[] ls;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        Pair answer1 = dfs(1);
        Pair answer2 = dfs(answer1.y);

        System.out.println(answer2.x);
    }

    private static Pair dfs(int target){
        ArrayDeque<Pair> S = new ArrayDeque<>();
        boolean[] vis = new boolean[N+1];

        S.add(new Pair(0, target));
        vis[target] = true;

        Pair result = new Pair(-1,-1);

        while (!S.isEmpty()){
            Pair cur = S.removeLast();

            if(result.x < cur.x){
                result = cur;
            }

            for (Pair nxt : ls[cur.y]){
                if(vis[nxt.y]) continue;
                S.add(new Pair(nxt.x + cur.x, nxt.y));
                vis[nxt.y] = true;
            }
        }

        return result;
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        ls = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            ls[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            ls[a].add(new Pair(c, b));
            ls[b].add(new Pair(c, a));
        }
    }

    private static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
