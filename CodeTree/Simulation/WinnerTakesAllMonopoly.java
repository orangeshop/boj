package codetree;

import java.util.*;
import java.io.*;


public class WinnerTakesAllMonopoly {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, K;
    static Monopoly m = new Monopoly();

    static List<Person> pls = new ArrayList<>();
    static int dieNum = 0;
    /*
    00 01 02
    10 11 12
    20 21 22
    */

    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};

    static class Monopoly {
        int[][] board;
        int[][] cnt;

        // 턴 끝에 번호가 가장 작은 플레이어만 살림
        Map<String, Integer> map = new HashMap<>();

        void setDataBoard() {
            // 리스트에서 값이 들어오면
            for (int i = 0; i < N; i++) {
                for (int k = 0; k < N; k++) {
                    int num = map.getOrDefault(i + "_" + k, -1);
                    if (num != -1) {
                        board[i][k] = num;
                        cnt[i][k] = K + 1;
                        pls.get(num).setPosition(i, k);
                    }
                }
            }
            map.clear();
        }

        void setMap(int x, int y, int idx) {

            int num = map.getOrDefault(x + "_" + y, -1);
            if (num == -1) {
                map.put(x + "_" + y, idx);
            } else {
                if (num >= idx) {
                    // num kill
                    pls.get(num).state = true;
                    map.put(x + "_" + y, idx);
                } else {
                    // idx kill
                    pls.get(idx).state = true;
                }
                dieNum++;
            }
        }


        // k 턴이 지나면 해당 칸은 주인 없는 칸으로 변경
        void removeBoard() {
            for (int i = 0; i < N; i++) {
                for (int k = 0; k < N; k++) {
                    if (cnt[i][k] == 0) continue;
                    cnt[i][k]--;

                    if (cnt[i][k] == 0) {
                        board[i][k] = 0;
                    }
                }
            }
        }
    }

    static class Person {
        int dir = -1;
        int idx = 0;
        int x = 0;
        int y = 0;
        boolean state = false;

        List<Direction> ls = new ArrayList<>();

        Person(int dir, int idx) {
            this.dir = dir;
            this.idx = idx;
        }

        Person() {
        }

        void setDir(int dir) {
            this.dir = dir;
        }

        void setPosition(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Direction getDirection(int idx) {
            return ls.get(idx);
        }

        // 가능한 방향 리스트, 내가 걸어온 리스트 두개가 들어옴
        // 가능한 방향 리스트의 사이즈가 0 -> 내가 걸어온 리스트
        void bfs() {

            ArrayList<Pair> ols = new ArrayList<>();
            ArrayList<Pair> xls = new ArrayList<>();

            for (int i = 1; i < 5; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                if (m.board[nx][ny] == 0) {
                    ols.add(new Pair(nx, ny, i));
                } else if (m.board[nx][ny] == idx) {
                    xls.add(new Pair(nx, ny, i));
                }
            }

            Pair cur;

            if (ols.isEmpty()) {
                // 내가 왔던 공간으로
                cur = nextPosition(xls);
            } else {
                cur = nextPosition(ols);
            }

            m.setMap(cur.x, cur.y, idx);
        }

        Pair nextPosition(List<Pair> ls) {
            // 우선 순위에 따라 방향 배정

            // 현재 방향에 따른 우선 순위 값을 가져오고
            // 내가 이동 가능은 칸중에서 가장 앞에 있는 위치를 반환하면 됨

            Direction direction = getDirection(dir);
            // 1 2 3 4

            List<Integer> dirLs = new ArrayList<>();
            dirLs.add(direction.f);
            dirLs.add(direction.s);
            dirLs.add(direction.t);
            dirLs.add(direction.ff);


            for (int i = 0; i < dirLs.size(); i++) {
                for (int k = 0; k < ls.size(); k++) {
                    if (dirLs.get(i) == ls.get(k).dir) {
                        this.dir = dirLs.get(i);
                        return ls.get(k);
                    }
                }
            }

            return new Pair(-1, -1, -1);
        }


    }

    static class Pair {
        int x, y;
        int dir;

        Pair(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    static class Direction {
        int f, s, t, ff;

        Direction(int f, int s, int t, int ff) {
            this.f = f;
            this.s = s;
            this.t = t;
            this.ff = ff;
        }

        Direction() {
        }
    }


    public static void main(String[] args) throws IOException {
        // Please write your code here.
        input();
        int time = 0;

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                if (m.board[i][k] != 0) {
                    m.cnt[i][k] = K;
                }
            }
        }

        for (int i = 0; i < 1005; i++) {
            for (int k = 1; k < pls.size(); k++) {
                if (pls.get(k).state) {
                    continue;
                }
                pls.get(k).bfs();
            }

            m.setDataBoard();
            m.removeBoard();

            time++;

            if (dieNum == pls.size() - 2 && !pls.get(1).state) {
                break;
            }
        }

        System.out.println(time > 1000 ? -1 : time);

    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        m.board = new int[N][N];
        m.cnt = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < N; k++) {
                m.board[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        pls.add(new Person());
        for (int i = 0; i < M; i++) {
            pls.add(new Person(Integer.parseInt(st.nextToken()), i + 1));
        }

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                if (m.board[i][k] != 0) {
                    pls.get(m.board[i][k]).setPosition(i, k);
                }
            }
        }

        for (int i = 1; i <= M; i++) {
            pls.get(i).ls.add(new Direction());
            for (int k = 0; k < 4; k++) {
                st = new StringTokenizer(br.readLine());
                int f = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                int ff = Integer.parseInt(st.nextToken());

                pls.get(i).ls.add(new Direction(f, s, t, ff));
            }
        }
    }
}
