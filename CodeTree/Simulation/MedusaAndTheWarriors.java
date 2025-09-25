import java.io.*;
import java.util.*;

public class MedusaAndTheWarriors {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;


    static int[][] board;
    static int[][] dist;

    static final int[][] P1 = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static final int[][] P2 = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    static final int[][][] VISION = {
            {{-1, -1}, {-1, 0}, {-1, 1}},
            {{1, -1}, {1, 0}, {1, 1}},
            {{-1, -1}, {0, -1}, {1, -1}},
            {{-1, 1}, {0, 1}, {1, 1}}
    };

    static boolean inRange(int x, int y, int N) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    static int manhattan(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static void main(String[] args) throws IOException {
        input();

    }


    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());


        Pair start = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        Pair end = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());

        ArrayList<Pair> init = new ArrayList<>(M);
        for (int i = 0; i < M; i++) {

            init.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dist = bfsDistFromTarget(board, end);

        WarriorMap wm = new WarriorMap(N, init);

        int mx = start.x, my = start.y;
        while (!(mx == end.x && my == end.y)) {
            int[] nxt = moveMedusaOne(dist, mx, my);

            mx = nxt[0];
            my = nxt[1];

            if (mx == end.x && my == end.y){
                System.out.println(0);
                return;
            }

            int bestSeen = -1;
            int[][] bestVision = null;

            for(int dir = 0; dir < 4; dir++){
                VisionResult vr = buildVision(N,wm, mx, my, VISION[dir]);
                if(vr.seen > bestSeen){
                    bestSeen = vr.seen;
                    bestVision = vr.map;
                }
            }

            int[] res = wm.moveAll(bestVision, mx,my);
            int steps = res[0], attackers = res[1];

            System.out.println(steps + " " + bestSeen + " " + attackers);
        }
    }

    static class WarriorMap{
        final int N;
        final ArrayList<Pair> warriors;
        final HashSet<Integer>[][] cells;

        WarriorMap(int N, List<Pair> init){
            this.N = N;
            warriors = new ArrayList<>(init);
            cells = new HashSet[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    cells[i][j] = new HashSet<>();
                }
            }
            for (int i =0; i < warriors.size(); i++){
                Pair w = warriors.get(i);
                cells[w.x][w.y].add(i);
            }
        }

        void removeWarrior(int idx){
            int last = warriors.size() - 1;
            Pair w = warriors.get(idx);
            cells[w.x][w.y].remove(idx);

            if (idx != last){
                Pair lastW = warriors.get(last);
                warriors.set(idx, lastW);
                cells[lastW.x][lastW.y].remove(last);
                cells[lastW.x][lastW.y].add(idx);
            }
            warriors.remove(last);
        }

        int removeSameCell(int x, int y){
            int removed = 0;
            int i =0;
            while(i < warriors.size()){
                Pair w = warriors.get(i);
                if(w.x == x && w.y == y){
                    removeWarrior(i);
                    removed++;
                } else i++;
            }
            return removed;
        }

        int moveOnce(int idx, int mx, int my, int[][] vision, int[][] pri){
            Pair w = warriors.get(idx);
            int x = w.x;
            int y = w.y;
            int d0 = manhattan(x,y,mx,my);

            for(int[] d: pri){
                int nx = x + d[0];
                int ny = y + d[1];
                if(!inRange(nx,ny,N)) continue;
                if(vision[nx][ny] == 1) continue;
                if(manhattan(nx,ny,mx,my) < d0){
                    cells[x][y].remove(idx);
                    warriors.get(idx).x = nx;
                    warriors.get(idx).y = ny;
                    cells[nx][ny].add(idx);
                    return 1;
                }
            }
            return 0;
        }

        boolean isWarriorAt(int x, int y){
            return !cells[x][y].isEmpty();
        }

        int[] moveAll(int[][] vision, int mx, int my){
            removeSameCell(mx,my);

            int steps = 0;
            for(int i =0; i < warriors.size(); i++){
                Pair w = warriors.get(i);
                if(vision[w.x][w.y] == 0){
                    steps += moveOnce(i, mx, my, vision, P1);
                    steps += moveOnce(i, mx, my, vision, P2);
                }
            }
            int attackers = removeSameCell(mx, my);
            return new int[]{steps, attackers};
        }

    }

    private static int[][] bfsDistFromTarget(int[][] board, Pair end) {
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(dist[i], -1);

        ArrayDeque<Pair> q = new ArrayDeque<>();

        q.add(end);
        dist[end.x][end.y] = 0;

        while (!q.isEmpty()) {
            Pair cur = q.removeFirst();
            for (int[] d : P1) {
                int nx = cur.x + d[0];
                int ny = cur.y + d[1];

                if (!inRange(nx, ny, N) || board[nx][ny] == 1 || dist[nx][ny] != -1) continue;
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                q.add(new Pair(nx, ny));
            }
        }
        return dist;
    }

    static int[] moveMedusaOne(int[][] dist, int x, int y) {
        for (int[] d : P1) {
            int nx = d[0] + x;
            int ny = d[1] + y;
            if (inRange(nx, ny, N) && dist[nx][ny] != -1 && dist[nx][ny] < dist[x][y]) {
                return new int[]{nx, ny};
            }
        }
        return new int[]{x, y};
    }

    static class VisionResult {
        int[][] map;
        int seen;

        VisionResult(int[][] map, int seen) {
            this.map = map;
            this.seen = seen;
        }
    }

    static VisionResult buildVision(int N, WarriorMap wm, int mx, int my, int[][] dxys3) {
        int[][] vis = new int[N][N];
        int seen = 0;

        ArrayDeque<Pair> q = new ArrayDeque<>();
        ArrayDeque<Pair> occ = new ArrayDeque<>();

        q.add(new Pair(mx, my));

        while (!q.isEmpty()) {
            Pair cur = q.removeFirst();

            for (int dir = 0; dir < 3; dir++) {
                int nx = cur.x + dxys3[dir][0];
                int ny = cur.y + dxys3[dir][1];

                if (!inRange(nx, ny, N) || vis[nx][ny] == 1) continue;

                if (wm.isWarriorAt(nx, ny)) {
                    int type;
                    if (nx == mx || ny == my) type = 1;
                    else {
                        boolean sameSign = (nx - mx) * dxys3[0][0] > 0 && (ny - my) * dxys3[0][1] > 0;
                        type = sameSign ? 0 : 2;
                    }
                    occ.add(new Pair(nx, ny, type));
                }
                vis[nx][ny] = 1;
                q.add(new Pair(nx, ny));
            }
        }

        while (!occ.isEmpty()) {
            Pair cur = occ.removeFirst();
            int x = cur.x;
            int y = cur.y;
            int t = cur.z;

            for (int dir = 0; dir < 3; dir++) {
                if (t == 1 && dir != 1) continue;
                if (t == 0 && dir == 2) continue;
                if (t == 2 && dir == 0) continue;

                int nx = cur.x + dxys3[dir][0];
                int ny = cur.y + dxys3[dir][1];
                if (!inRange(nx, ny, N) || vis[nx][ny] == 0) continue;
                vis[nx][ny] = 0;
                occ.add(new Pair(nx, ny, t));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (vis[i][j] == 1){
                    seen += wm.cells[i][j].size();
                }
            }
        }

        return new VisionResult(vis, seen);
    }


    static class Pair {
        int x, y, z;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
