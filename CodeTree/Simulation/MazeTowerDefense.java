package codetree;

import java.util.*;
import java.io.*;
import java.math.*;


public class MazeTowerDefense {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, ans;
    static Miro m = new Miro();

    static List<Pair> ls = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        input();

        m.init();

        for (int i = 0; i < M; i++) {
            m.attack();

            m.step2();
            m.step3();
            m.step4();
        }
        System.out.println(ans);
    }

    static class Pair {
        int x;
        int y;
        boolean die;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Pair(int x, int y, boolean die) {
            this.x = x;
            this.y = y;
            this.die = die;
        }

        Pair(int x, boolean die) {
            this.x = x;
            this.die = die;
        }
    }

    static class Miro {
        int[][] board;
        int idx = 0;

        List<Integer> route = new ArrayList<>();
        List<Integer> monster = new ArrayList<>();

        void init() {
            for (int i = 1; i < N; i++) {
                route.add(i);
                route.add(i);
            }
            route.add(N - 1);
        }

        // 공격
        void attack() {
            /*
            00 01 02
            10 11 12
            20 21 22
            */
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};

            int x = N / 2;
            int y = N / 2;

            int targetNum = 0;
            for (int i = 0; i < ls.get(idx).y; i++) {
                int nx = x + dx[ls.get(idx).x];
                int ny = y + dy[ls.get(idx).x];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                targetNum = board[nx][ny];
                score(targetNum, 1);
                board[nx][ny] = 0;
                x = nx;
                y = ny;
            }
            idx++;
        }

        void step2() {
            makeList();
            makeBoard();
            makeList();
        }

        void step3() {

            while (true) {
                if (check() == false) break;
                remove();
            }

            makeBoard();
            makeList();
        }

        void step4() {
            makeMonsterList();
            makeBoard();

        }

        boolean check() {

            List<Pair> ls = new ArrayList<>();

            for (int i = 0; i < monster.size(); i++) {
                ls.add(new Pair(monster.get(i), true));
            }

            int preNum = 0;
            int mSize = 1;

            for (int i = 0; i < ls.size(); i++) {
                if (preNum == ls.get(i).x) {
                    mSize++;
                } else {
                    if (mSize >= 4) {
                        return true;
                    }
                    preNum = ls.get(i).x;
                    mSize = 1;
                }
            }

            if (mSize >= 4) {
                return true;
            }

            return false;
        }

        // 리스트에 넣기
        void makeList() {
            ArrayDeque<Pair> q = new ArrayDeque<>();
            /*
            00 01 02
            10 11 12
            20 21 22
            */
            int[] dx = {0, 1, 0, -1};
            int[] dy = {-1, 0, 1, 0};
            int x = N / 2;
            int y = N / 2;

            int dir = 0;
            int idx = 0;
            int cnt = 0;

            q.add(new Pair(x, y));
            monster.add(0);

            while (!q.isEmpty()) {
                Pair cur = q.removeFirst();
                if (board[cur.x][cur.y] != 0) {
                    monster.add(board[cur.x][cur.y]);
                }

                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                cnt++;
                q.add(new Pair(nx, ny));

                if (idx >= route.size()) break;
                if (cnt == route.get(idx)) {
                    dir++;
                    idx++;
                    if (dir >= 4) {
                        dir = 0;
                    }
                    cnt = 0;
                }
            }
        }

        void makeBoard() {
            ArrayDeque<Pair> q = new ArrayDeque<>();

            for (int i = 0; i < N; i++) {
                for (int k = 0; k < N; k++) {
                    board[i][k] = 0;
                }
            }

            int[] dx = {0, 1, 0, -1};
            int[] dy = {-1, 0, 1, 0};
            int x = N / 2;
            int y = N / 2;

            int dir = 0;
            int idx = 0;
            int cnt = 0;

            int midx = 0;

            q.add(new Pair(x, y));

            while (!q.isEmpty()) {
                Pair cur = q.removeFirst();

                if (midx >= monster.size()) break;
                board[cur.x][cur.y] = monster.get(midx);

                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                cnt++;
                midx++;
                q.add(new Pair(nx, ny));

                if (idx >= route.size()) break;
                if (cnt == route.get(idx)) {
                    dir++;
                    idx++;
                    if (dir >= 4) {
                        dir = 0;
                    }
                    cnt = 0;
                }
            }
            monster.clear();
        }


        // 4개 연속 삭제
        // 없을 떄 까지 삭제
        boolean remove() {

            List<Pair> ls = new ArrayList<>();

            for (int i = 0; i < monster.size(); i++) {
                ls.add(new Pair(monster.get(i), true));
            }

            int preNum = 0;
            int mSize = 1;
            int startPoint = 0;

            for (int i = 0; i < ls.size(); i++) {
                if (preNum == ls.get(i).x) {
                    mSize++;
                } else {
                    if (mSize >= 4) {
                        for (int k = startPoint; k < i; k++) {
                            ls.get(k).die = false;
                        }
                        score(preNum, mSize);
                    }

                    preNum = ls.get(i).x;
                    startPoint = i;
                    mSize = 1;
                }
            }

            if (mSize >= 4) {
                for (int k = startPoint; k < ls.size(); k++) {
                    ls.get(k).die = false;
                }
                score(preNum, mSize);
            }

            monster.clear();
            for (int i = 0; i < ls.size(); i++) {
                if (ls.get(i).die == false) continue;
                monster.add(ls.get(i).x);
            }

            return true;
        }


        // 삭제가 끝난 다음에 다시 나열
        // 총 개수, 숫자의 크기
        void makeMonsterList() {

            ArrayDeque<Integer> q = new ArrayDeque<>(monster);
            ArrayList<Integer> ls = new ArrayList<>();

            q.removeFirst();

            int preNum = q.removeFirst();
            int mSize = 1;

            while (!q.isEmpty()) {
                if (preNum == q.getFirst()) {
                    mSize++;
                    q.removeFirst();
                } else {

                    ls.add(mSize);
                    ls.add(preNum);

                    preNum = q.removeFirst();
                    mSize = 1;
                }
            }

            ls.add(mSize);
            ls.add(preNum);

            monster.clear();
            monster.add(0);
            for (int i = 0; i < ls.size(); i++) {
                monster.add(ls.get(i));
            }
        }

        // 점수 개산
        void score(int point, int cnt) {
            ans += point * cnt;
        }

    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        m.board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < N; k++) {
                m.board[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            ls.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
    }
}
