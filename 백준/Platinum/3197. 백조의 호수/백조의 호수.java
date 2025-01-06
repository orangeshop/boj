
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;

    static int[][] board;
    static boolean[][] vis;
    static boolean[][] bVis;
    static int[][] count;

    static ArrayDeque<Pair> waterQ = new ArrayDeque<>();
    static ArrayDeque<Pair> birdQ = new ArrayDeque<>();
    static ArrayDeque<Pair> Q = new ArrayDeque<>();
    static ArrayDeque<Pair> bbQ = new ArrayDeque<>();

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static Pair t1 = new Pair(-1, -1, -1);
    static Pair t2 = new Pair(-1, -1, -1);


    public static void main(String[] args) throws IOException {
        init();

        System.out.println(solution());
    }

    private static int solution() {
        /*
         * 얼음 깨는 거 따로
         *
         * 백조 따로
         *
         *
         *
         * */

        Q.add(new Pair(-1, -1));

        int time = 0;

        while (!Q.isEmpty()) {

            waterQ.addAll(Q);
            Q.clear();

            while (!waterQ.isEmpty()) {
                Pair cur = waterQ.poll();


                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                        continue;
                    }
                    if (vis[nx][ny]) {
                        continue;
                    }

                    if (board[nx][ny] == 1) {
                        board[nx][ny] = 0;
                    }

//                    System.out.println("water : " + nx + " " + ny);

                    Q.add(new Pair(nx, ny));
                    vis[nx][ny] = true;
                }
            }

//            System.out.println();

            birdQ.addAll(bbQ);
            bbQ.clear();

            while (!birdQ.isEmpty()) {

                Pair cur = birdQ.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                        continue;
                    }

                    if (count[cur.x][cur.y] < 0 && count[nx][ny] > 0 ||
                            count[cur.x][cur.y] > 0 && count[nx][ny] < 0
                    ) {
//                        System.out.println("**");
                        return ++time;
                    }

                    if (bVis[nx][ny] || board[nx][ny] == 1) {
                        continue;
                    }

                    if (cur.type == 1) {
                        count[nx][ny] = count[cur.x][cur.y] + 1;
                    } else if (cur.type == -1) {
                        count[nx][ny] = count[cur.x][cur.y] - 1;
                    }


//                    System.out.println("bird : " + cur.type + " " + nx + " " + ny);


                    bbQ.add(new Pair(cur.type, nx, ny));
                    birdQ.add(new Pair(cur.type, nx, ny));
                    bVis[nx][ny] = true;
                }
            }

//            see();
//            System.out.println();

            if (!Q.isEmpty()) {
                time++;
            }

        }

        return time;
    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        vis = new boolean[N][M];
        bVis = new boolean[N][M];
        count = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < M; j++) {

                if (s.charAt(j) == 'X') {
                    board[i][j] = 1;
                } else if (s.charAt(j) == '.') {
                    board[i][j] = 0;
                    waterQ.add(new Pair(i, j));
                    vis[i][j] = true;
                } else if (s.charAt(j) == 'L') {

                    if (t1.x == -1) {
                        t1 = new Pair(1, i, j);
                        birdQ.add(t1);
                        count[i][j] = 1;
                    } else {
                        birdQ.add(new Pair(-1, i, j));
                        count[i][j] = -1;
                    }


                    waterQ.add(new Pair(i, j));
                    vis[i][j] = true;
                    bVis[i][j] = true;
                }
            }
        }

//        see();
//
//        System.out.println(t1.x + " " + t1.y);
//        System.out.println(t2.x + " " + t2.y);
    }

    static void see() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(count[i][j] + " ");
            }
            System.out.println();
        }
    }

    static class Pair {
        int type, x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Pair(int type, int x, int y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }
    }
}