package codetree;

import java.io.*;
import java.util.*;

public class DestroyTheTurret {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static class Turret {
        int attack;
        int attackTurn;
        int rowPlusCol;
        int col; // 열
        int row; // 행
        boolean turnState = false;
        boolean state = true;

        public Turret(int attack, int attackTurn, int rowPlusCol, int col, int row) {
            this.attack = attack;
            this.attackTurn = attackTurn;
            this.rowPlusCol = rowPlusCol;
            this.col = col;
            this.row = row;
        }

        @Override
        public String toString() {
            return this.attack + " " + this.attackTurn + " " + this.rowPlusCol + " " + this.row + " " + this.col + " " + this.turnState + " " + this.state;
        }
    }

    static class Pair {
        int x;
        int y;
        ArrayList<Pair> ls;
        boolean[][] vis;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Pair(int x, int y, ArrayList<Pair> ls, boolean[][] vis) {
            this.x = x;
            this.y = y;
            this.ls = ls;
            this.vis = vis;
        }
    }

    static Turret[][] board;
    static int N;
    static int M;
    static int K;

    /* 공격자 선정
    // 가장 약한 포탑 선정
    // N + M 만큼 공격력이 증가

       조건
       가장 약한 공격력의 포탑이 여러개면
       1. 가장 최근에 공격한 포탑
       2. 행과 열의 합의 큰 포탑
       3. 열의 위치가 가장 큰 포탑

    */

