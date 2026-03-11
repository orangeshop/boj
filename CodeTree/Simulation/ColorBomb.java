package codetree;

import java.io.*;
import java.util.*;

public class ColorBomb {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[][] board;
    static int answer = 0;

    static int[][] P = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static boolean findBoomAndFire() {
        Boom bestBoom = null;
        boolean[][] visited = new boolean[N][N]; // 일반 폭탄 방문 처리

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                // 일반 폭탄(1~M)이고 아직 방문하지 않은 경우에만 BFS 시작
                if (board[i][k] <= 0 || visited[i][k]) continue;

                Boom currentBoom = bfs(i, k);

                // 폭탄 묶음은 2개 이상이어야 함
                if (currentBoom.ls.size() < 2) continue;

                // 우선순위 비교 (개수 -> 빨간색 적은 순 -> 행 큰 순 -> 열 작은 순)
                if (bestBoom == null || currentBoom.isBetterThan(bestBoom)) {
                    bestBoom = currentBoom;
                }

                // 일반 폭탄들만 방문 처리 유지 (빨간색은 중복 방문 가능해야 함)
                for (Pair p : currentBoom.ls) {
                    if (board[p.x][p.y] > 0) visited[p.x][p.y] = true;
                }
            }
        }

        if (bestBoom == null) return false;

        // 폭탄 제거
        for (Pair p : bestBoom.ls) {
            board[p.x][p.y] = -2;
        }
        answer += bestBoom.ls.size() * bestBoom.ls.size();

        return true;
    }

    static Boom bfs(int startX, int startY) {
        int color = board[startX][startY];
        ArrayDeque<Pair> q = new ArrayDeque<>();
        ArrayList<Pair> group = new ArrayList<>();
        boolean[][] localVis = new boolean[N][N]; // 이 BFS 내에서의 방문

        q.add(new Pair(startX, startY));
        localVis[startX][startY] = true;
        group.add(new Pair(startX, startY));

        int redCount = 0;
        int stdX = startX, stdY = startY;

        while (!q.isEmpty()) {
            Pair cur = q.removeFirst();

            for (int[] nxt : P) {
                int nx = cur.x + nxt[0];
                int ny = cur.y + nxt[1];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (localVis[nx][ny]) continue;

                // 같은 색 폭탄이거나 빨간색 폭탄(0)인 경우
                if (board[nx][ny] == color || board[nx][ny] == 0) {
                    localVis[nx][ny] = true;
                    Pair nxtP = new Pair(nx, ny);
                    q.add(nxtP);
                    group.add(nxtP);

                    if (board[nx][ny] == 0) {
                        redCount++;
                    } else {
                        // 기준점 갱신: 행이 크고, 같다면 열이 작은 것
                        if (nx > stdX || (nx == stdX && ny < stdY)) {
                            stdX = nx;
                            stdY = ny;
                        }
                    }
                }
            }
        }
        return new Boom(stdX, stdY, redCount, group);
    }

    static void gravity() {
        for (int k = 0; k < N; k++) {
            int lastPos = N - 1;
            for (int i = N - 1; i >= 0; i--) {
                if (board[i][k] == -1) { // 돌을 만나면 그 위로 쌓이도록 함
                    lastPos = i - 1;
                } else if (board[i][k] >= 0) { // 0(빨간색) 또는 일반 폭탄
                    int tempColor = board[i][k];
                    board[i][k] = -2;
                    board[lastPos--][k] = tempColor;
                }
            }
        }
    }

    static void cycleBoard() {
        int[][] tmp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                tmp[N - 1 - k][i] = board[i][k];
            }
        }
        board = tmp;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        if (!st.hasMoreTokens()) return;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < N; k++) {
                board[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            if (!findBoomAndFire()) break;
            gravity();
            cycleBoard();
            gravity();
        }

        System.out.println(answer);
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Boom {
        int stdX, stdY, redCnt;
        ArrayList<Pair> ls;

        public Boom(int stdX, int stdY, int redCnt, ArrayList<Pair> ls) {
            this.stdX = stdX;
            this.stdY = stdY;
            this.redCnt = redCnt;
            this.ls = ls;
        }

        public boolean isBetterThan(Boom other) {
            if (this.ls.size() != other.ls.size()) return this.ls.size() > other.ls.size();
            if (this.redCnt != other.redCnt) return this.redCnt < other.redCnt;
            if (this.stdX != other.stdX) return this.stdX > other.stdX;
            return this.stdY < other.stdY;
        }
    }
}