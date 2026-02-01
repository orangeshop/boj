import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int CLEAN = 0;
    static final int DUST = 1;
    static final int WALL = 2;
    static final int ROBOT = 3;

    static int N, M;
    static int[][] board;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int answer;
    static ArrayList<Pair> points;
    static int[][] distMatrix;
    static boolean[] visited;
    static int numDust;

    public static void main(String[] args) throws IOException {
        while (true) {
            if (!input()) break;
        }
        System.out.print(sb.toString());
    }

    private static boolean input() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        if (N == 0 && M == 0) return false;

        board = new int[N][M];
        points = new ArrayList<>();
        Pair robot = null;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int k = 0; k < M; k++) {
                char c = str.charAt(k);
                if (c == '.') board[i][k] = CLEAN;
                else if (c == 'x') board[i][k] = WALL;
                else if (c == '*') {
                    board[i][k] = DUST;
                    points.add(new Pair(i, k));
                } else if (c == 'o') {
                    board[i][k] = ROBOT;
                    robot = new Pair(i, k);
                }
            }
        }

        points.add(0, robot);
        numDust = points.size() - 1;
        distMatrix = new int[points.size()][points.size()];
        
        if (!buildDistanceMatrix()) {
            sb.append("-1\n");
            return true;
        }

        answer = Integer.MAX_VALUE;
        visited = new boolean[points.size()];
        visited[0] = true;
        dfs(0, 0, 0);
        
        sb.append(answer == Integer.MAX_VALUE ? "-1\n" : answer + "\n");
        return true;
    }

    static boolean buildDistanceMatrix() {
        for (int i = 0; i < points.size(); i++) {
            int[][] d = bfs(points.get(i));
            for (int j = 0; j < points.size(); j++) {
                int dist = d[points.get(j).x][points.get(j).y];
                if (dist == -1) return false;
                distMatrix[i][j] = dist;
            }
        }
        return true;
    }

    static int[][] bfs(Pair start) {
        int[][] dists = new int[N][M];
        for (int i = 0; i < N; i++) Arrays.fill(dists[i], -1);
        
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, start.x, start.y));
        dists[start.x][start.y] = 0;

        while (!q.isEmpty()) {
            Pair cur = q.removeFirst();

            for (int dir = 0; dir < 4; dir++) {
                int nx = dx[dir] + cur.x;
                int ny = dy[dir] + cur.y;

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (board[nx][ny] == WALL || dists[nx][ny] != -1) continue;

                dists[nx][ny] = dists[cur.x][cur.y] + 1;
                q.add(new Pair(dists[nx][ny], nx, ny));
            }
        }
        return dists;
    }

    static void dfs(int depth, int currentIdx, int totalDist) {
        if (totalDist >= answer) return;
        
        if (depth == numDust) {
            answer = Math.min(answer, totalDist);
            return;
        }

        for (int i = 1; i < points.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i, totalDist + distMatrix[currentIdx][i]);
                visited[i] = false;
            }
        }
    }

    static class Pair {
        int dis, x, y;
        public Pair(int x, int y) { this.x = x; this.y = y; }
        public Pair(int dis, int x, int y) { this.dis = dis; this.x = x; this.y = y; }
    }
}