package codetree;

import java.util.*;
import java.io.*;


public class RotatingGlacier {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, Q;
    static int N;

    static int[][] board;

    static List<Integer> ls = new ArrayList<>();
    static Set<String> set = new HashSet<>();

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

        solve();
    }

    private static void solve() {
        for (Integer num : ls) {
            int level = (int) Math.pow(2, num);
            if (num > 0) {
                dfs(0, N - level, N - level, N, level);
            }
            nock();

            set.clear();
        }

        int[][] P = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        ArrayDeque<Pair> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[N][N];

        int answerCnt = 0;
        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                if(board[i][k] <= 0) continue;
                if(vis[i][k]) continue;


                q.add(new Pair(i, k));
                vis[i][k] = true;
                int tCnt = 1;
                answer += board[i][k];

                while (!q.isEmpty()) {
                    Pair cur = q.removeFirst();
                    for (int[] nxt : P) {
                        int nx = cur.x + nxt[0];
                        int ny = cur.y + nxt[1];

                        if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                        if (vis[nx][ny] || board[nx][ny] <= 0) continue;

                        q.add(new Pair(nx, ny));
                        vis[nx][ny] = true;
                        tCnt++;
                        answer += board[nx][ny];
                    }
                }
//                System.out.println(tCnt);
                answerCnt = Math.max(answerCnt, tCnt);
            }
        }

        System.out.println(answer);
        System.out.println(answerCnt);
    }
    /*
     * 00 02 04 06
     * */

    static void dfs(int depth, int x, int y, int level, int taget) {
        if (x < 0 || y < 0) {
            return;
        }
        String str = makeString(x, y);
        if (set.contains(str)) return;
        set.add(str);
//        System.out.println(x + " " + y);
        loop(x, y, taget);


        dfs(depth + 1, x - taget, y, level / 2, taget);
        dfs(depth + 1, x, y - taget, level / 2, taget);

    }

    static String makeString(int x, int y) {
        return x + " : " + y;
    }

    static void loop(int x, int y, int range) {
        int half = range / 2;
        int[][] tBoard = new int[range][range];

        for (int i = 0; i < half; i++) {
            for (int j = 0; j < half; j++) {
                tBoard[i][j + half] = board[x + i][y + j];
                tBoard[i + half][j + half] = board[x + i][y + j + half];
                tBoard[i + half][j] = board[x + i + half][y + j + half];
                tBoard[i][j] = board[x + i + half][y + j];
            }
        }

        for (int i = 0; i < range; i++) {
            for (int j = 0; j < range; j++) {
                board[x + i][y + j] = tBoard[i][j];
            }
        }
    }

    static void nock() {
        int[][] P = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int[][] tBoard = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                tBoard[i][k] = board[i][k];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                if(board[i][k] <= 0) continue;
                int iceCnt = 0;

                for (int[] nxt : P) {
                    int nx = i + nxt[0];
                    int ny = k + nxt[1];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (board[nx][ny] <= 0) continue;

                    iceCnt++;
                }

                if (iceCnt < 3) {
                    tBoard[i][k]--;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                board[i][k] = tBoard[i][k];
            }
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        N = (int) Math.pow(2, n);

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < N; k++) {
                board[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < Q; i++) {
            ls.add(Integer.parseInt(st.nextToken()));
        }

    }
}
