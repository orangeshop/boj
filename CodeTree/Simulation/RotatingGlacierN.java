package CodeTree_new;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class RotatingGlacierN {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, Q;
    static int[][] board;
    static int[][] P = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static int M = 0;

    static ArrayDeque<Integer> qad = new ArrayDeque<>();

    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        while (!qad.isEmpty()) {
            calc(qad.removeFirst(), M);

            melt(M);
        }

        int answer = 0;

        for (int i = 0; i < M; i++) {
            for (int k = 0; k < M; k++) {
//                System.out.print(board[i][k] + " ");
                answer += board[i][k];
            }
//            System.out.println();
        }

        System.out.println(answer);


        int maxS = 0;
        boolean[][] vis = new boolean[M][M];

        for(int i =0; i < M; i++){
            for(int k =0; k < M; k++){
                if(board[i][k] != 0 && !vis[i][k]){
                    int cnt = 1;
                    vis[i][k] = true;
                    ArrayDeque<Pair> q = new ArrayDeque<>();
                    q.add(new Pair(i,k));

                    while (!q.isEmpty()){
                        Pair cur = q.removeFirst();

                        for(int[] nxt: P){
                            int nx = cur.x + nxt[0];
                            int ny = cur.y + nxt[1];

                            if(nx < 0 || nx >= M || ny < 0 || ny >= M) continue;
                            if(vis[nx][ny] || board[nx][ny] == 0) continue;

                            q.add(new Pair(nx, ny));
                            vis[nx][ny] = true;
                            cnt++;
                        }
                    }

                    maxS = Math.max(maxS, cnt);
                }
            }
        }

        System.out.println(maxS);
    }

    // 회전 로직 구현
    // 시계 방향


    // 재귀로 위치 탐색

    // 1 -> 2
    // 2 -> 4
    // 3 ->
    // depth = qad.fist
    // size = M
    // 이제 depth * 2 만큼 size를 내리는 거지

    static int pow(int a, int b) {
        return (int) Math.pow(a, b);
    }

    static void rotate(int s, int[][] tBoard, int x, int y) {

        int[][] tmp = new int[s][s];

        int ttx = 0;
        int tty = 0;
        for (int i = x; i < x + s; i++) {
            for (int k = y; k < y + s; k++) {
                // 00 -> 03
                // 01 -> 13
                // 02 -> 23
                // 03 -> 33
//                tBoard
//                System.out.println(ttx + " " + tty + " : " + i + " " + k);
                tmp[ttx][tty] = board[i][k];
                tty++;
//                System.out.println(k + " " + ((s - 1) - i) + " : " + i + " " + k);
            }
            ttx++;
            tty = 0;
        }

        int[][] ttmp = new int[s][s];
        for (int i = 0; i < s; i++) {
            for (int k = 0; k < s; k++) {
                ttmp[k][((s - 1) - i)] = tmp[i][k];
            }
        }

        int tx = 0;
        int ty = 0;
        for (int i = x; i < x + s; i++) {
            for (int k = y; k < y + s; k++) {
                tBoard[i][k] = ttmp[tx][ty];
                ty++;
            }
            tx++;
            ty = 0;
        }

    }

    static void melt(int s) {
        int[][] tBoard = new int[s][s];

        for (int i = 0; i < s; i++) {
            for (int k = 0; k < s; k++) {
                int cnt = 0;



                for (int[] nxt : P) {
                    int nx = i + nxt[0];
                    int ny = k + nxt[1];

                    if (nx < 0 || nx >= s || ny < 0 || ny >= s) {
                        continue;
                    }

                    if (board[nx][ny] == 0) continue;

                    cnt++;

                }

                if (cnt >= 3) {
                    tBoard[i][k] = board[i][k];
                } else {
                    tBoard[i][k] = Math.max(board[i][k] - 1, 0);
                }
            }
        }

        board = tBoard.clone();
    }

    static void calc(int target, int size) {
        if (pow(2, target) == size) {
            // 여기서 부터 이동 0,0 부터 해당 사이즈 만큼 회전

            int[][] tBoard = new int[M][M];
            for (int i = 0; i < M; i += size) {
                for (int k = 0; k < M; k += size) {
//                    System.out.println(i + " " + k);
                    rotate(size, tBoard, i, k);
                }
            }

            board = tBoard.clone();
            return;
        }

        calc(target, size / 2);

    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        M = (int) Math.pow(2, N);

        board = new int[M][M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < M; k++) {
                board[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            qad.add(Integer.parseInt(st.nextToken()));
        }


    }
}
