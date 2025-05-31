import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int N, M, iceCnt;

    public static int[][] board = new int[105][105];
    public static ArrayDeque<Pair> ice = new ArrayDeque<>();

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};


    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {

        ArrayDeque<Integer> tq = new ArrayDeque<>();
        ArrayDeque<Pair> rq = new ArrayDeque<>();

        ArrayDeque<Pair> ttq = new ArrayDeque<>();

        int time = 0;
        int count = 0;

        ttq.addLast(new Pair(0, 0));
        boolean[][] vis = new boolean[105][105];
        vis[0][0] = true;

        while (true) {

            if(iceCnt <= 0) break;
            while (!ttq.isEmpty()) {
                Pair cur = ttq.removeFirst();

                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];
                    if (nx < 0 || ny < 0 || nx > N || ny > M) continue;
                    if (board[nx][ny] == 1) {
                        ice.addLast(new Pair(nx, ny));
                        continue;
                    }
                    if (vis[nx][ny]) continue;


                    vis[nx][ny] = true;
                    ttq.addLast(new Pair(nx, ny));
                }
            }

            while (!ice.isEmpty()) {
                Pair cur = ice.removeFirst();
//                System.out.println(cur.x + " " + cur.y);
                board[cur.x][cur.y] = 0;

                ttq.addLast(new Pair(cur.x, cur.y));
            }

            time++;
            tq.addLast(iceCnt);
            iceCnt = 0;
            see();
//            break;

        }




        System.out.println(time);
        System.out.println(tq.removeLast());
    }

    private static void see() {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
//                System.out.print(board[x][y] + " ");
                if (board[x][y] == 1) iceCnt++;
            }
//            System.out.println();
        }

//        System.out.println();
    }

    public static class Pair {
        int x;
        int y;
        int cnt;

        public Pair(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1) iceCnt++;
            }
        }
    }
}
