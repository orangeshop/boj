import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M;

    static int[][] board;

    static ArrayDeque<Pair> Q = new ArrayDeque<>();


    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        init();
        System.out.print(solution());
    }

    private static int solution() {

        int time = 0;
        boolean loop = true;

        while (loop) {

            List<Pair> tls = new ArrayList<>();


            int[][] vis = new int[N][M];
            Q.add(new Pair(0, 0));
            vis[0][0] = -1;

            while (!Q.isEmpty()) {
                Pair cur = Q.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                    if (vis[nx][ny] < 0) continue;

                    if (board[nx][ny] == 1) {
                        vis[nx][ny] += 1;
                        if(vis[nx][ny] >= 2){
                            tls.add(new Pair(nx, ny));
                        }
                        continue;
                    }

                    Q.add(new Pair(nx, ny));
                    vis[nx][ny] = -1;
                }
            }

            for (Pair pair : tls) {
//                System.out.println(pair.x + " " + pair.y);
                board[pair.x][pair.y] = 0;
            }
//
//            for(int i=0; i<N; i++){
//                for(int j=0; j<M; j++){
//                    System.out.print(board[i][j] + " ");
//                }
//                System.out.println();
//            }
//
//            System.out.println("----------");

            if(tls.size() == 0){
                loop = false;
                break;
            }
            time++;
        }

        return time;
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
