import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] board = new int[20][20];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N = 19;
    static boolean[] win = {false, false, false};

    /*
     * 00 01 02
     * 10 11 12
     * 20 21 22
     *
     * */

    static int[] dx = {0, 1, 1, 1};
    static int[] dy = {1, 1, 0, -1};

    static int[][] vis = new int[20][20];

    static List<Pair> answer = new ArrayList<>();

    static class Pair {
        int x, y, z;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();

        answer.forEach(
//                pair -> System.out.println(pair.x + " " + pair.y + " " + pair.z)
                pair -> {
                    win[pair.z] = true;
                }
        );

        if (answer.isEmpty() || (win[1] && win[2])) {
            System.out.println(0);
            return;
        }

        System.out.println(answer.get(0).z);
        System.out.println(answer.get(0).x + " " + answer.get(0).y);
    }

    private static void solution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != 0 && vis[i][j] == 0) {
                    ArrayDeque<Pair> q = new ArrayDeque<>();
                    for (int k = 0; k < 4; k++) {
                        q = new ArrayDeque<>();
                        int cnt = 1;
                        q.add(new Pair(i, j));

                        int lnx = 0;
                        int lny = 0;

                        ArrayDeque<Pair> loot = new ArrayDeque<>();

                        while (!q.isEmpty()) {
                            Pair pair = q.removeFirst();

                            int nx = pair.x + dx[k];
                            int ny = pair.y + dy[k];

                            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                            if (board[nx][ny] != board[i][j]) break;

                            q.add(new Pair(nx, ny));
                            vis[nx][ny] += 1;
                            cnt++;
                            loot.add(new Pair(nx, ny));
                            lnx = nx;
                            lny = ny;
                        }

                        if (cnt == 5) {
//                            System.out.println(i + " " + j);
                            if (k == 3) {
                                answer.add(new Pair(lnx + 1, lny + 1, board[i][j]));
                            } else {
                                answer.add(new Pair(i + 1, j + 1, board[i][j]));
                            }
                        }
                        else if (cnt > 5) {
                            while (!loot.isEmpty()) {
                                Pair pair = loot.removeFirst();
                                vis[pair.x][pair.y] = Integer.MIN_VALUE;
                            }
                        }
                        else{
                            while (!loot.isEmpty()) {
                                Pair pair = loot.removeFirst();
                                vis[pair.x][pair.y] --;
                            }
                        }
                    }
                }
            }
        }
    }


    private static void input() throws IOException {

        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void see() {
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
