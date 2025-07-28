import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int M, N;
    static int[][] map;
    static int[][] dp;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static List<Pair> ls = new ArrayList<>();

    static class Pair {
        int x;
        int y;
        int v;
        int cnt;

        public Pair(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }

        public Pair(int x, int y, int v, int cnt) {
            this.x = x;
            this.y = y;
            this.v = v;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        
        dp[0][0] = 1;

        ls.sort((o1, o2) -> {
            if(o2.v == o1.v) {
                if (o1.x == o2.x) {
                    return o2.y - o1.y;
                }
                return o2.x - o1.x;
            }
            return o2.v - o1.v;
        });



        for (int i = 0; i < N * M; i++) {
            for (int dir = 0; dir < 4; dir++) {
                int nx = ls.get(i).x + dx[dir];
                int ny = ls.get(i).y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (map[ls.get(i).x][ls.get(i).y] <= map[nx][ny]) continue;

                dp[nx][ny] += dp[ls.get(i).x][ls.get(i).y];
            }
        }

        System.out.println(dp[N-1][M-1]);

    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                ls.add(new Pair(i, j, map[i][j]));
            }
        }
    }
}
