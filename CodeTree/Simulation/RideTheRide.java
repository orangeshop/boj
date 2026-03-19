package codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RideTheRide {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;

    static class Node {
        int idx;
        Set<Integer> s;

        public Node(int idx, Set<Integer> s) {
            this.idx = idx;
            this.s = s;
        }
    }

    static class Pair {
        int x;
        int y;
        int cnt;
        int empty;

        public Pair(int x, int y, int cnt, int empty) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.empty = empty;
        }

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] P = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static List<Node> nodes = new ArrayList<>();
    static Node[][] board;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        for (Node c : nodes) {
            findPosition(c);
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
//                System.out.print(board[i][k].idx + " ");

                int cnt = 0;

                for(int[] p : P){
                    int nx = i + p[0];
                    int ny = k + p[1];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                    if(board[i][k].s.contains(board[nx][ny].idx)){
                        cnt++;
                    }
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
//            System.out.println();
        }
        System.out.println(answer);
    }

    private static void findPosition(Node node)  {
        List<Pair> rls = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {

                if (board[i][k] != null) continue;

                ArrayDeque<Pair> q = new ArrayDeque<>();
                int friend = 0;
                int empty = 0;

                for (int[] p : P) {
                    int nx = p[0] + i;
                    int ny = p[1] + k;

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                    if (board[nx][ny] == null) {
                        empty++;
                        continue;
                    }

                    if (node.s.contains(board[nx][ny].idx)) {
                        friend++;
                    }
                }

                rls.add(new Pair(i, k, friend, empty));
            }
        }

        rls.sort((o1, o2) -> {
            if (o1.cnt == o2.cnt) {
                if (o1.empty == o2.empty) {
                    if (o1.x == o2.x) {
                        return o1.y - o2.y;
                    }
                    return o1.x - o2.x;
                }
                return o2.empty - o1.empty;
            }
            return o2.cnt - o1.cnt;
        });

//        System.out.println(node.idx);
//        for (Pair n : rls) {
//            System.out.println(n.x + " " + n.y + " " + n.cnt + " " + n.empty);
//        }
//        System.out.println();

        board[rls.get(0).x][rls.get(0).y] = node;
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        board = new Node[N][N];

        for (int i = 0; i <= (N*N); i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int num3 = Integer.parseInt(st.nextToken());
            int num4 = Integer.parseInt(st.nextToken());

            Set<Integer> s = new HashSet<>();
            s.add(num1);
            s.add(num2);
            s.add(num3);
            s.add(num4);


            nodes.add(new Node(idx, s));
        }
    }
}
