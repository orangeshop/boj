import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[][] arr;

    /*
     * 00 01 02
     * 10 11 12
     * 20 21 22
     *
     * */

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        while (true) {

            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) {
                break;
            }
            input();
            solution();
        }
    }

    private static void input() throws IOException {


        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }

    private static void solution() {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[N][M];
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1 && !vis[i][j]) {
                    q.add(new Pair(i, j));
                    vis[i][j] = true;
                    answer++;
                    while (!q.isEmpty()) {
                        Pair pair = q.removeFirst();
//                        System.out.println(pair.x + " " + pair.y);
                        for (int dir = 0; dir < 8; dir++) {
                            int nx = pair.x + dx[dir];
                            int ny = pair.y + dy[dir];

                            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                            if (vis[nx][ny] || arr[nx][ny] == 0) continue;

                            q.add(new Pair(nx, ny));
                            vis[nx][ny] = true;

                        }
                    }
                }
            }
        }

        System.out.println(answer);

    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
