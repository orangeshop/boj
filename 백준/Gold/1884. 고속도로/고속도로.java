import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, R, K, ans = Integer.MAX_VALUE;

    static int[][] distance = new int[101][10001];


    static class Edge {
        int node;
        int dist;
        int cost;

        public Edge(int node, int dist, int cost) {
            this.node = node;
            this.dist = dist;
            this.cost = cost;

        }
    }
    
    static ArrayList<Edge>[] adj;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {

        for (int i = 2; i <= N; i++) {
            for (int k = 0; k <= K; k++) {
                distance[i][k] = Integer.MAX_VALUE;
            }
        }


        PriorityQueue<Edge> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.dist, p2.dist));

        pq.add(new Edge(1, 0, K));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
//            System.out.println(cur.cost + " " + cur.dist + " " + cur.node);
            if (distance[cur.node][cur.cost] < cur.dist) continue;

            for (Edge nxt : adj[cur.node]) {
                if (cur.cost < nxt.cost) continue;
                if (distance[nxt.node][cur.cost - nxt.cost] > cur.dist + nxt.dist) {
                    distance[nxt.node][cur.cost - nxt.cost] = cur.dist + nxt.dist;
                    pq.add(new Edge(nxt.node, distance[nxt.node][cur.cost - nxt.cost], cur.cost - nxt.cost));
                }
            }
        }

        for (int i = 0; i <= K; i++) {
            ans = Math.min(ans, distance[N][i]);
        }

        if (ans == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(ans);
        }


    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adj[start].add(new Edge(end, length, cost));
        }
    }


}
