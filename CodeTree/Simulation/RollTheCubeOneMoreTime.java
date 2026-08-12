package CodeTree_new;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class RollTheCubeOneMoreTime {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int answer = 0;
    static int[][] board;

    /*
     * 00 01 02
     * 10 11 12
     * 20 21 22
     * */
    static int[][] P = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};


    static class Dice {
        int x = 0;
        int y = 0;

        int dir = 1;

        int top = 1;
        int bottom = 6;
        int left = 4;
        int right = 3;
        int up = 5;
        int down = 2;


        void setDir() {
            if (bottom > board[x][y]) {
                dir++;
                if (dir >= 4) dir = 0;
            } else if (bottom < board[x][y]) {
                dir--;
                if (dir < 0) dir = 3;
            }
        }

        void move() {


            int nx = x + P[dir][0];
            int ny = y + P[dir][1];

            // 벽에 부딧히면 반사 후 한칸 이동

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                if (dir == 0) dir = 2;
                else if (dir == 1) dir = 3;
                else if (dir == 2) dir = 0;
                else if (dir == 3) dir = 1;
            }

            x += P[dir][0];
            y += P[dir][1];


            // up
            if (dir == 0) {
                /*
                 * top => up
                 * up => bottom
                 * bottom => down
                 * down => top
                 * */
                int tmp = top;

                top = down;
                down = bottom;
                bottom = up;
                up = tmp;
            }


            // right
            if (dir == 1) {
                /*
                 * top => right
                 * right => bottom
                 * bottom => left
                 * left => top
                 * */

                int tmp = top;

                top = left;
                left = bottom;
                bottom = right;
                right = tmp;
            }

            // down
            if (dir == 2) {
                /*
                 * top => down
                 * down => bottom
                 * bottom -> up
                 * up -> top
                 * */

                int tmp = top;

                top = up;
                up = bottom;
                bottom = down;
                down = tmp;

            }

            // left
            if (dir == 3) {
                /*
                 * top => left
                 * left -> bottom
                 * bottom -> right
                 * right -> top
                 *
                 * */

                int tmp = top;

                top = right;
                right = bottom;
                bottom = left;
                left = tmp;
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

    static void calcPoint(int x, int y) {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[N][N];
//        System.out.println(x + " " + y);
        int ans = board[x][y];

        q.add(new Pair(x, y));
        vis[x][y] = true;

        while (!q.isEmpty()) {
            Pair cur = q.removeFirst();

            for (int[] nxt : P) {
                int nx = nxt[0] + cur.x;
                int ny = nxt[1] + cur.y;

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (board[x][y] != board[nx][ny]) continue;
                if (vis[nx][ny]) continue;

                q.add(new Pair(nx, ny));
                vis[nx][ny] = true;

                ans += board[nx][ny];
            }
        }


//        System.out.println("ans " + ans);
        answer += ans;
    }

    static Dice dice = new Dice();

    public static void main(String[] args) throws IOException {
        input();

        // 항상 처음에는 오른쪽으로 움직임
        dice.move();

        calcPoint(dice.x, dice.y);

        dice.setDir();

        // 방향 조정 함수

        for(int i =0; i < M-1; i++){
            dice.move();

            calcPoint(dice.x, dice.y);

            dice.setDir();

//            System.out.println(dice.x + " " + dice.y + " " + dice.dir);
        }

//        System.out.println(dice.x + " " + dice.y + " " + dice.dir);

        System.out.println(answer);
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
    }
}
