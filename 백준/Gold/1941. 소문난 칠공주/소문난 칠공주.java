import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[][] map = new int[6][6];
    static boolean[][] vis = new boolean[6][6];

    static List<Pair> Sls = new ArrayList<>();
    static List<Pair> Yls = new ArrayList<>();


    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(answer);
    }

    private static void solution() {
//        System.out.println(Arrays.deepToString(map));
        List<Pair> s = new ArrayList<>();

        Sdfs(0, s);

    }

    /*
     * Y = 1
     * S = 0
     *
     * S가 아다솜파
     * cnt1 이다솜
     *
     *
     * */

    private static void solve(List<Pair> s, List<Pair> y){
//        System.out.println("solve");
        int[][] board = new int[6][6];
        boolean[][] vis = new boolean[6][6];
        for (Pair pair : s) {
//            System.out.println(pair.x + " " + pair.y);
            board[pair.x][pair.y] = 1;
        }

//        System.out.println("------");

        for (Pair pair : y) {
//            System.out.println(pair.x + " " + pair.y);
            board[pair.x][pair.y] = 1;
        }

        ArrayDeque<Pair> q = new ArrayDeque<>();

        q.add(s.get(0));
        vis[s.get(0).x][s.get(0).y] = true;
        int cnt = 1;
        while (!q.isEmpty()) {
            Pair cur = q.removeFirst();

            for(int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                if(board[nx][ny] != 1 || vis[nx][ny]) continue;

                q.add(new Pair(nx, ny));
                vis[nx][ny] = true;
                cnt++;
            }
        }

        if(cnt == 7){
            answer++;
        }
    }

    private static void Ydfs(int depth, List<Pair> y, int max, List<Pair> s) {
        if (depth >= Yls.size()) {

            if(s.size() + y.size() == 7) {
                solve(s, y);
            }
            return;
        }

        y.add(Yls.get(depth));
        Ydfs(depth + 1, y, max, s);
        y.remove(y.size() - 1);

        Ydfs(depth + 1, y, max, s);
    }


    private static void Sdfs(int depth, List<Pair> s) {


        if (depth >= Sls.size()) {
            if(s.size() < 4) return;
            List<Pair> l = new ArrayList<>();
            Ydfs(0, l, 7 - s.size(), s);

            return;
        }


        s.add(Sls.get(depth));
        Sdfs(depth + 1, s);
        s.remove(s.size() - 1);

        Sdfs(depth + 1, s);
    }

    private static void init() throws IOException {

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 5; j++) {
                if (str.charAt(j) == 'Y') {
                    map[i][j] = 1;
                    Yls.add(new Pair(i, j));
                } else {
                    map[i][j] = 0;
                    Sls.add(new Pair(i, j));
                }
            }
        }
    }
}
