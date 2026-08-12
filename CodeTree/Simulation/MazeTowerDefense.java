package CodeTree_new;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MazeTowerDefense {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[][] board;

    static int answer = 0;

    /*
     * 00 01 02
     * 10 11 12
     * 20 21 22
     * */
    static int[][] P = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    static List<Pair> ls = new ArrayList<>();

    static class Pair {
        int d;
        int p;

        public Pair(int d, int p) {
            this.d = d;
            this.p = p;
        }
    }

    static class Pair2 {
        int x;
        int y;

        public Pair2(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();

        for (int T = 0; T < M; T++) {
            removeBoard(ls.get(T).d, ls.get(T).p);
//            System.out.println("answer " + answer);
            boardToArray();

            removeArray();
            makeArr();

            arrToBoard();
        }

        System.out.println(answer);
    }

    static void removeBoard(int dir, int pw) {
        ArrayDeque<Pair2> q = new ArrayDeque<>();
        q.add(new Pair2(N / 2, N / 2));

        ArrayList<Integer> rm = new ArrayList<>();

        for (int i = 0; i < pw; i++) {
            Pair2 cur = q.removeFirst();
            int nx = cur.x + P[dir][0];
            int ny = cur.y + P[dir][1];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

            rm.add(board[nx][ny]);
            q.add(new Pair2(nx, ny));

            board[nx][ny] = 0;


        }

        int num = 1;
//        System.out.println(Arrays.toString(rm.toArray()));
        int[] arr = new int[4];

        for (int i = 0; i < rm.size(); i++) {
//            if (rm.get(i) == 0) continue;
//            num *= rm.get(i);

            arr[rm.get(i)]++;
        }

        for(int i = 1; i < 4; i++){
            answer += i * arr[i];
        }

//        answer += num;
    }

    static void boardToArray() {
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            tmp.add(i + 1);
            tmp.add(i + 1);
        }

        tmp.add(N - 1);

//        for (Integer n : tmp) {
//            System.out.println(n);
//        }

        ArrayDeque<Pair2> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[N][N];
        q.add(new Pair2(N / 2, N / 2));
        vis[N / 2][N / 2] = true;
        int dir = 2;
        int cnt = 0;
        int idx = 0;

        result.clear();

        while (!q.isEmpty()) {
            Pair2 cur = q.removeFirst();

            int nx = cur.x + P[dir][0];
            int ny = cur.y + P[dir][1];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (vis[nx][ny]) continue;

//            System.out.println(nx + " " + ny);
            if (board[nx][ny] != 0) {
                result.add(board[nx][ny]);
            }
            q.add(new Pair2(nx, ny));
            vis[nx][ny] = true;
            cnt++;
            if (idx >= tmp.size()) break;
            if (tmp.get(idx) == cnt) {
                idx++;
                dir--;
                cnt = 0;
                if (dir < 0) dir = 3;
            }
        }
    }

    static void removeArray() {
        boolean trigger = true;

        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }

        while (trigger) {
            ArrayList<Integer> ttmp = new ArrayList<>();
//            System.out.println(Arrays.toString(arr));
            trigger = false;
            int preNum = arr[0];
            int preNumCnt = 1;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == 0) continue;
                if (preNum == arr[i]) {
                    preNumCnt++;
                } else if (preNum != arr[i]) {
                    if (preNumCnt >= 4) {
                        // 제거 작업
                        for (int k = 0; k < preNumCnt; k++) {
                            arr[(i - 1) - k] = 0;
                        }
                        trigger = true;

                        answer += (preNumCnt * preNum);
                    }
                    preNum = arr[i];
                    preNumCnt = 1;
                }
            }

//            System.out.println(preNumCnt);

            if(preNumCnt >= 4){
//                System.out.println("asdasd");
                for (int k = 0; k < preNumCnt; k++) {
//                    System.out.println(N-1-k);
                    arr[(arr.length - 1) - k] = 0;
                }

                answer += preNumCnt * preNum;
            }

//            System.out.println(Arrays.toString(arr));

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) continue;
                ttmp.add(arr[i]);
            }

            arr = new int[ttmp.size()];
            for (int i = 0; i < ttmp.size(); i++) {
                arr[i] = ttmp.get(i);
            }
        }


        result.clear();
        for (int i = 0; i < arr.length; i++) {
            result.add(arr[i]);
        }
    }

    static void makeArr() {
        int[] tmp = new int[result.size()];
        ArrayList<Integer> ttmp = new ArrayList<>();

        for (int i = 0; i < result.size(); i++) {
            tmp[i] = result.get(i);
        }

        int preNum = tmp[0];
        int preNumCnt = 1;
        for (int i = 1; i < tmp.length; i++) {
            if (preNum == tmp[i]) {
                preNumCnt++;
            } else if (preNum != tmp[i]) {
                ttmp.add(preNumCnt);
                ttmp.add(preNum);

                preNumCnt = 1;
                preNum = tmp[i];
            }
        }

        ttmp.add(preNumCnt);
        ttmp.add(preNum);

        result.clear();
        result.addAll(ttmp);

//        System.out.println(Arrays.toString(ttmp.toArray()));
    }

    static void arrToBoard() {
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            tmp.add(i + 1);
            tmp.add(i + 1);
        }

        tmp.add(N - 1);

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                board[i][k] = 0;
            }
        }

        ArrayDeque<Pair2> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[N][N];
        q.add(new Pair2(N / 2, N / 2));
        vis[N / 2][N / 2] = true;
        int dir = 2;
        int cnt = 0;
        int idx = 0;

        int idx2 = 0;

        while (!q.isEmpty()) {
            Pair2 cur = q.removeFirst();

            int nx = cur.x + P[dir][0];
            int ny = cur.y + P[dir][1];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (vis[nx][ny]) continue;

            if (idx2 >= result.size()) break;
            board[nx][ny] = result.get(idx2);

            idx2++;

            q.add(new Pair2(nx, ny));
            vis[nx][ny] = true;

            cnt++;
            if (idx >= tmp.size()) break;
            if (tmp.get(idx) == cnt) {
                idx++;
                dir--;
                cnt = 0;
                if (dir < 0) dir = 3;
            }
        }


//        for (int i = 0; i < N; i++) {
//            for (int k = 0; k < N; k++) {
//                System.out.print(board[i][k] + " ");
//            }
//            System.out.println();
//        }


    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < N; k++) {
                board[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int d = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            ls.add(new Pair(d, p));
        }
    }
}
/*
 * 2차원 board에서 공격
 *
 * 2차원 -> 1차원으로 변경
 *
 * 반복 하면서 값이 연속 4개인 것들 정리
 *
 * 개수, 크기 로 다시 1차원 배열 작성
 *
 *
 *
 *
 * */