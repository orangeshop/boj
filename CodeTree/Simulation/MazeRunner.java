package codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MazeRunner {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int answer;

    interface BoardConfig {
        int EMPTY = 0;
        int WALL = 1;
        int EXIT = 2;
    }

    static int[][] P = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static int N, M, K;

    static int[][] board;

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Person {
        int x;
        int y;
        int nowDis;
        boolean state = true;
        boolean check = true;

        public Person(int x, int y, int nowDis) {
            this.x = x;
            this.y = y;
            this.nowDis = nowDis;
        }

        public void move() {
            List<Sorted> ls = new ArrayList<>();
            for (int dir = 0; dir < 4; dir++) {
                int nx = P[dir][0] + this.x;
                int ny = P[dir][1] + this.y;

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (board[nx][ny] > 0) continue;

                int dis = calc(nx, ny, exit.x, exit.y);

                if (this.nowDis <= dis) continue;

                ls.add(new Sorted(dis, dir));
            }

            ls.sort((o1, o2) -> {
                if (o1.dis == o2.dis) {
                    return o1.dir - o2.dir;
                }
                return o1.dis - o2.dis;
            });

            if (!ls.isEmpty()) {
                this.x += P[ls.get(0).dir][0];
                this.y += P[ls.get(0).dir][1];
                this.nowDis = ls.get(0).dis;
                if (this.x == exit.x && this.y == exit.y) {
                    this.state = false;
                }
                answer++;
            }
        }

        static class Sorted {
            int dis;
            int dir;

            public Sorted(int dis, int dir) {
                this.dis = dis;
                this.dir = dir;
            }
        }
    }

    static public int calc(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static List<Person> pls = new ArrayList<>();

    static Pair exit;

    public static void main(String[] args) throws IOException {
        input();

        for (int i = 0; i < K; i++) {
            for (Person p : pls) {
                if (!p.state) continue;
                p.move();
            }

            findRectangle();

            for (Person p : pls) {
                if (!p.state) continue;
                p.nowDis = calc(p.x, p.y, exit.x, exit.y);
            }
        }

        System.out.println(answer);
        System.out.println((exit.x + 1) + " " + (exit.y + 1));
    }

    static void findRectangle() {
        Rectangle rt = null;

        for (int l = 2; l <= N; l++) {
            for (int r = 0; r <= N - l; r++) {
                for (int c = 0; c <= N - l; c++) {
                    boolean hasExit = false;
                    if (exit.x >= r && exit.x < r + l && exit.y >= c && exit.y < c + l) {
                        hasExit = true;
                    }

                    boolean hasPerson = false;
                    for (Person p : pls) {
                        if (!p.state) continue;
                        if (p.x >= r && p.x < r + l && p.y >= c && p.y < c + l) {
                            hasPerson = true;
                            break;
                        }
                    }

                    if (hasExit && hasPerson) {
                        rt = new Rectangle(r, c, l);
                        break;
                    }
                }
                if (rt != null) break;
            }
            if (rt != null) break;
        }

        if (rt == null) return;

        int[][] tBoard = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                tBoard[i][k] = board[i][k];
            }
        }

        int ex = exit.x;
        int ey = exit.y;

        /*
         * 00 01 02
         * 10 11 12
         * 20 21 22
         * */
        for (int i = rt.r; i < rt.r + rt.size; i++) {
            for (int k = rt.c; k < rt.c + rt.size; k++) {
                int newR = rt.r + (k - rt.c);
                int newC = rt.c + rt.size - 1 - (i - rt.r);

                tBoard[newR][newC] = board[i][k];

                if (board[i][k] > 0) {
                    tBoard[newR][newC]--;
                }

                if (i == ex && k == ey) {
                    exit.x = newR;
                    exit.y = newC;
                }

                for (Person p : pls) {
                    if (!p.state) continue;
                    if (!p.check) continue;

                    if (i == p.x && k == p.y) {
                        p.x = newR;
                        p.y = newC;
                        p.check = false;
                    }
                }
            }
        }

        for (Person p : pls) {
            p.check = true;
        }

        board = tBoard;
    }

    static class Rectangle {
        int r;
        int c;
        int size;

        public Rectangle(int r, int c, int size) {
            this.r = r;
            this.c = c;
            this.size = size;
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < N; k++) {
                board[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            pls.add(new Person(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0));
        }
        st = new StringTokenizer(br.readLine());
        exit = new Pair(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);

        for (Person p : pls) {
            p.nowDis = calc(p.x, p.y, exit.x, exit.y);
        }
    }
}