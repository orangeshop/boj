
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] board = new int[9][9];
    static int N = 9;

    static List<Pair> ls = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {

        dfs(0);
    }

    static boolean ch = false;

    private static void dfs(int depth) {

        if(depth == ls.size()){
            see();
            ch = true;
            return;
        }

        Pair cur = ls.get(depth);

        for(int i =1; i <= N; i++){

            board[cur.x][cur.y] = i;
            if(check(cur.x, cur.y)){
                dfs(depth + 1);
            }
            if(ch) return;
            board[cur.x][cur.y] = 0;
        }
    }

    private static boolean check(int x, int y) {
        for(int i =0; i < 9; i++){
           if(board[x][i] == board[x][y] && i != y) return false;
           if(board[i][y] == board[x][y] && i != x) return false;
        }

        int sqX = (x / 3) * 3;
        int sqY = (y / 3) * 3;

        for(int i = sqX; i < sqX + 3; i++){
            for(int j = sqY; j < sqY + 3; j++){
                if(i == x && j == y) continue;
                if(board[i][j] == board[x][y]) return false;
            }
        }

        return true;

    }

    private static void init() throws IOException {

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < N; k++) {
                board[i][k] = Integer.parseInt(st.nextToken());

                if (board[i][k] == 0) {
                    ls.add(new Pair(i, k));
                }
            }
        }


    }

    private static void see() {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j ++) {
                System.out.print(board[i][j] + " ");
            }

            System.out.println();
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
