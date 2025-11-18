package codetree;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class test6 {
    static BufferedReader br;
    static StringTokenizer st;

    static int N, K, L;

    static int[][] board;

    static boolean[][] vis;

    /*
     * 00 01 02
     * 10 11 12
     * 20 21 22
     * */
    static int[][] P = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    static List<cleaner> cleaners = new ArrayList<cleaner>();

    static class cleaner {
        int x, y;

        public cleaner(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void move() {
            // vis 이동
//            System.out.println(x + " be " + y);
            vis[x][y] = false;

            int[] r = bfs();
            x = r[0];
            y = r[1];
            // x,y 값 변경
//            System.out.println(x + " af " + y);
            vis[x][y] = true;
        }

        int[] bfs() {
            ArrayDeque<Pair> q = new ArrayDeque<>();
            boolean[][] vvis = new boolean[N][N];
            int[][] cnt = new int[N][N];

            q.add(new Pair(x, y));
            vvis[x][y] = true;

            if (board[x][y] > 0) {
                return new int[]{x, y};
            }

            /*
             * 00 01 02
             * 10 11 12
             * 20 21 22
             * */

            while (!q.isEmpty()) {
                Pair cur = q.removeFirst();

                for (int[] nxt : P) {
                    int nx = nxt[0] + cur.x;
                    int ny = nxt[1] + cur.y;

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (vvis[nx][ny] || board[nx][ny] == -1 || vis[nx][ny]) continue;

                    q.add(new Pair(nx, ny));
                    vvis[nx][ny] = true;
                    cnt[nx][ny] = cnt[cur.x][cur.y] + 1;
                }
            }

            ArrayList<Pair> ls = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] > 0 && cnt[i][j] > 0) {
                        ls.add(new Pair(cnt[i][j], i, j));
                    }
                }
            }


            ls.sort((o1, o2) -> {
                if (o1.x == o2.x) {
                    if (o1.y == o2.y) {
                        return o1.z - o2.z;
                    }
                    return o1.y - o2.y;
                }
                return o1.x - o2.x;
            });

            if (!ls.isEmpty()) {
                return new int[]{ls.get(0).y, ls.get(0).z};
            }
            return new int[]{x, y};
        }

        /*
         * 00 01 02
         * 10 11 12
         * 20 21 22
         *
         * */
        void clean() {
            int[][][] P1 = {
                    {{-1, 0}, {0, 0}, {1, 0}, {0, 1}},
                    {{0, -1}, {0, 0}, {0, 1}, {1, 0}},
                    {{-1, 0}, {0, 0}, {1, 0}, {0, -1}},
                    {{0, -1}, {0, 0}, {0, 1}, {-1, 0}}
            };

            int resultDir = -1;
            int resultMax = -1;

            for (int dir = 0; dir < 4; dir++) {
                int result = 0;
                for (int i = 0; i < 4; i++) {
                    int nx = x + P1[dir][i][0];
                    int ny = y + P1[dir][i][1];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (board[nx][ny] == -1) continue;
                    result += Math.min(board[nx][ny], 20);
                }

                if (resultMax < result) {
                    resultMax = result;
                    resultDir = dir;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + P1[resultDir][i][0];
                int ny = y + P1[resultDir][i][1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (board[nx][ny] == -1) continue;
                board[nx][ny] = Math.max(board[nx][ny] - 20, 0);
            }
        }
    }

    static void plusDust() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] > 0) {
                    board[i][j] += 5;
                }
            }
        }
    }

    static void divDust() {
        int[][] tBoard = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) {

                    int result = 0;
                    for (int[] nxt : P) {
                        int nx = i + nxt[0];
                        int ny = j + nxt[1];

                        if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                        if (board[nx][ny] == -1) continue;

                        result += board[nx][ny];
                    }

                    tBoard[i][j] = result / 10;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] += tBoard[i][j];
            }
        }

    }

    static int calc() {
        int res = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] > 0) {
                    res += board[i][j];
                }
            }
        }
        return res;
    }

    static void see() {
        System.out.println("-----------------------");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------------");

    }


    static class Pair {
        int x, y;

        int z;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        for (int t = 0; t < L; t++) {

            for (int i = 0; i < cleaners.size(); i++) {
                cleaners.get(i).move();
            }

            for (int i = 0; i < cleaners.size(); i++) {
                cleaners.get(i).clean();
            }

            plusDust();
            divDust();
            System.out.println(calc());
        }

    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        vis = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            cleaners.add(new cleaner(x, y));
            vis[x][y] = true;
        }
    }

}
