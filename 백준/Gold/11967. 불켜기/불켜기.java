import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N, M, answer = 1;

    private static ArrayList<Pair>[][] adj = new ArrayList[110][110];
    private static int[][] vis = new int[110][110];

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static class Pair {
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

        System.out.println(answer);
    }

    private static void solution() {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(1, 1));
        vis[1][1] = 2;

        while (!q.isEmpty()) {
            Pair cur = q.removeFirst();
//            System.out.println(cur.x + " " + cur.y);

            for (Pair nxt : adj[cur.x][cur.y]) {
                if (vis[nxt.x][nxt.y] != 0) {
                    continue;
                }
                for (int dir = 0; dir < 4; dir++) {
                    int nx = nxt.x + dx[dir];
                    int ny = nxt.y + dy[dir];

                    if (vis[nx][ny] == 2) {
                        q.push(new Pair(nx, ny));
                        break;
                    }
                }
                vis[nxt.x][nxt.y] = 1;
                answer++;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (vis[nx][ny] == 1) {
                    vis[nx][ny] = 2;
                    q.add(new Pair(nx, ny));
                }
            }
        }
    }

    /*
     * 1 1 1
     * 1 1 0
     * 0 0 0
     * */

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        for (int i = 0; i <= 105; i++) {
            for (int j = 0; j <= 105; j++) {
                adj[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[x][y].add(new Pair(a, b));
        }
    }
}
