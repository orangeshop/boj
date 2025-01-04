

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;

    static int[][] board;

    static List<Pair>[] ls = new List[25];
    static boolean[] vis = new boolean[25];

    static boolean[] lchecked = new boolean[25];;
    static boolean[] rchecked = new boolean[25];;

    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }


    private static void dfs(int depth, int cnt) {

        if (depth >= 2 * N - 1) {
            answer = Math.max(answer, cnt);
            return;
        }

        for (int i = 0; i < ls[depth].size(); i++) {

            int lch = ls[depth].get(i).x + ls[depth].get(i).y;
            int rch = (N+1) + ls[depth].get(i).x - ls[depth].get(i).y;

//            if (ch < 0) {
//                ch += N;
//            }

//            if (!vis[ch]) {
//                vis[ch] = true;
//                dfs(depth + 2, cnt + 1);
//                vis[ch] = false;
//            }

            if(!lchecked[lch] && !rchecked[rch]) {
                lchecked[lch] = true;
                rchecked[rch] = true;
                dfs(depth + 2, cnt + 1);
                lchecked[lch] = false;
                rchecked[rch] = false;
            }
        }

        dfs(depth + 2, cnt);

    }


    private static void solution() {

        dfs(0, 0);
        int t = answer;
        answer = 0;
        dfs(1, 0);
        System.out.println(answer + t);

        /*
         * 00 01 02 03 04
         * 10 11 12 13 14
         * 20 21 22 23 24
         * 30 31 32 33 34
         * 40 41 42 43 44

         * lcheck []
         * rcheck [(N-1)+i-j]
         * */
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());


        board = new int[N][N];

        for (int i = 0; i < 25; i++) {
            ls[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (board[i][j] == 1) {
                    ls[i + j].add(new Pair(i, j));
                }
            }
        }
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
