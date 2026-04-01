package codetree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CleaningIsFun {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;

    static int N;
    static int[][] board;

    static int answer = 0;

    static int tAnswer = 0;

    /*
     * 00 01 02 03 04
     * 10 11 12 13 14
     * 20 21 22 23 24
     * 30 31 32 33 34
     * 40 41 42 43 44
     *
     * */
    static int[][] P = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    static int[][][] P2 = {
            {{-1, -1, 10}, {-1, 0, 7}, {-1, 1, 1}, {-2, 0, 2}, {1, -1, 10}, {1, 0, 7}, {1, 1, 1}, {2, 0, 2}, {0, -2, 5}, {0, -1, -1}},
            {{1, -1, 10}, {0, -1, 7}, {-1, -1, 1}, {0, -2, 2}, {1, 1, 10}, {0, 1, 7}, {-1, 1, 1}, {0, 2, 2}, {2, 0, 5}, {1, 0, -1}},
            {{1, 1, 10}, {1, 0, 7}, {1, -1, 1}, {2, 0, 2}, {-1, 1, 10}, {-1, 0, 7}, {-1, -1, 1}, {-2, 0, 2}, {0, 2, 5}, {0, 1, -1}},
            {{-1, -1, 10}, {0, -1, 7}, {1, -1, 1}, {0, -2, 2}, {-1, 1, 10}, {0, 1, 7}, {1, 1, 1}, {0, 2, 2}, {-2, 0, 5}, {-1, 0, -1}}
    };


    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        input();

        init();

        solve();

//        System.out.println(answer);

        for(int i =0; i < N; i++){
            for(int k =0; k < N; k++){
                tAnswer -= board[i][k];
            }
        }

        System.out.println(tAnswer);
    }

    private static void solve() {
        bfs(N / 2, N / 2);
    }

    private static void bfs(int x, int y) {


        int[][] b = new int[N][N];

        int cnt = 1;

        for (Integer nxt : moveLs) {

//            if(cnt == 3) break;

            if (x == 0 && y == 0) break;

            int nx = P[nxt][0] + x;
            int ny = P[nxt][1] + y;

//            System.out.println(nx + " " + ny);

            calc(nx, ny, nxt);


            b[nx][ny] = cnt;
            cnt++;

            x = nx;
            y = ny;


        }

//        for (int i = 0; i < N; i++) {
//            for (int k = 0; k < N; k++) {
//                System.out.print(board[i][k] + " ");
//            }
//            System.out.println();
//        }

    }

    static void calc(int x, int y, int dir) {
        int origin = board[x][y];
        board[x][y] = 0;

        int rest = 0;

        for (int[] p : P2[dir]) {
            int nx = x + p[0];
            int ny = y + p[1];

            double v = p[2] * 0.01;
            int v2 = (int) Math.floor(origin * v);

//            System.out.println(nx + " " + ny + " " + v + " " + v2);

            if(p[2] != -1) {
                rest += v2;
            }


            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                answer += v2;
                continue;
            }

            if(p[2] == -1){
//                System.out.println(rest);

                board[nx][ny] += (origin - rest);

            }else {

                board[nx][ny] += v2;
            }
        }


    }

    static List<Integer> moveLs = new ArrayList<>();

    static void init() {

        int dir = 0;
        int cnt = 1;

        int check = 0;
        int target = 2;

        for (int i = 0; i < N * N; i++) {

            if(moveLs.size() >= N*N) break;

            for (int k = 0; k < cnt; k++) {
                moveLs.add(dir);
                check++;
            }

            if (check == target) {
                check = 0;
                target += 2;
                cnt++;
            }

            dir++;
            if (dir >= 4) {
                dir = 0;
            }
        }

//        for(Pair p : moveLs){
//            System.out.println(p.x + " " + p.y);
//        }
    }

    private static void input() throws Exception {
//        System.setIn(new FileInputStream("src/codetree/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < N; k++) {
                board[i][k] = Integer.parseInt(st.nextToken());

                tAnswer += board[i][k];
            }
        }
    }
}
