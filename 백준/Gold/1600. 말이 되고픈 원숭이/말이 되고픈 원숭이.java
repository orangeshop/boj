

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int K, N, M;
    static int[][] board;
    static boolean[][][] visited;
    static int answer = Integer.MAX_VALUE;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int[] ddx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] ddy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        init();
        solution();


        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }

        System.out.println(answer);
    }

    private static void solution() {

        ArrayDeque<tuple> Oq = new ArrayDeque<>();
        visited = new boolean[K+1][N][M];

        Oq.add(new tuple(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!Oq.isEmpty()) {

            tuple t = Oq.removeFirst();

            if (t.x == N - 1 && t.y == M - 1) {
                answer = Math.min(answer, t.cnt);
                break;
            }


            for (int dir = 0; dir < 4; dir++) {
                int nx = t.x + dx[dir];
                int ny = t.y + dy[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (visited[t.move][nx][ny] || board[nx][ny] == 1) continue;

                Oq.add(new tuple(t.move, nx, ny, t.cnt + 1));
                visited[t.move][nx][ny] = true;

            }


            if (t.move < K) {
                for (int dir = 0; dir < 8; dir++) {
                    int nx = t.x + ddx[dir];
                    int ny = t.y + ddy[dir];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if (visited[t.move + 1][nx][ny] || board[nx][ny] == 1) continue;

//                    System.out.println("ddx" + t.move+" "+ nx + " " + ny);

                    Oq.add(new tuple(t.move + 1, nx, ny, t.cnt + 1));
                    visited[t.move + 1][nx][ny] = true;
                }
            }
        }
    }

    static void see() {

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(vis);
//            }
//        }
    }


    static class tuple {
        int move, x, y, cnt;

        public tuple(int move, int x, int y, int cnt) {
            this.move = move;
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < M; k++) {
                board[i][k] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
