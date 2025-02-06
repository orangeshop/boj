import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;

    static int[][] map;
    static int[][] dp;

    static int answer = Integer.MIN_VALUE;
    static Pair stp = new Pair(-1, -1);

    /*
     * 00 01 02
     * 10 11 12
     * 20 21 22
     * */

    static int[] dx = {-1, 0, 1};
    static int[] dy = {-1, -1, -1};

    static class Pair {
        int x, y;
        int cnt;

        public Pair(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.print(answer);
    }

    private static void solution() {

//        System.out.println(stp.x + " " + stp.y);

        for (int j = stp.y + 1; j < M; j++) {
            for (int i = 0; i < N; i++) {
                if (map[i][j] == 1) continue;

                for (int dir = 0; dir < 3; dir++) {
                    int nx = i + dx[dir];
                    int ny = j + dy[dir];


                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
//                    if (dp[i][j] == -1) continue;

//                    System.out.println(i + " " + j + " " + nx + " " + ny);

                    if (map[i][j] == 4 && dp[nx][ny] != -1) {
//                        System.out.println("**");
                        dp[i][j] = Math.max(dp[i][j], dp[nx][ny] + 1);
                    }

                    if ((map[i][j] == 3 || map[i][j] == 0) && dp[nx][ny] != -1) {
                        dp[i][j] = Math.max(dp[i][j], dp[nx][ny]);
                    }
                }

//                System.out.println(Arrays.deepToString(dp));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 3) continue;
                answer = Math.max(answer, dp[i][j]);
            }
        }

        if (answer == Integer.MIN_VALUE) {
            answer = -1;
        }
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'R') {
                    map[i][j] = 2;
                    dp[i][j] = 0;
                    stp = new Pair(i, j);
                } else if (str.charAt(j) == 'C') {
                    map[i][j] = 4;
                } else if (str.charAt(j) == '#') {
                    map[i][j] = 1;
                } else if (str.charAt(j) == 'O') {
                    map[i][j] = 3;
                    dp[i][j] = Integer.MIN_VALUE;
                } else {
                    map[i][j] = 0;
                }
            }
        }
    }
}

/*
*
*
2 4
CCCO
RC##

* */