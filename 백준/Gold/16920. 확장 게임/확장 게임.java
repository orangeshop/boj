

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, P;
    static int[] moveCount;

    static int[][] board;
    static boolean[][] vis;
    static int[][] result;

    static int[] answer;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        init();
        solution();

        for (int ans : answer) {
            System.out.print(ans + " ");
        }
    }

    private static void solution() {
        /*
         *
         *
         *
         * */

        ArrayDeque<Pair> Q = new ArrayDeque<>();
        PriorityQueue<Pair> PQ = new PriorityQueue<>((o1, o2) -> {

            if (o1.num == o2.num) {
                return o1.cnt - o2.cnt;
            }

            return o1.num - o2.num;
        });

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                if (board[i][k] > 0) {
                    Q.add(new Pair(i, k, 0, board[i][k]));
                    vis[i][k] = true;
                    result[i][k] = board[i][k];
                }
            }
        }


        while (!Q.isEmpty()) {

            PQ.addAll(Q);
            Q.clear();

            while (!PQ.isEmpty()) {
                Pair cur = PQ.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if (vis[nx][ny] || board[nx][ny] != 0) continue;
//                    System.out.println(nx + " " + ny + " " + cur.num + " " + cur.cnt);

                    if (cur.cnt + 1 == moveCount[cur.num]) {
                        Q.add(new Pair(nx, ny, 0, cur.num));
                    } else {
                        PQ.add(new Pair(nx, ny, cur.cnt + 1, cur.num));
                    }
                    result[nx][ny] = cur.num;
                    vis[nx][ny] = true;
                }
            }
        }


//        System.out.println(Arrays.deepToString(board));
//        System.out.println(Arrays.deepToString(result));
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                if (result[i][k] != 0) {
                    answer[result[i][k] - 1]++;
                }
            }
        }
    }

    static class Pair {
        int x, y, cnt, num;

        public Pair(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        public Pair(int x, int y, int cnt, int num) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.num = num;
        }
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        moveCount = new int[P + 1];
        board = new int[N][M];
        vis = new boolean[N][M];
        result = new int[N][M];
        answer = new int[P];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < P + 1; i++) {
            moveCount[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int k = 0; k < M; k++) {

                if (str.charAt(k) == '.') {
                    board[i][k] = 0;
                }else if(str.charAt(k) == '#'){
                    board[i][k] = -1;
                }
                else {
                    board[i][k] = Integer.parseInt(str.charAt(k) + "");
                }
            }
        }
    }
}
