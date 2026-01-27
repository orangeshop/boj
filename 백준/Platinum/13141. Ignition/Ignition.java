

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int INF = 100000000;

    static class Edge {
        int u, v, l;

        public Edge(int u, int v, int l) {
            this.u = u;
            this.v = v;
            this.l = l;
        }
    }

    static int N, M;


    public static void main(String[] args) throws IOException {
        input();
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] dist = new int[N + 1][N + 1];
        List<Edge> edges = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a, b, c));
            if (dist[a][b] > c) {
                dist[a][b] = dist[b][a] = c;
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        double answer = Double.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            double result = 0;

            for (Edge edge : edges) {
                double t = (double) (dist[i][edge.u] + dist[i][edge.v] + edge.l) / 2.0;
                result = Math.max(result, t);
            }
            answer = Math.min(answer, result);
        }

        System.out.printf("%.1f\n", answer);

    }
}
