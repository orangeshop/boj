package CodeTree_new;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Packman {
    static final int N = 4;

    static int M;
    static int T;

    static PackMan packman;

    // [행][열][방향별 몬스터 수]
    static int[][][] monsters = new int[N][N][9];
    static int[][][] copiedMonsters = new int[N][N][9];

    // 시체 냄새
    static int[][] smell = new int[N][N];

    // 1: 상, 2: 좌상, 3: 좌, 4: 좌하
    // 5: 하, 6: 우하, 7: 우, 8: 우상
    static int[][] monsterDir = {
            {0, 0},
            {-1, 0},
            {-1, -1},
            {0, -1},
            {1, -1},
            {1, 0},
            {1, 1},
            {0, 1},
            {-1, 1}
    };

    // 상, 좌, 하, 우
    static int[][] packmanDir = {
            {-1, 0},
            {0, -1},
            {1, 0},
            {0, 1}
    };

    static int bestEat;
    static ArrayDeque<Pair> bestRoute = new ArrayDeque<>();

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class PackMan {
        int x;
        int y;

        PackMan(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void copyMonster() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.arraycopy(
                        monsters[i][j],
                        0,
                        copiedMonsters[i][j],
                        0,
                        9
                );
            }
        }
    }

    static void moveMonster() {
        int[][][] next = new int[N][N][9];

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                for (int dir = 1; dir <= 8; dir++) {
                    int count = monsters[x][y][dir];

                    if (count == 0) {
                        continue;
                    }

                    int nextDir = dir;
                    boolean moved = false;

                    for (int attempt = 0; attempt < 8; attempt++) {
                        int nx = x + monsterDir[nextDir][0];
                        int ny = y + monsterDir[nextDir][1];

                        boolean outOfRange =
                                nx < 0 || nx >= N || ny < 0 || ny >= N;

                        boolean onPackMan =
                                packman.x == nx && packman.y == ny;

                        if (!outOfRange
                                && !onPackMan
                                && smell[nx][ny] == 0) {

                            next[nx][ny][nextDir] += count;
                            moved = true;
                            break;
                        }

                        nextDir++;

                        if (nextDir >= 9) {
                            nextDir = 1;
                        }
                    }

                    if (!moved) {
                        next[x][y][nextDir] += count;
                    }
                }
            }
        }

        monsters = next;
    }

    static int countMonster(int x, int y) {
        int count = 0;

        for (int dir = 1; dir <= 8; dir++) {
            count += monsters[x][y][dir];
        }

        return count;
    }

    static void findPackmanRoute(
            int x,
            int y,
            int depth,
            int eat,
            ArrayDeque<Pair> route,
            boolean[][] visited
    ) {
        if (depth == 3) {
            if (eat > bestEat) {
                bestEat = eat;

                bestRoute.clear();
                bestRoute.addAll(route);
            }

            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + packmanDir[dir][0];
            int ny = y + packmanDir[dir][1];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }

            boolean firstVisit = !visited[nx][ny];

            if (firstVisit) {
                visited[nx][ny] = true;
            }

            route.addLast(new Pair(nx, ny));

            int add = firstVisit
                    ? countMonster(nx, ny)
                    : 0;

            findPackmanRoute(
                    nx,
                    ny,
                    depth + 1,
                    eat + add,
                    route,
                    visited
            );

            route.removeLast();

            if (firstVisit) {
                visited[nx][ny] = false;
            }
        }
    }

    static void movePackmanAndEat() {
        for (Pair position : bestRoute) {
            packman.x = position.x;
            packman.y = position.y;

            if (countMonster(packman.x, packman.y) > 0) {
                smell[packman.x][packman.y] = 3;

                Arrays.fill(
                        monsters[packman.x][packman.y],
                        0
                );
            }
        }
    }

    static void decreaseSmell() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (smell[i][j] > 0) {
                    smell[i][j]--;
                }
            }
        }
    }

    static void hatchMonster() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int dir = 1; dir <= 8; dir++) {
                    monsters[i][j][dir] +=
                            copiedMonsters[i][j][dir];
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        input();

        for (int turn = 0; turn < T; turn++) {
            copyMonster();
            moveMonster();

            bestEat = -1;
            bestRoute.clear();

            ArrayDeque<Pair> route = new ArrayDeque<>();
            boolean[][] visited = new boolean[N][N];

            visited[packman.x][packman.y] = true;

            findPackmanRoute(
                    packman.x,
                    packman.y,
                    0,
                    0,
                    route,
                    visited
            );

            movePackmanAndEat();
            decreaseSmell();
            hatchMonster();
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer += countMonster(i, j);
            }
        }

        System.out.println(answer);
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringTokenizer st =
                new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        // 현재 코드의 입력 순서
        // 팩맨 위치 → 몬스터 정보
        st = new StringTokenizer(br.readLine());

        int packmanX =
                Integer.parseInt(st.nextToken()) - 1;
        int packmanY =
                Integer.parseInt(st.nextToken()) - 1;

        packman = new PackMan(packmanX, packmanY);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            monsters[x][y][dir]++;
        }
    }
}