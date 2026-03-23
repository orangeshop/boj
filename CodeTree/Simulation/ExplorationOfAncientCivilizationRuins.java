package codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ExplorationOfAncientCivilizationRuins {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final int N = 5;

    static List<Integer> answer = new ArrayList<>();

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Result {
        int cnt;
        int loop;
        int[][] board;
        int x;
        int y;
        int sum;
        List<Pair> ls = new ArrayList<>();

        public Result(int cnt, int loop, int[][] board, int x, int y, List<Pair> ls, int sum) {
            this.cnt = cnt;
            this.loop = loop;
            this.board = board;
            this.x = x;
            this.y = y;
            this.ls = ls;
            this.sum = sum;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "cnt=" + cnt +
                    ", loop=" + loop +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static void lsSort() {
        ls.sort((o1, o2) -> {
            if (o1.cnt == o2.cnt) {
                if (o1.loop == o2.loop) {
                    if (o1.y == o2.y) {
                        return o1.x - o2.x;
                    }
                    return o1.y - o2.y;
                }
                return o1.loop - o2.loop;
            }
            return o2.cnt - o1.cnt;
        });
    }

    static int M, K;
    static int[][] board;
    static ArrayDeque<Integer> gq = new ArrayDeque<>();

    static ArrayList<Result> ls = new ArrayList<>();
    static int tAnswer = 0;

    public static void main(String[] args) throws IOException {
        input();
        solve();

    }

    private static void solve() {

        for (int t = 0; t < K; t++) {
            findPosition();

            lsSort();

//        for (Result r : ls) {
//            System.out.println(r.toString());
//        }

            if (!ls.isEmpty()) {
                if (ls.get(0).cnt == 0) {
                    break;
                }

                for (int i = 0; i < ls.get(0).ls.size(); i++) {
                    ls.get(0).board[ls.get(0).ls.get(i).x][ls.get(0).ls.get(i).y] = 0;
                }

                for (int i = 0; i < N; i++) {
                    for (int k = 0; k < N; k++) {
                        board[i][k] = ls.get(0).board[i][k];
                    }
                }

                tAnswer += ls.get(0).sum;
            }else{
                break;
            }

//            System.out.println("be " + tAnswer);
            ls.clear();

            do {
                addBoard();
            } while (removeBoard());

//            System.out.println(tAnswer);

            answer.add(tAnswer);
            tAnswer = 0;

//            System.out.println(t);
//            for (int i = 0; i < N; i++) {
//                for (int k = 0; k < N; k++) {
//                    System.out.print(board[i][k] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }

        for (Integer v : answer) {
            if (v == 0) continue;
            System.out.print(v + " ");
        }

    }

    public static void findPosition() {
        for (int i = 1; i < 4; i++) {
            for (int k = 1; k < 4; k++) {
                rotate(i, k, 1);
                rotate(i, k, 2);
                rotate(i, k, 3);

            }
        }
    }

    private static void rotate(int x, int y, int loop) {
        // 발굴 체크

        int[][] tBoard = new int[3][3];
        int[][] ttBoard = new int[3][3];

        int[][] tttBoard = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                tttBoard[i][k] = board[i][k];
            }
        }

        int newX = 0;
        int newY = 0;

        for (int i = x - 1; i < x + 2; i++) {
            for (int k = y - 1; k < y + 2; k++) {
//                System.out.println(newX + " " + newY + " " + i + " " + k);
                tBoard[newX][newY] = board[i][k];
                newY++;
            }
            newX++;
            newY = 0;
        }

        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                if (loop == 1) {
                    ttBoard[k][3 - 1 - i] = tBoard[i][k];
                } else if (loop == 2) {
                    ttBoard[3 - 1 - i][3 - 1 - k] = tBoard[i][k];
                } else if (loop == 3) {
                    ttBoard[3 - 1 - k][i] = tBoard[i][k];
                }
            }
        }

        newX = 0;
        newY = 0;

        for (int i = x - 1; i < x + 2; i++) {
            for (int k = y - 1; k < y + 2; k++) {
                tttBoard[i][k] = ttBoard[newX][newY];
                newY++;
            }
            newX++;
            newY = 0;
        }

        bfs(tttBoard, loop, x, y);
    }

    private static void bfs(int[][] tBoard, int loop, int x, int y) {
//        System.out.println(x + " " + y);
//        for (int i = 0; i < N; i++) {
//            for (int k = 0; k < N; k++) {
//                System.out.print(tBoard[i][k] + " ");
//            }
//            System.out.println();
//        }

        int cnt = 0;
        int sum = 0;
        boolean[][] vis = new boolean[N][N];
        ArrayDeque<Pair> q = new ArrayDeque<>();
        int[][] P = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        ArrayList<Pair> tls = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                if (vis[i][k]) continue;
                ArrayList<Pair> sls = new ArrayList<>();

                q.add(new Pair(i, k));
                vis[i][k] = true;
                int tCnt = 1;
                int tSum = board[i][k];
                sls.add(new Pair(i, k));

                while (!q.isEmpty()) {
                    Pair cur = q.removeFirst();

                    for (int[] nxt : P) {
                        int nx = cur.x + nxt[0];
                        int ny = cur.y + nxt[1];

                        if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                        if (vis[nx][ny] || tBoard[nx][ny] != tBoard[i][k]) continue;

                        q.add(new Pair(nx, ny));
                        vis[nx][ny] = true;
                        tCnt++;
                        sls.add(new Pair(nx, ny));

                    }
                }

                if (tCnt >= 3) {
                    cnt += tCnt;
                    tls.addAll(sls);
                    sum += tSum;
                }

//                System.out.print(tBoard[i][k] + " ");
            }
//            System.out.println();
        }

//        System.out.println();

        if(ls.isEmpty()) {
            ls.add(new Result(cnt, loop, tBoard, x, y, tls, cnt));
        }else{
            ls.add(new Result(cnt, loop, tBoard, x, y, tls, cnt));
            lsSort();

            ls.remove(ls.size()-1);
        }
    }

    public static void addBoard() {
        for (int k = 0; k < N; k++) {
            for (int i = N - 1; i > -1; i--) {
                if (board[i][k] != 0) continue;
                if (gq.isEmpty()) continue;
                board[i][k] = gq.removeFirst();
            }
        }
    }

    public static boolean removeBoard() {
        boolean[][] vis = new boolean[N][N];
        ArrayDeque<Pair> q = new ArrayDeque<>();
        int[][] P = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        ArrayList<Pair> tls = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                if (vis[i][k]) continue;
                ArrayList<Pair> sls = new ArrayList<>();

                q.add(new Pair(i, k));
                vis[i][k] = true;
                int tCnt = 1;
                int tSum = board[i][k];
                sls.add(new Pair(i, k));

                while (!q.isEmpty()) {
                    Pair cur = q.removeFirst();

                    for (int[] nxt : P) {
                        int nx = cur.x + nxt[0];
                        int ny = cur.y + nxt[1];

                        if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                        if (vis[nx][ny] || board[nx][ny] != board[i][k]) continue;

                        q.add(new Pair(nx, ny));
                        vis[nx][ny] = true;
                        tCnt++;
                        sls.add(new Pair(nx, ny));

                    }
                }

                if (tCnt >= 3) {
                    tls.addAll(sls);
                    sum += tCnt;
                }
            }
        }

        for (Pair nxt : tls) {
            board[nxt.x][nxt.y] = 0;
        }

        tAnswer += sum;

        if (!tls.isEmpty()) {
            return true;
        }

        return false;
    }


    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < N; k++) {
                board[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            gq.add(Integer.parseInt(st.nextToken()));
        }

    }
}
