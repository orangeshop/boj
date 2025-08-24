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

    static int N, answer;
    static int leaf, maxDist;
    static List<Pair>[] adj = new List[100_005];

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
//        extracted();

        boolean[] vis = new boolean[N + 1];
        vis[1] = true;
        dfs(1, 0, vis);
        Arrays.fill(vis, false);
        maxDist = 0;
        vis[leaf] = true;
        dfs(leaf, 0, vis);
        System.out.println(maxDist);

    }

    private static void dfs(int node, int dist, boolean[] vis) {
        if (maxDist < dist) {
            maxDist = dist;
            leaf = node;
        }

        for (int i = 0; i < adj[node].size(); i++) {
            int nxt = adj[node].get(i).x;
            int cost = adj[node].get(i).y;

            if (!vis[nxt]) {
                vis[nxt] = true;
                dfs(nxt, dist + cost, vis);
                vis[nxt] = false;
            }
        }
    }

    private static void extracted() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                System.out.print(adj[i].get(j).x + " " + adj[i].get(j).y + " ");
            }
            System.out.println();
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 100_005; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            while (true) {
                int b = Integer.parseInt(st.nextToken());
                if (b == -1) break;

                int c = Integer.parseInt(st.nextToken());

                adj[a].add(new Pair(b, c));
            }
        }
    }
}
