package codetree;

import java.io.*;
import java.util.*;

public class KnightOfAuthorityShowdown {
    static StringBuilder sb = new StringBuilder();

    static int L, N, Q;
    static long answer;
    static int[][] board;
    static int[][] nBoard;

    /*
     * 00 01 02
     * 10 11 12
     * 20 21 22
     * */
    static int[][] P = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static class Knight {
        int idx;
        int r;
        int c;
        int h;
        int w;
        int k;
        boolean state;

        int damage;

        public Knight(int idx, int r, int c, int h, int w, int k) {
            this.idx = idx;
            this.r = r;
            this.c = c;
            this.h = h;
            this.w = w;
            this.k = k;
            this.state = true;
            damage = 0;
        }
    }

    static ArrayList<Knight> ls = new ArrayList<>();
    static ArrayDeque<Integer> qq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/codetree/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        board = new int[L + 2][L + 2];

        for (int i = 0; i < L + 2; i++) {
            Arrays.fill(board[i], 2);
        }

        for (int i = 1; i <= L; i++) {
            for (int j = 1; j <= L; j++) {
                board[i][j] = 0;
            }
        }

        for (int i = 1; i <= L; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= L; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            Knight knight = new Knight(i + 1, r, c, h, w, k);
            ls.add(knight);
        }

        for (int t = 0; t < Q; t++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if (move(i, d)) {
                attack(i);
            }
        }

        for (Knight knight : ls) {
            if (knight.state) {
                answer += knight.damage;
            }
        }

        System.out.println(answer);
    }

    private static void attack(int nonAttack) {

        while (!qq.isEmpty()) {
            int cur = qq.removeFirst();

            if (ls.get(cur).idx == nonAttack) continue;
            if (!ls.get(cur).state) continue;

            int result = countTrap(ls.get(cur).idx);
            ls.get(cur).k -= result;
            ls.get(cur).damage += result;

            if (ls.get(cur).k <= 0) {
                ls.get(cur).state = false;
            }
        }
    }

    private static int countTrap(int idx) {
        int cnt = 0;
        for (int i = 0; i < L + 2; i++) {
            for (int j = 0; j < L + 2; j++) {
                if (nBoard[i][j] == idx && board[i][j] == 1) cnt++;
            }
        }

        return cnt;
    }

    private static boolean move(int idx, int d) {

        nBoard = new int[L + 2][L + 2];

        for (int i = 0; i < ls.size(); i++) {
            if (!ls.get(i).state) continue;
            for (int j = ls.get(i).r; j < ls.get(i).r + ls.get(i).h; j++) {
                for (int k = ls.get(i).c; k < ls.get(i).c + ls.get(i).w; k++) {
                    nBoard[j][k] = ls.get(i).idx;
                }
            }
        }

        ArrayDeque<Pair> q = new ArrayDeque<>();
        ArrayList<Pair> ms = new ArrayList<>();

        findNumber(idx, q);

        while (!q.isEmpty()) {
            Pair cur = q.removeFirst();
            int nx = cur.x + P[d][0];
            int ny = cur.y + P[d][1];

            if (board[nx][ny] == 2) {
                return false;
            }

            ms.add(new Pair(nx, ny, cur.v));

            if (nBoard[nx][ny] > 0) {
                findNumber(nBoard[nx][ny], q);
            }
        }

        Set<Integer> set = new HashSet<>();

        for (Pair cur : ms) {
            nBoard[cur.x][cur.y] = cur.v;
            set.add(cur.v - 1);


        }

        qq.addAll(set);
        ArrayDeque<Integer> tq = new ArrayDeque<>(set);


        while (!tq.isEmpty()) {
            int cur = tq.removeFirst();
            ls.get(cur).r += P[d][0];
            ls.get(cur).c += P[d][1];
        }
        return true;
    }

    private static void findNumber(int idx, ArrayDeque<Pair> q) {
        for (int i = 0; i < L + 2; i++) {
            for (int j = 0; j < L + 2; j++) {
                if (nBoard[i][j] == idx) {
                    q.add(new Pair(i, j, nBoard[i][j]));
                    nBoard[i][j] = 0;
                }
            }
        }
    }

    static class Pair {
        int x;
        int y;
        int v;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Pair(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }
}
