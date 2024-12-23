import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] board;

    static int N, M, K;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(answer.size());
        answer.sort(Comparator.comparingInt(o -> o));
        for (Integer i : answer) {
            System.out.print(i + " ");
        }
    }

    private static void solution() {
        ArrayDeque<Pair> Q = new ArrayDeque<>();
        boolean[][] visited = new boolean[M][N];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == false && board[i][j] == 0) {

                    Q.add(new Pair(i, j));
                    visited[i][j] = true;

                    int cnt = 1;

                    while (!Q.isEmpty()) {

                        Pair cur = Q.poll();

                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];


                            if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                                continue;
                            }
                            if (board[nx][ny] == 1 || visited[nx][ny] == true) {
                                continue;
                            }

//                            System.out.println(nx + "," + ny + " " + cnt);

                            Q.add(new Pair(nx, ny));
                            visited[nx][ny] = true;
                            cnt++;
                        }
                    }

                    answer.add(cnt);

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

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
//                    System.out.println(j + " " + k);
                    board[j][k] = 1;
                }
            }
//            System.out.println();
        }
//        for(int i =0; i < M; i++){
//            for(int j =0; j < N; j++){
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}
