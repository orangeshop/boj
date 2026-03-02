import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, H;
    static int[][] board;
    static int answer = -1;
    static List<Pair> ls = new ArrayList<>();

    static class Pair {
        int r, c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        board = new int[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a][b] = 1;
            board[a][b + 1] = 2;
        }

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if (board[i][j] == 0 && board[i][j + 1] == 0) {
                    ls.add(new Pair(i, j));
                }
            }
        }

        for (int i = 0; i <= 3; i++) {
            dfs(0, 0, i);
            if (answer != -1) {
                System.out.println(answer);
                return;
            }
        }

        System.out.println(-1);
    }

    static void dfs(int count, int idx, int target) {
        if (answer != -1) return;

        if (count == target) {
            if (check()) {
                answer = target;
            }
            return;
        }

        for (int i = idx; i < ls.size(); i++) {
            Pair p = ls.get(i);

            if (board[p.r][p.c] == 0 && board[p.r][p.c + 1] == 0) {
                board[p.r][p.c] = 1;
                board[p.r][p.c + 1] = 2;

                dfs(count + 1, i + 1, target);

                board[p.r][p.c] = 0;
                board[p.r][p.c + 1] = 0;
            }
        }
    }

    static boolean check() {
        for (int i = 1; i <= N; i++) {
            int col = i;
            for (int row = 1; row <= H; row++) {
                if (board[row][col] == 1) {
                    col++;
                } else if (board[row][col] == 2) {
                    col--;
                }
            }
            if (col != i) {
                return false;
            }
        }
        return true;
    }
}