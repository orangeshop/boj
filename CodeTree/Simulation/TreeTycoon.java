package codetree;

import java.io.*;
import java.util.*;


public class TreeTycoon {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[][] board;

    static List<Pair> rls = new ArrayList<>();

    static ArrayDeque<Pair> seeds = new ArrayDeque<>();

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /*
     * 00 01 02
     * 10 11 12
     * 20 21 22
     * */
    static int[][] P = {{0, 0}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}};

    static void init() {
        // 초기 씨앗 넣어주기

        seeds.add(new Pair(N - 1, 0));
        seeds.add(new Pair(N - 1, 1));
        seeds.add(new Pair(N - 2, 0));
        seeds.add(new Pair(N - 2, 1));


    }

    public static void main(String[] args) throws IOException {
        input();

        init();

        solve();
    }

    static void solve() {
        for (int t = 0; t < rls.size(); t++) {
            Pair cur = rls.get(t);
            moveSeed(cur.x, cur.y);
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
//                System.out.print(board[i][k] + " ");
                answer += board[i][k];
            }
//            System.out.println();
        }

        System.out.println(answer);
    }

    static void moveSeed(int dir, int s) {
        ArrayDeque<Pair> tmp = new ArrayDeque<>();

        while (!seeds.isEmpty()) {
            Pair cur = seeds.removeFirst();

            int nx = cur.x + ((P[dir][0] * s) % N);
            int ny = cur.y + ((P[dir][1] * s) % N);

            if (nx < 0) {
                nx += N;
            }

            if (nx >= N) {
                nx -= N;
            }

            if (ny < 0) {
                ny += N;
            }

            if (ny >= N) {
                ny -= N;
            }

            tmp.add(new Pair(nx, ny));
        }

        List<Pair> ls = new ArrayList<>(tmp);

        for (Pair p : ls) {
            board[p.x][p.y] += 1;
        }

        int[][] tBoard = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                tBoard[i][k] = board[i][k];
            }
        }

        boolean[][] vis = new boolean[N][N];

        while (!tmp.isEmpty()) {
            Pair cur = tmp.removeFirst();
//            System.out.println(cur.x + " " + cur.y);
            vis[cur.x][cur.y] = true;

            for (int d = 2; d <= 8; d += 2) {
                int nx = P[d][0] + cur.x;
                int ny = P[d][1] + cur.y;

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (board[nx][ny] < 1) continue;
//                System.out.println("cur " + cur.x + " " + cur.y + " nx " + nx + " " + ny);
                tBoard[cur.x][cur.y] += 1;
            }
        }

//        System.out.println("t Board");
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
//                System.out.print(tBoard[i][k] + " ");
                if (vis[i][k]) continue;
                if (tBoard[i][k] >= 2) {
                    tBoard[i][k] -= 2;
                    seeds.add(new Pair(i, k));
                }
            }
//            System.out.println();
        }

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                board[i][k] = tBoard[i][k];
            }
        }

    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < N; k++) {
                board[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            rls.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

    }
}
