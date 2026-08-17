package CodeTree_new;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DestroyingTurrets {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, K;

    static Tower[][] board;

    static class Tower {
        int power;
        int attackTurn;
        int sum;
        int col;

        int x;
        int y;


        public Tower(int power, int attackTurn, int sum, int col, int x, int y) {
            this.power = power;
            this.attackTurn = attackTurn;
            this.sum = sum;
            this.col = col;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Tower{" +
                    "power=" + power +
                    ", attackTurn=" + attackTurn +
                    ", sum=" + sum +
                    ", col=" + col +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static class Pair {
        int x;
        int y;

        ArrayList<Pair> route;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Pair(int x, int y, ArrayList<Pair> route) {
            this.x = x;
            this.y = y;
            this.route = route;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    // 공격자 타워 선정
    static Tower selectAttackTower(int turn) {
        ArrayList<Tower> tmp = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                if (board[i][k].power == 0) continue;
                tmp.add(board[i][k]);
            }
        }

        tmp.sort((o1, o2) -> {
            if (o1.power == o2.power) {
                if (o1.attackTurn == o2.attackTurn) {
                    if (o1.sum == o2.sum) {
                        return o2.col - o1.col;
                    }
                    return o2.sum - o1.sum;
                }
                return o2.attackTurn - o1.attackTurn;
            }
            // 공격력이 가장 낮은 포탑
            return o1.power - o2.power;
        });

//        for (Tower t : tmp) {
//            System.out.println("attack " + t);
//        }

        if (tmp.isEmpty()) return new Tower(-1, -1, -1, -1, -1, -1);


        return board[tmp.get(0).x][tmp.get(0).y];
    }

    // 타워 선정
    static Tower selectDefenceTower(Tower attack) {
        ArrayList<Tower> tmp = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                if (board[i][k].power == 0) continue;
                if (board[i][k].equals(attack)) continue;
                tmp.add(board[i][k]);
            }
        }


        tmp.sort((o1, o2) -> {
            if (o1.power == o2.power) {
                if (o1.attackTurn == o2.attackTurn) {
                    if (o1.sum == o2.sum) {
                        return o1.col - o2.col;
                    }
                    return o1.sum - o2.sum;
                }
                return o1.attackTurn - o2.attackTurn;
            }
            // 공격력이 가장 낮은 포탑
            return o2.power - o1.power;
        });


        if (tmp.isEmpty()) return new Tower(-1, -1, -1, -1, -1, -1);
        return tmp.get(0);
    }

    static int[][] P = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    static ArrayList<Pair> findRazer = new ArrayList<>();

    static void attack(Tower a, Tower d) {
        // 레이저 공격


        /*
         * 00 01 02
         * 10 11 12
         * 20 21 22
         * */
        findRazer.clear();
        boolean[][] vis = new boolean[N][M];
        vis[a.x][a.y] = true;
        ArrayDeque<Pair> ls = new ArrayDeque<>();
//        ls.add(new Pair(a.x, a.y));

        int depth = findMinRoute(a.x, a.y, d.x, d.y);

        if(depth != Integer.MAX_VALUE) {
            razer(depth, a.x, a.y, vis, ls, d.x, d.y);
        }

//        for(Pair p: findRazer){
//            System.out.println(p);
//        }

        for (Pair p : findRazer) {
            if (p.x == d.x && p.y == d.y) {
                board[p.x][p.y].power = Math.max(board[p.x][p.y].power - board[a.x][a.y].power, 0);
            } else {
                board[p.x][p.y].power = Math.max(board[p.x][p.y].power - (board[a.x][a.y].power / 2), 0);
            }
        }

        // 포탄 공격
        if (findRazer.isEmpty()) {
//            System.out.println("boooooooom");
            // 공격자 제외
            // 방어자 주위 8칸 데미지/2
            // 방어자 데미지
            // 반대편에 영향 o
            /*
             * 00 01 02
             * 10 11 12
             * 20 21 22
             * */


            ;
            int[][] P2 = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

            board[d.x][d.y].power = Math.max(board[d.x][d.y].power - board[a.x][a.y].power, 0);

            for (int[] nxt : P2) {
                int nx = d.x + nxt[0];
                int ny = d.y + nxt[1];

                if (nx < 0) {
                    nx = N - 1;
                }

                if (nx >= N) {
                    nx = 0;
                }

                if (ny < 0) {
                    ny = M - 1;
                }

                if (ny >= M) {
                    ny = 0;
                }

                if (a.x == nx && a.y == ny) continue;

                board[nx][ny].power = Math.max(board[nx][ny].power - (board[a.x][a.y].power / 2), 0);

                findRazer.add(new Pair(nx, ny));
            }
        }
    }

    static int findMinRoute(int x, int y, int tx, int ty) {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(x, y, new ArrayList<>()));
        boolean[][] vis2 = new boolean[N][M];
        vis2[x][y] = true;

        int[][] cnt = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                cnt[i][k] = Integer.MAX_VALUE;
            }
        }

        cnt[x][y] = 0;


        while (!q.isEmpty()) {
            Pair cur = q.removeFirst();


            for (int[] nxt : P) {
                int nx = cur.x + nxt[0];
                int ny = cur.y + nxt[1];

                if (nx < 0) {
                    nx = N - 1;
                }

                if (nx >= N) {
                    nx = 0;
                }

                if (ny < 0) {
                    ny = M - 1;
                }

                if (ny >= M) {
                    ny = 0;
                }

                if (vis2[nx][ny] || board[nx][ny].power == 0) continue;

                q.add(new Pair(nx, ny));
                vis2[nx][ny] = true;

                cnt[nx][ny] = Math.min(cnt[nx][ny], cnt[cur.x][cur.y] + 1);
            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int k = 0; k < M; k++) {
//                System.out.print(cnt[i][k] + " ");
//            }
//            System.out.println();
//        }

        return cnt[tx][ty];
    }

    static void razer(int depth, int x, int y, boolean[][] vis, ArrayDeque<Pair> route, int tx, int ty) {
        if ((route.size() >= findRazer.size()) && !findRazer.isEmpty()) return;
        if (depth <= route.size()) return;

        if (x == tx && y == ty) {
            ArrayList<Pair> tmp = new ArrayList<>(route);

            if (findRazer.isEmpty()) {
                findRazer = tmp;
            }

            if (findRazer.size() > route.size()) {
                findRazer = tmp;
            }

            return;
        }

        for (int[] nxt : P) {
            int nx = x + nxt[0];
            int ny = y + nxt[1];

            if (nx < 0) {
                nx = N - 1;
            }

            if (nx >= N) {
                nx = 0;
            }

            if (ny < 0) {
                ny = M - 1;
            }

            if (ny >= M) {
                ny = 0;
            }

            if (vis[nx][ny] || board[nx][ny].power == 0) continue;
            route.add(new Pair(nx, ny));
            vis[nx][ny] = true;

            razer(depth + 1, nx, ny, vis, route, tx, ty);

            vis[nx][ny] = false;
            route.removeLast();
        }

//        ArrayDeque<Pair> q = new ArrayDeque<>();
//        q.add(new Pair(x, y, new ArrayList<>()));
//        boolean[][] vis2 = new boolean[N][M];
//        vis2[x][y] = true;
//
//
//        while (!q.isEmpty()) {
//            Pair cur = q.removeFirst();
//
//            if(cur.x == tx && cur.y == ty){
//                findRazer.addAll(cur.route);
//                for(Pair v: findRazer){
//                    System.out.println(v);
//                }
//                return;
//            }
//
//            for (int[] nxt : P) {
//                int nx = cur.x + nxt[0];
//                int ny = cur.y + nxt[1];
//
//                if (nx < 0) {
//                    nx = N - 1;
//                }
//
//                if (nx >= N) {
//                    nx = 0;
//                }
//
//                if (ny < 0) {
//                    ny = M - 1;
//                }
//
//                if (ny >= M) {
//                    ny = 0;
//                }
//
//                if (vis2[nx][ny] || board[nx][ny].power == 0) continue;
//                cur.route.add(new Pair(nx, ny));
//                ArrayList<Pair> tmp = new ArrayList<>(cur.route);
//                q.add(new Pair(nx, ny, tmp));
//                vis2[nx][ny] = true;
//            }
//        }

    }

    static void maintenance(Tower a, Tower d) {
        boolean[][] vis = new boolean[N][M];

        for (Pair p : findRazer) {
            vis[p.x][p.y] = true;
        }

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                if (board[i][k].power == 0) continue;
                if (a.x == i && a.y == k) continue;
                if (d.x == i && d.y == k) continue;
                if (vis[i][k]) continue;

                board[i][k].power += 1;

            }
        }
    }


    public static void main(String[] args) throws Exception {
        input();

        for (int T = 1; T <= K; T++) {

            Tower attackTower = selectAttackTower(T);
            if (attackTower.x == -1 && attackTower.y == -1) break;

            Tower defenceTower = selectDefenceTower(attackTower);
            if (defenceTower.x == -1 && defenceTower.y == -1) break;

            board[attackTower.x][attackTower.y].power += (N + M);
            board[attackTower.x][attackTower.y].attackTurn = T;

            attack(attackTower, defenceTower);

            maintenance(attackTower, defenceTower);

//            for (int i = 0; i < N; i++) {
//                for (int k = 0; k < M; k++) {
//                    System.out.print(board[i][k].power + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("=====");

        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                answer = Math.max(answer, board[i][k].power);
            }
        }
        System.out.println(answer);
    }

    private static void input() throws Exception {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new Tower[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < M; k++) {
                board[i][k] = new Tower(Integer.parseInt(st.nextToken()), 0, i + k, k, i, k);
            }
        }
    }
}
