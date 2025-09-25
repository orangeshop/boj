import java.io.*;
import java.util.*;

public class MintChocolateMilk {

    static BufferedReader br;
    static StringTokenizer st;

    /*
     * 00 01 02
     * 10 11 12
     * 20 21 22
     *
     */
    static final int[][] P1 = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static Value[][] board;

    static class Value {
        // 0 0 0
        // t c m
        //
        int type = 0;
        int v;
        boolean defenced = false;

        Value() {
        }

        void setUp(String str) {
            if (str.equals("T")) {
                this.type |= (1 << 2);
            }

            if (str.equals("C")) {
                this.type |= (1 << 1);
            }

            if (str.equals("M")) {
                this.type |= (1 << 0);
            }
        }
    }

    static class Pair {
        int x, y;
        int z;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

    }

    static int N, M;

    public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("src/algo1/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));

        input();
        solution();
    }

    private static void solution() {

        for (int i = 0; i < M; i++) {
            morningTime();

            luanchTime();

            dinnerTime();

            resultCalc();
        }
    }

    static void resultCalc() {
        int tcm = 0; // 111 -> 7
        int tc = 0; // 110 -> 6
        int tm = 0; // 101 -> 5
        int cm = 0; // 011 -> 3
        int t = 0; // 100 -> 4
        int c = 0; // 010 -> 2
        int m = 0; // 001 -> 1
        
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                if (board[i][k].type == 7) {
                    tcm += board[i][k].v;
                }
                if (board[i][k].type == 3) {
                    cm += board[i][k].v;
                }
                if (board[i][k].type == 5) {
                    tm += board[i][k].v;
                }
                if (board[i][k].type == 6) {
                    tc += board[i][k].v;
                }
                if (board[i][k].type == 4) {
                    t += board[i][k].v;
                }
                if (board[i][k].type == 2) {
                    c += board[i][k].v;
                }
                if (board[i][k].type == 1) {
                    m += board[i][k].v;
                }

            }
        }

        System.out.println(tcm + " " + tc + " " + tm + " " + cm + " " + m + " " + c + " " + t);
    }

    static void morningTime() {
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                board[i][k].v++;
            }
        }
    }

    static ArrayList<Pair> als = new ArrayList<>();

    static void luanchTime() {
        als.clear();

        boolean[][] vis = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                if (vis[i][k]) continue;
                ArrayDeque<Pair> q = new ArrayDeque<>();
                ArrayList<Pair> result = new ArrayList<>();
                int cnt = 1;
                q.add(new Pair(i, k));
                vis[i][k] = true;

                result.add(new Pair(board[i][k].v, i, k));

                while (!q.isEmpty()) {
                    Pair cur = q.removeFirst();


                    for (int[] d : P1) {
                        int nx = cur.x + d[0];
                        int ny = cur.y + d[1];

                        if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                        if (vis[nx][ny] || board[cur.x][cur.y].type != board[nx][ny].type) continue;

                        vis[nx][ny] = true;
                        q.add(new Pair(nx, ny));
                        result.add(new Pair(board[nx][ny].v, nx, ny));
                        cnt++;
                    }
                }

                result.sort((o1, o2) -> {
                    if (o1.x == o2.x) {
                        if (o1.y == o2.y) {
                            return o1.z - o2.z;
                        }
                        return o1.y - o2.y;
                    }
                    return o2.x - o1.x;
                });

                result.forEach(t -> {
                    board[t.y][t.z].v--;
                });

                board[result.get(0).y][result.get(0).z].v += cnt;
                result.get(0).x += (cnt - 1);
                als.add(result.get(0));
            }
        }
    }

    static void dinnerTime() {
        /*
         *  대표자들끼리 신앙을 전파
         *	단일 조합
         *  이중 조합
         *  삼중 조합
         *
         * 같은 그룹 내에서
         *
         * */


        for (int i = 0; i < 3; i++) {
            ArrayList<Pair> group = new ArrayList<>();
            for (int k = 0; k < als.size(); k++) {
                if (countBit(als.get(k).y, als.get(k).z) == i + 1) {
                    group.add(als.get(k));
                }
            }

            // 전파자는 신앙심을 1만 남기고 전부 전파를 한다
            // 전파 방향은 B를 4로 나눈 나머지에 따라 결정

            group.sort((o1, o2) -> {
                if (o1.x == o2.x) {
                    if (o1.y == o2.y) {
                        return o1.z - o2.z;
                    }
                    return o1.y - o2.y;
                }
                return o2.x - o1.x;
            });

            for (int k = 0; k < group.size(); k++) {

                int tx = group.get(k).y;
                int ty = group.get(k).z;

                if (board[tx][ty].defenced) continue;


                int x = group.get(k).x - 1;
                int dir = group.get(k).x % 4;
                board[tx][ty].v -= x;

                ArrayDeque<Pair> q = new ArrayDeque<>();

                q.add(new Pair(tx, ty, x));

                while (!q.isEmpty()) {
                    Pair cur = q.removeFirst();
                    int nx = cur.x + P1[dir][0];
                    int ny = cur.y + P1[dir][1];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (cur.z == 0) break;

                    if (board[tx][ty].type == board[nx][ny].type) {
                        q.add(new Pair(nx, ny, cur.z));
                    } else {
                        // 강한 전파
                        if (cur.z > board[nx][ny].v) {
                            board[nx][ny].type = board[tx][ty].type;
                            cur.z -= board[nx][ny].v + 1;
                            board[nx][ny].v++;
                            board[nx][ny].defenced = true;
                            if (cur.z <= 0) break;

                        } else {
                            // 약한 전파 
                            board[nx][ny].type |= board[tx][ty].type;
                            board[nx][ny].v += cur.z;
                            board[nx][ny].defenced = true;
                            cur.z = 0;
                            if (cur.z <= 0) break;
                        }

                        q.add(new Pair(nx, ny, cur.z));
                    }
                }

            }

        }

        for (int ll = 0; ll < N; ll++) {
            for (int kk = 0; kk < N; kk++) {
                board[ll][kk].defenced = false;
            }
        }
    }

    static int countBit(int x, int y) {
        int result = 0;

        if ((board[x][y].type & (1 << 2)) > 0) {
            result++;
        }

        if ((board[x][y].type & (1 << 1)) > 0) {
            result++;
        }

        if ((board[x][y].type & (1 << 0)) > 0) {
            result++;
        }

        return result;
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new Value[N][N];

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                board[i][k] = new Value();
            }
        }

        for (int i = 0; i < N; i++) {
            String brr = br.readLine();
            for (int k = 0; k < N; k++) {
                String str = brr.charAt(k) + "";
                board[i][k].setUp(str);
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < N; k++) {
                int v = Integer.parseInt(st.nextToken());
                board[i][k].v = v;
            }
        }
    }
}
