

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;

    static int[][] map;
    static int[][] food;

    static List<Pair> ls = new ArrayList<>();
    static int[] arr;
    static long[] value;
    static int[] size;


    static long[][] result;
    static boolean[][] vis;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};


    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    public static int find(int x) {
        if (arr[x] == x) {
            return x;
        }
        return arr[x] = find(arr[x]);
    }

    public static void union(int a, int b) {
        int ar = find(a);
        int br = find(b);

        if (ar == br) return;

        if (size[ar] >= size[br]) {
            arr[br] = ar;
            size[ar] += size[br];
            value[ar] += value[br];
        } else {
            arr[ar] = br;
            size[br] += size[ar];
            value[br] += value[ar];
        }
//        arr[ar] = br;
//        value[br] += value[ar];

    }

    public static int calc(int i, int k) {
        return i * M + k;
    }

    private static void solution() {

        ls.sort((o1, o2) -> {
            return o1.h - o2.h;
        });

        /*
         * 00 01 02
         * 10 11 12
         * 20 21 22
         *
         *
         * ((N-1)*i) + 00, ((N-1)*i)+01, ((N-1)*i)02,
         * ((N-1)*i) + 10, ((N-1)*i)+02 ..
         *
         * */

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                arr[calc(i, k)] = calc(i, k);
                value[calc(i, k)] = food[i][k];

            }
        }

        ArrayDeque<Pair> deque = new ArrayDeque<>();
        for (Pair cur : ls) {

            if (!deque.isEmpty() && cur.h != deque.getFirst().h) {
                while (!deque.isEmpty()) {
                    Pair pair = deque.removeFirst();
                    result[pair.x][pair.y] = value[find(calc(pair.x, pair.y))];
                }
            }


            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (map[nx][ny] > map[cur.x][cur.y]) continue;
//                if (vis[cur.x][cur.y]) {
//                    continue;
//                }

                if (find(calc(nx, ny)) != find(calc(cur.x, cur.y))) {
                    union(calc(nx, ny), calc(cur.x, cur.y));
                }

//                vis[nx][ny] = true;
            }

            deque.add(cur);

        }


        while (!deque.isEmpty()) {
            Pair pair = deque.removeFirst();
            result[pair.x][pair.y] = value[find(calc(pair.x, pair.y))];
        }


        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                System.out.print(result[i][k] + " ");
            }
            System.out.println();
        }

    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        food = new int[N][M];

        arr = new int[N * M];
        result = new long[N][M];
        value = new long[N * M];

        size = new int[N * M];

        vis = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                food[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ls.add(new Pair(i, j, map[i][j], food[i][j]));
            }
        }


    }


    static class Pair {
        int x, y, h, v;

        public Pair(int x, int y, int h, int v) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.v = v;
        }

        public Pair(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
}
