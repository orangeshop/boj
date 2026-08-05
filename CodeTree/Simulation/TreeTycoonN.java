package CodeTree_new;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TreeTycoonN {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[][] board;

    /*
     * 00 01 02
     * 10 11 12
     * 20 21 22
     * */

    static int[][] P = {
            {0, 0},
            {0, 1},
            {-1, 1},
            {-1, 0},
            {-1, -1},
            {0, -1},
            {1, -1},
            {1, 0},
            {1, 1},
    };

    static ArrayDeque<Pair> Q = new ArrayDeque<>();

    static class Pair {
        int dir;
        int cnt;

        public Pair(int dir, int cnt) {
            this.dir = dir;
            this.cnt = cnt;
        }
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }


    // 전역적으로 사용할 큐
    static ArrayDeque<Position> grow = new ArrayDeque<>();


    // 이동 로직
    static void move() {
        Pair cur = Q.removeFirst();

        ArrayDeque<Position> tmpGrow = new ArrayDeque<>(grow);
        grow.clear();

        while (!tmpGrow.isEmpty()) {
            Position tcur = tmpGrow.removeFirst();

            int nx = tcur.x + (P[cur.dir][0] * cur.cnt);
            int ny = tcur.y + (P[cur.dir][1] * cur.cnt);

            if (nx >= N) {
                nx = nx % N;
            }

            if(nx < 0){
                nx += N;
            }

            if (ny >= N) {
                ny = ny % N;
            }

            if(ny < 0){
                ny += N;
            }

//            System.out.println(nx + " " + ny);
            grow.add(new Position(nx, ny));
            board[nx][ny]++;
        }


//        while (!grow.isEmpty()) {
//            System.out.println(grow.removeFirst());
//        }

    }

    // 대각선 로직
    /*
    * 00 01 02
    * 10 11 12
    * 20 21 22
    * */
    static void growUp(){
        int[][] P2 = {{-1,-1},{-1,1},{1,1},{1,-1}};

        ArrayList<Position> tmpGrow = new ArrayList<>(grow);

        for(int i =0; i < tmpGrow.size(); i++){
            int cnt = 0;
            for(int[] nxt: P2){
                int nx = tmpGrow.get(i).x + nxt[0];
                int ny = tmpGrow.get(i).y + nxt[1];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(board[nx][ny] < 1) continue;

                cnt++;

            }

            board[tmpGrow.get(i).x][tmpGrow.get(i).y] += cnt;
        }



    }


    // 높이 2 이상 삭제 후 영양제 투입 로직
    static void removeAndNew(){
        boolean[][] vis = new boolean[N][N];

        while (!grow.isEmpty()){
            Position cur = grow.removeFirst();
            vis[cur.x][cur.y] = true;
        }

        for(int i =0; i < N; i++){
            for(int k =0; k < N; k++){
                if(vis[i][k] == false && board[i][k] >= 2){
                    board[i][k] -= 2;
                    grow.add(new Position(i,k));
                }
            }
        }
    }


    public static void main(String[] args) throws Exception {
        input();

        init();

        for(int i =0; i < M; i++) {

            move();

            growUp();

            removeAndNew();
        }

        int answer = 0;

//        System.out.println(grow.size());
//
//        for(int i =0; i < N; i++){
//            for(int k =0; k < N; k++){
//                System.out.print(board[i][k] + " ");
//            }
//            System.out.println();
//        }

        for(int i =0; i < N; i++){
            for(int k =0; k < N; k++){
                answer += board[i][k];
            }
        }

        System.out.println(answer);
    }

    private static void init() {
        grow.add(new Position(N - 1, 0));
        grow.add(new Position(N - 1, 1));
        grow.add(new Position(N - 2, 0));
        grow.add(new Position(N - 2, 1));

//        grow.add(new Position(3,1));
//        grow.add(new Position(4,2));

    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];

        for(int i =0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int k =0; k < N; k++){
                board[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i =0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());

            Q.add(new Pair(dir, cnt));
        }

//        Q.add(new Pair(2,3));

    }
}

/*
 * 특수 영양제 이동
 * 이동은 칸을 넘으면 반대 방향으로 이동하는 로직
 *
 * 특수 영양제를 받은 나무의 대각선에 1 이상인 나무 개수 만큼 성장
 *
 * 특수 영양제 제외한 나머지 나무에서 2높이면 2를 줄임
 * 그리고 그 곳에 영양제 투입
 *
 *
 * */