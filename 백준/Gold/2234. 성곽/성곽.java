import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int answer1, answer2, answer3;

    static int[][] board;
    static int[][] table;
    static boolean[][] vis;

    static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int[] lam = { 1, 2, 4, 8 };
    static ArrayList<Integer> space = new ArrayList();
    static HashMap<Integer, Set<Integer>> side = new HashMap<>();
    /*
     * 00 01 02
     * 10 11 12
     * 20 21 22
     * */

    static ArrayDeque<Pair> Q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        init();
        solution();

        System.out.println(answer1);
        System.out.println(answer2);
        for (int i = 1; i <= answer1; i++) {
            if (side.get(i) != null) {
                for (int j : side.get(i)) {
                    answer3 = Math.max(space.get(i - 1) + space.get(j - 1), answer3);
                }
            }
        }

        System.out.println(answer3);
    }

    // 0 0  0  0
    // 남 동 북 서

    private static void solution() {
        int num = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (table[i][j] == 0) {
                    bfs(i, j, num++);
                    answer1++;
                }
            }
        }
    }

    private static void bfs(int i, int j, int num) {
        table[i][j] = num;
        int cnt = 0;

        Q.add(new Pair(i, j));
        table[i][j] = num;

        Set<Integer> set = new HashSet<>();

        while (!Q.isEmpty()) {
            Pair pair = Q.poll();
            cnt++;
            for (int dir = 0; dir < 4; dir++) {
                int nx = pair.x + dx[dir];
                int ny = pair.y + dy[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (table[nx][ny] != 0 && table[nx][ny] != num) {
                    set.add(table[nx][ny]);
                    continue;
                }

                if ((board[pair.x][pair.y] & lam[dir]) == 0 && table[nx][ny] == 0) {
                    Q.add(new Pair(nx, ny));
                    table[nx][ny] = num;
                    continue;
                }
            }
        }

        side.put(num, set);
        space.add(cnt);
        answer2 = Math.max(answer2, cnt);

    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        table = new int[N][M];
        vis = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
