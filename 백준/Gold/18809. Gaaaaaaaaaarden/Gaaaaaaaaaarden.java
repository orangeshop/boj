import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, G, R;


    static int[][] board;

    static List<Pair> seedList = new ArrayList<>();

    static int answer = Integer.MIN_VALUE;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};


    public static void main(String[] args) throws IOException {
        String inputFirst = br.readLine();
        st = new StringTokenizer(inputFirst);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < M; k++) {
                board[i][k] = Integer.parseInt(st.nextToken());

                if (board[i][k] == 2) {
                    seedList.add(new Pair(i, k));
                }
            }
        }

//        see();

        int[] dfsList = new int[seedList.size()];
        dfs(0, 0, 0, dfsList);

        System.out.println(answer);
    }

    static int solve(int[] tls) {

        Queue<Pair> Q = new ArrayDeque<>();
        int[][] vis = new int[N][M];
        int result = 0;

        for (int i =0; i < tls.length; i++) {
            if(tls[i] == 0){
                continue;
            }
            Pair cur = seedList.get(i);
            Q.add(new Pair(cur.x, cur.y));
            vis[cur.x][cur.y] = tls[i];
        }

        while (!Q.isEmpty()){
            Pair cur = Q.peek();
            Q.poll();

            if(vis[cur.x][cur.y] == 25000){
                continue;
            }

            for(int dir = 0; dir < 4; dir++){
                int nx = dx[dir] + cur.x;
                int ny = dy[dir] + cur.y;

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if(board[nx][ny] == 0 || vis[nx][ny] == 25000){
                    continue;
                }

                if(vis[nx][ny] == 0){
                    if(vis[cur.x][cur.y] < 0){
                        vis[nx][ny] = vis[cur.x][cur.y] - 1;
                        Q.add(new Pair(nx,ny));
                    }else{
                        vis[nx][ny] = vis[cur.x][cur.y] + 1;
                        Q.add(new Pair(nx,ny));
                    }
                }else{
                    if(vis[cur.x][cur.y] < 0){
                        if(vis[nx][ny] + vis[cur.x][cur.y] - 1 == 0){
                            result += 1;
                            vis[nx][ny] = 25000;
                        }
                    }else{
                        if(vis[nx][ny] + vis[cur.x][cur.y] + 1 == 0){
                            result += 1;
                            vis[nx][ny] = 25000;
                        }
                    }
                }
            }

        }

        return result;
    }

    static void dfs(int depth, int rCnt, int gCnt, int[] tls) {


        if (depth == seedList.size()) {
            if (rCnt == R && gCnt == G) {
                answer = Math.max(solve(tls), answer);
            }
            return;
        }

        tls[depth] = 1;
        dfs(depth + 1, rCnt + 1, gCnt, tls);
        tls[depth] = -1;
        dfs(depth + 1, rCnt, gCnt + 1, tls);
        tls[depth] = 0;
        dfs(depth + 1, rCnt, gCnt, tls);

    }

    static void see() {
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                System.out.print(board[i][k] + " ");
            }
            System.out.println();
        }

        for (Pair p : seedList) {
            System.out.println(p.x + " " + p.y);
        }
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