    static Turret findAttacker(int turn) {
        Turret target = null;

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                if (board[i][k].attack <= 0 || !board[i][k].state) continue;
                if (target == null) {
                    target = board[i][k];
                    continue;
                }

                if (findAttackerCheck(board[i][k], target) < 0) {
                    target = board[i][k];
                }
            }
        }

        board[target.row][target.col].turnState = true;
        board[target.row][target.col].attack += (N + M);
        board[target.row][target.col].attackTurn = turn;


        return target;
    }

    // a가 기존 b가 신규
    static int findAttackerCheck(Turret a, Turret b) {
        if (a.attack != b.attack) return Integer.compare(a.attack, b.attack);
        if (a.attackTurn != b.attackTurn) return Integer.compare(b.attackTurn, a.attackTurn);
        if (a.rowPlusCol != b.rowPlusCol) return Integer.compare(b.rowPlusCol, a.rowPlusCol);
        return Integer.compare(b.col, a.col);
    }


    static Turret findDefender() {
        Turret defender = null;

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                if (board[i][k].attack <= 0 || !board[i][k].state) continue;
                if (defender == null) {
                    defender = board[i][k];
                    continue;
                }

                if (findDefenderCheck(board[i][k], defender) < 0) {
                    defender = board[i][k];
                }
            }
        }

        board[defender.row][defender.col].turnState = true;
        return defender;
    }

    // a가 기존 b가 신규
    static int findDefenderCheck(Turret a, Turret b) {
        if (a.attack != b.attack) return Integer.compare(b.attack, a.attack);
        if (a.attackTurn != b.attackTurn) return Integer.compare(a.attackTurn, b.attackTurn);
        if (a.rowPlusCol != b.rowPlusCol) return Integer.compare(a.rowPlusCol, b.rowPlusCol);
        return Integer.compare(a.col, b.col);
    }


    /*
    // 공격자 공격
    1. 공격력이 가장 높은 포탑
    2. 공격한지 가장 오래된 포탑
    3. 행과 열이 가장 작은
    4. 열의 값이 가장 작은


    공격 방식
    1. 레이저 공격
        1. 상하좌우 4방향
        2. 부서진 포탑 지날 수 없음
        3. 가장 자리 -> 반대퍈

        최단 경로 존재 안할 시 2번 공격
        우,하,좌,상
        경로에 있는 공격자 / 2

    2. 포탄 공격
        1. 주위 8 방향
        2. 공격자는 피해 x
        3. 반대편에 피해


    */

    /*
    00 01 02
    10 11 12
    20 21 22
    *
    * */

    static int[][] P = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    static void attackType(Turret attacker, Turret defender) {
        if (!attackTypeOne(attacker, defender)) {
            attackTypeTwo(attacker, defender);
        }
    }

    static boolean attackTypeOne(Turret attacker, Turret defender) {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[N][M];
        Pair[][] prev = new Pair[N][M];

        q.add(new Pair(attacker.row, attacker.col));
        vis[attacker.row][attacker.col] = true;

        while (!q.isEmpty()) {
            Pair cur = q.removeFirst();

            if (cur.x == defender.row && cur.y == defender.col) break;

            for (int[] d : P) {
                int nx = cur.x + d[0];
                int ny = cur.y + d[1];

                if (nx < 0) nx += N;
                if (nx >= N) nx -= N;
                if (ny < 0) ny += M;
                if (ny >= M) ny -= M;

                if (vis[nx][ny]) continue;
                if (board[nx][ny].attack <= 0) continue;

                vis[nx][ny] = true;
                prev[nx][ny] = cur;
                q.add(new Pair(nx, ny));
            }
        }

        // defender까지 못 갔으면 레이저 실패
        if (!vis[defender.row][defender.col]) return false;

        // defender 피해
        board[defender.row][defender.col].attack -= attacker.attack;
        board[defender.row][defender.col].turnState = true;

        // 경로 역추적
        Pair cur = prev[defender.row][defender.col];

        while (cur != null && !(cur.x == attacker.row && cur.y == attacker.col)) {
            board[cur.x][cur.y].attack -= (attacker.attack / 2);
            board[cur.x][cur.y].turnState = true;
            cur = prev[cur.x][cur.y];
        }

        return true;
    }

    static void attackTypeTwo(Turret attacker, Turret defender) {
//        System.out.println("attackTypeTwo");
        /*
         * 00 01 02
         * 10 11 12
         * 20 21 22
         * */
        int[][] P1 = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

        board[defender.row][defender.col].attack -= attacker.attack;

        for (int dir = 0; dir < 8; dir++) {
            int nx = defender.row + P1[dir][0];
            int ny = defender.col + P1[dir][1];


            if (nx < 0) {
                nx += N;
            }

            if (nx >= N) {
                nx -= N;
            }

            if (ny < 0) {
                ny += M;
            }

            if (ny >= M) {
                ny -= M;
            }

            if (nx == attacker.row && ny == attacker.col) continue;
            if (!board[nx][ny].state) continue;


//            System.out.println("type two "+ dir + " " + nx + " " + ny);

            board[nx][ny].attack -= (attacker.attack / 2);
            board[nx][ny].turnState = true;


        }
    }

    // 포탑 부서짐

    static void turretDestroy() {
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                if (board[i][k].attack <= 0) {
                    board[i][k].state = false;
                }
            }
        }
    }

    // 포탑 정비
    static void turretSetUp() {
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                if (!board[i][k].turnState && board[i][k].state) {
                    board[i][k].attack += 1;
                }
                board[i][k].turnState = false;

            }
        }
    }

    // 포탑 상태 체크
    static boolean turretStateUp() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                if (board[i][k].state) {
                    cnt++;
                }
            }
        }

        if (cnt == 1) {
            return true;
        }

        return false;
    }


    public static void main(String[] args) throws IOException {
        input();

        solve();
    }

    private static void solve() {
        for (int t = 1; t <= K; t++) {
//            Turret attacker = findAttacker(t);
//            System.out.println("attacker " + attacker.toString());

            Turret defender = findDefender();
//            System.out.println("defender " + defender.toString());
            Turret attacker = findAttacker(t);

            attackType(attacker, defender);

            turretDestroy();

            turretSetUp();


            if (turretStateUp()) break;

        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
//                System.out.println(board[i][k].toString());
                answer = Math.max(answer, board[i][k].attack);
            }
        }

        System.out.println(answer);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new Turret[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < M; k++) {

                board[i][k] = new Turret(Integer.parseInt(st.nextToken()), 0, i + k, k, i);
                if (board[i][k].attack == 0) {
                    board[i][k].state = false;
                }
            }
        }

//        for (int i = 0; i < N; i++) {
//
//            for (int k = 0; k < M; k++) {
//                System.out.println(board[i][k].toString());
//            }
//        }
    }
}
