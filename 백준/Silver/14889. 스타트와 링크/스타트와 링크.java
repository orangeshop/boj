

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[][] board;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < N; k++) {
                board[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, new boolean[N]);

        System.out.println(answer);
    }

    static void dfs(int depth, int cnt, boolean[] vis) {

        if (cnt == N / 2) {
            answer = Math.min(answer, clac(vis));

            return;
        }
        if (depth >= N) return;

        vis[depth] = true;
        dfs(depth + 1, cnt + 1, vis);
        vis[depth] = false;

        dfs(depth + 1, cnt, vis);

    }

    static int clac(boolean[] vis){

        int aNum = 0;

        int bNum = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (vis[i] && vis[j]) {
                    aNum += board[i][j] + board[j][i];
                } else if (!vis[i] && !vis[j]) {
                    bNum += board[i][j] + board[j][i];
                }
            }
        }


        return Math.abs(aNum - bNum);
    }
}
