

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[][] board;
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        board = new int[N + 1][N + 1];
        grid = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 1; k <= N; k++) {
                grid[i][k] = Integer.parseInt(st.nextToken());
                board[i][k] = grid[i][k] + board[i - 1][k] + board[i][k - 1] - board[i - 1][k - 1];
            }
        }

        long answer = 0;

        for (int i = 1; i <= N; i++) {
            for (int k = 1; k <= N; k++) {
                answer += solve(i, k);
            }
        }

        System.out.println(answer);
    }

    static long solve(int r, int c) {
        long cnt = 0;
        Map<Integer, Integer> leftUp = new HashMap<>();
        Map<Integer, Integer> rightDown = new HashMap<>();
        Map<Integer, Integer> rightUp = new HashMap<>();
        Map<Integer, Integer> leftDown = new HashMap<>();

       for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                int sum = getSum(i, j, r, c);
                leftUp.put(sum, leftUp.getOrDefault(sum, 0) + 1);
            }
        }

        for (int i = r + 1; i <= N; i++) {
            for (int j = c + 1; j <= N; j++) {
                int sum = getSum(r + 1, c + 1, i, j);
                rightDown.put(sum, rightDown.getOrDefault(sum, 0) + 1);
            }
        }

        for (Integer sum : leftUp.keySet()) {
            if (rightDown.containsKey(sum)) {
                cnt += (long) leftUp.get(sum) * rightDown.get(sum);
            }
        }

        for (int i = 1; i <= r; i++) {
            for (int j = c + 1; j <= N; j++) {
                int sum = getSum(i, c + 1, r, j);
                rightUp.put(sum, rightUp.getOrDefault(sum, 0) + 1);
            }
        }

        for (int i = r + 1; i <= N; i++) {
            for (int j = 1; j <= c; j++) {
                int sum = getSum(r + 1, j, i, c);
                leftDown.put(sum, leftDown.getOrDefault(sum, 0) + 1);
            }
        }

        for (Integer sum : rightUp.keySet()) {
            if (leftDown.containsKey(sum)) {
                cnt += (long) rightUp.get(sum) * leftDown.get(sum);
            }
        }

        return cnt;

    }

    static int getSum(int x1, int y1, int x2, int y2) {
        return board[x2][y2] - board[x1 - 1][y2] - board[x2][y1 - 1] + board[x1 - 1][y1 - 1];
    }
}
