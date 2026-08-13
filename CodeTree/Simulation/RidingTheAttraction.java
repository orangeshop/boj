package CodeTree_new;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RidingTheAttraction {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static Set<Integer>[] students;

    static List<Integer> ls = new ArrayList<>();

    static int[][] board;

    static int[][] P = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Condition {
        int friend;
        int empty;
        int x;
        int y;

        public Condition(int friend, int empty, int x, int y) {
            this.friend = friend;
            this.empty = empty;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Condition{" +
                    "friend=" + friend +
                    ", empty=" + empty +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        for (int i = 0; i < ls.size(); i++) {
            solve(ls.get(i));
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                int cnt = 0;

                for (int[] nxt : P) {
                    int nx = i + nxt[0];
                    int ny = k + nxt[1];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (students[board[i][k]].contains(board[nx][ny])) cnt++;
                }

                if(cnt == 4){
                    answer += 1000;
                }else if(cnt == 3){
                    answer += 100;
                }else if(cnt == 2){
                    answer += 10;
                }else if(cnt == 1){
                    answer += 1;
                }
            }
        }

        System.out.println(answer);
    }

    private static void solve(int idx) {
        // 모든 칸 체크 후 우선 순위에 따라 배치한다.

        // 항상 비어있는 칸으로 이동

        // 친구가 많은 위치

        // 빈 칸 // 격자 밖은 취급 안함

        // 행, 열



        ArrayList<Condition> cls = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                if (board[i][k] != 0) continue;

                int friendCnt = 0;
                int emptyCnt = 0;

                for (int[] nxt : P) {
                    int nx = i + nxt[0];
                    int ny = k + nxt[1];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (students[idx].contains(board[nx][ny])) friendCnt++;
                    if (board[nx][ny] == 0) emptyCnt++;
                }

//                System.out.println(i + " " + k + " " + friendCnt + " " + emptyCnt);

                cls.add(new Condition(friendCnt, emptyCnt, i, k));
            }
        }

        cls.sort((o1, o2) -> {
            if (o1.friend == o2.friend) {
                if (o2.empty == o1.empty) {
                    if (o1.x == o2.x) {
                        return o1.y - o2.y;
                    }
                    return o1.x - o2.x;
                }
                return o2.empty - o1.empty;
            }
            return o2.friend - o1.friend;
        });

//        for(Condition c : cls){
//            System.out.println(c);
//        }

        board[cls.get(0).x][cls.get(0).y] = idx;

//        for(int i =0; i < N; i++){
//            for(int k =0; k < N; k++){
//                System.out.print(board[i][k] + " ");
//            }
//            System.out.println();
//        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        M = (N * N) + 1;
        students = new Set[M];

        board = new int[N][N];

        for (int i = 0; i < M; i++) {
            students[i] = new HashSet<>();
        }

        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            ls.add(num);

            students[num].add(a);
            students[num].add(b);
            students[num].add(c);
            students[num].add(d);

        }

    }
}
