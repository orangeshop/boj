package CodeTree_new;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class AtomicCollisionN {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static class Atom {
        int x;
        int y;
        int m;
        int s;
        int d;

        public Atom(int x, int y, int m, int s, int d) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.s = s;
            this.d = d;
        }

        @Override
        public String toString() {
            return "Atom{" +
                    "x=" + x +
                    ", y=" + y +
                    ", m=" + m +
                    ", s=" + s +
                    ", d=" + d +
                    '}';
        }
    }

    /*
     * 00 01 02
     * 10 11 12
     * 20 21 22
     * */
    static int[][] P = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    static int N, M, K;

    static List<Atom>[][] board;

    public static void main(String[] args) throws Exception {
        input();

        for (int i = 0; i < K; i++) {
            move();
//            System.out.println("--------------");
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                for (int j = 0; j < board[i][k].size(); j++) {
                    answer += board[i][k].get(j).m;
                }
            }
        }

        System.out.println(answer);
    }

    static void move() {
        ArrayDeque<Atom> Q = new ArrayDeque<>();

        List<Atom>[][] tBoard = new List[N][N];

        int[] P1 = {0, 2, 4, 6};
        Set<Integer> s1 = new HashSet<>();
        s1.add(0);
        s1.add(2);
        s1.add(4);
        s1.add(6);


        int[] P2 = {1, 3, 5, 7};

        Set<Integer> s2 = new HashSet<>();
        s2.add(1);
        s2.add(3);
        s2.add(5);
        s2.add(7);

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                Q.addAll(board[i][k]);
                board[i][k].clear();

                tBoard[i][k] = new ArrayList<>();
            }
        }


        while (!Q.isEmpty()) {
            Atom cur = Q.removeFirst();

//            System.out.println(cur);

            int nx = cur.x + (P[cur.d][0] * cur.s);
            int ny = cur.y + (P[cur.d][1] * cur.s);

//            System.out.println("bf " + nx + " " + ny);

            // 나머지
            if (nx >= N) {
                nx %= N;
            }

            // -7 N = 2
            if (nx < 0) {
//                while (nx < 0) {
//                    nx += N;
//                }
                nx = ((nx % N)+N) % N;
            }

            if (ny >= N) {
                ny %= N;
            }

            if (ny < 0) {
//                while (ny < 0) {
//                    ny += N;
//                }
                ny = ((ny % N)+N) % N;
            }

//            System.out.println("af " + nx + " " + ny);

            tBoard[nx][ny].add(new Atom(nx, ny, cur.m, cur.s, cur.d));
        }


//        for (int i = 0; i < N; i++) {
//            for (int k = 0; k < N; k++) {
//                for (int j = 0; j < tBoard[i][k].size(); j++) {
//                    System.out.println("move " + tBoard[i][k].get(j));
//                }
//            }
//        }

        // --------

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                if (tBoard[i][k].size() >= 2) {
                    // 원자 합치기

                    Atom resultAtom = new Atom(i, k, 0, 0, 0);

                    int m = 0;
                    int s = 0;
                    for (Atom a : tBoard[i][k]) {
                        m += a.m;
                        s += a.s;
                    }

                    resultAtom.m = m / 5;
                    resultAtom.s = s / (tBoard[i][k].size());



                    boolean checker1 = true;
                    for (Atom a : tBoard[i][k]) {
//                        for (int p1 : P1) {
//                            if (a.d != p1) {
//                                checker1 = false;
//                            }
//                        }
                        if(!s1.contains(a.d)){
                            checker1 = false;
                        }
                    }

                    boolean checker2 = true;
                    for (Atom a : tBoard[i][k]) {
//                        for (int p2 : P2) {
//                            if (a.d != p2) {
//                                checker2 = false;
//                            }
//                        }
                        if(!s2.contains(a.d)){
                            checker2 = false;
                        }
                    }

                    if (resultAtom.m == 0) continue;

//                    System.out.println(i + " " + k + " " + checker1 + " " + checker2);

                    if (checker1 || checker2) {
                        // 사 방향
                        for (int j = 0; j < 4; j++) {
                            board[i][k].add(new Atom(i, k, resultAtom.m, resultAtom.s, P1[j]));
                        }
                    }

                    if (!checker1 && !checker2) {
                        // 대각선
                        for (int j = 0; j < 4; j++) {
                            board[i][k].add(new Atom(i, k, resultAtom.m, resultAtom.s, P2[j]));
                        }
                    }


                    // 원자 나누기
                    // 1. 질량은 합쳐진 질량을 5로 나눔
                    // 2. 속력은 합쳐진 개수를 나눈 값
                    // 3. 방향은 상하좌우, 대각선일 경우 싱히좌우
                    // 아닐 경우 대각선 4방향


                    // 이때 질량이 0이면 소명


                } else {
                    board[i][k].addAll(tBoard[i][k]);
                }
            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int k = 0; k < N; k++) {
//                for (int j = 0; j < board[i][k].size(); j++) {
//                    System.out.println(board[i][k].get(j));
//                }
//            }
//        }


    }


    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new List[N][N];

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                board[i][k] = new ArrayList<>();
            }
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            board[x][y].add(new Atom(x, y, m, s, d));
        }
    }
}
