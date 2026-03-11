package codetree;

import java.io.*;
import java.util.*;


public class RollTheCubeOneMoreTime {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    /*
     * 00 01 02
     * 10 11 12
     * 20 21 22
     * */

    // 상우하좌
    static int[][] P = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static class Dice {
        int top;
        int bottom;
        int up;
        int right;
        int down;
        int left;

        int dir = 1;
        int x = 0;
        int y = 0;

        public Dice(int top, int bottom, int up, int right, int down, int left) {
            this.top = top;
            this.bottom = bottom;
            this.up = up;
            this.right = right;
            this.down = down;
            this.left = left;
        }

        void shake(int type) {
            if (type == 0) {
                // 위로 굴림

                /*
                 * top -> up
                 * up -> bottom
                 * bottom -> down
                 * down -> top
                 *
                 * */

                ArrayDeque<Integer> q = new ArrayDeque<>();

                q.add(down);
                q.add(bottom);
                q.add(up);
                q.add(top);

                this.top = q.removeFirst();
                this.down = q.removeFirst();
                this.bottom = q.removeFirst();
                this.up = q.removeFirst();

            } else if (type == 2) {
                // 아래로 굴림
                ArrayDeque<Integer> q = new ArrayDeque<>();
                /*
                 * top -> down
                 * down -> bottom
                 * bottom -> up
                 * up -> top
                 *
                 * */

                q.add(top);
                q.add(down);
                q.add(bottom);
                q.add(up);

                this.down = q.removeFirst();
                this.bottom = q.removeFirst();
                this.up = q.removeFirst();
                this.top = q.removeFirst();


            } else if (type == 3) {
                // 왼쪽으로 굴림
                ArrayDeque<Integer> q = new ArrayDeque<>();

                /*
                 * top -> left
                 * left -> bottom
                 * bottom -> right
                 * right -> top
                 * */

                q.add(top);
                q.add(left);
                q.add(bottom);
                q.add(right);

                this.left = q.removeFirst();
                this.bottom = q.removeFirst();
                this.right = q.removeFirst();
                this.top = q.removeFirst();

            } else {
                // 오른쪽으로 굴림
                ArrayDeque<Integer> q = new ArrayDeque<>();

                /*
                 * top -> right
                 * right -> bottom
                 * bottom -> left
                 * left -> top
                 * */

                q.add(top);
                q.add(right);
                q.add(bottom);
                q.add(left);

                this.right = q.removeFirst();
                this.bottom = q.removeFirst();
                this.left = q.removeFirst();
                this.top = q.removeFirst();
            }
        }

        public void move(int type) {

            this.x += P[type][0];
            this.y += P[type][1];


            if (this.x < 0 || this.x >= N || this.y < 0 || this.y >= N) {
                // 방향 반대로
                // 한칸 이동

                if (type == 0) {
                    this.dir = 2;
                } else if (type == 1) {
                    this.dir = 3;
                } else if (type == 2) {
                    this.dir = 0;
                } else if (type == 3) {
                    this.dir = 1;
                }

                this.x += P[this.dir][0] * 2;
                this.y += P[this.dir][1] * 2;

            }

            shake(this.dir);
        }

        void settingDir() {
            if (board[this.x][this.y] < this.bottom) {
                this.dir += 1;
                if (this.dir > 3) {
                    this.dir = 0;
                }
            } else if (board[this.x][this.y] == this.bottom) {
                // 그대로
            } else if (board[this.x][this.y] > this.bottom) {
                this.dir -= 1;

                if (this.dir < 0) {
                    this.dir = 3;
                }
            }
        }
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Dice d = new Dice(1, 6, 5, 3, 2, 4);
    static int N, M;
    static int[][] board;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
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

        init();


        for (int i = 0; i < M; i++) {
            System.out.println("st : " + d.x + " " + d.y + " dir : " + d.dir + " bottom : " + d.bottom);
            d.move(d.dir);
            calcPoint(board[d.x][d.y]);
            d.settingDir();
            System.out.println("end : " + d.x + " " + d.y + " dir : " + d.dir + " bottom : " + d.bottom);
        }

        System.out.println(answer);

    }

    private static void init() {
        d.move(0);
        System.out.println("top : " + d.top + " up : " + d.up + " right : " + d.right + " down : " + d.down + " left : " + d.left + " bottom : " + d.bottom);

        d = new Dice(1, 6, 5, 3, 2, 4);
        d.move(1);
        System.out.println("top : " + d.top + " up : " + d.up + " right : " + d.right + " down : " + d.down + " left : " + d.left + " bottom : " + d.bottom);

        d = new Dice(1, 6, 5, 3, 2, 4);
        d.move(2);
        System.out.println("top : " + d.top + " up : " + d.up + " right : " + d.right + " down : " + d.down + " left : " + d.left + " bottom : " + d.bottom);

        d = new Dice(1, 6, 5, 3, 2, 4);
        d.move(3);
        System.out.println("top : " + d.top + " up : " + d.up + " right : " + d.right + " down : " + d.down + " left : " + d.left + " bottom : " + d.bottom);

        d = new Dice(1, 6, 5, 3, 2, 4);

    }

    static void calcPoint(int nowP) {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[N][N];
        q.add(new Pair(d.x, d.y));
        vis[d.x][d.y] = true;

        int cnt = 1;


        while (!q.isEmpty()) {
            Pair cur = q.removeFirst();

            for (int[] nxt : P) {
                int nx = nxt[0] + cur.x;
                int ny = nxt[1] + cur.y;

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (vis[nx][ny] || board[nx][ny] != nowP) continue;

                cnt++;
                q.add(new Pair(nx, ny));
                vis[nx][ny] = true;
            }
        }

//        System.out.println(cnt);
//        System.out.println(cnt * nowP);
        answer += (cnt * nowP);
    }
}
