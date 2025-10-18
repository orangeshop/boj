import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, S;
    static int[][] board;

    static int answer = 0;

    static int[][] P = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static class Pair {
        int x;
        int y;

        int t;

        int cnt;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Pair(int x, int y, int t, int cnt) {
            this.x = x;
            this.y = y;
            this.t = t;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        Pair st = new Pair(-1, -1);

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char ch = str.charAt(j);
                if (ch == '.') {
                    board[i][j] = 0;
                } else if (ch == 'X') {
                    board[i][j] = -1;
                } else if (ch == 'S') {
                    board[i][j] = -2;
                    st = new Pair(i, j);
                } else {
                    board[i][j] = Integer.parseInt(ch + "");
                }
            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }

        ArrayDeque<Pair> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[N][M];

        q.push(new Pair(st.x, st.y, -2, 0));
        vis[st.x][st.y] = true;
        int target = 1;

        while (!q.isEmpty()) {
            Pair cur = q.removeFirst();

            if (cur.t == target) {
                q.clear();
                target++;
                vis = new boolean[N][M];
                vis[cur.x][cur.y] = true;
                answer += cur.cnt;
                cur.cnt = 0;
            }

            for (int[] nxt : P) {
                int nx = cur.x + nxt[0];
                int ny = cur.y + nxt[1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (vis[nx][ny] || board[nx][ny] == -1) continue;

                q.add(new Pair(nx, ny, board[nx][ny], cur.cnt + 1));
                vis[nx][ny] = true;

            }

        }

        System.out.println(answer);

    }
}
