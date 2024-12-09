
import java.io.*;
import java.util.*;

/*
*
5
8 24
8 9
8 9
9 10
9 10
0
*
* */

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;

    static int N;
    static int answer;
    static boolean[] board;

    static PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> {
        if (o1.num == o2.num) {
            if (o1.s == o2.s) {
                return o1.e - o2.e;
            }
            return o1.s - o2.s;
        }
        return o1.num - o2.num;
    });

    public static void main(String[] args) throws IOException {

        int T = 1;

        while (true) {

            N = Integer.parseInt(br.readLine());

            if (N == 0) {
                break;
            }

            init();

            answer = solution();
            System.out.println("On day " + T + " Emma can attend as many as " + answer + " parties.");

            T++;
        }
    }

    /*
     *    8 9 10 11 12 13 14 15
     * 8  0 0 0  0  0  0  0  0
     * 9  0 0 2  1  0  0  0  0
     * 10 0 0 0  0  0  0  0  0
     * 11 0 0 0  0  0  0  0  0
     * 12 0 0 0  0  2  1  0  0
     * 13 0 0 0  0  0  0  1  0
     * 14
     * 15
     *
     *
     *
     * */

    private static int solution() {
        int answer = 0;
        int pre = 8;

        board = new boolean[50];

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            

            for(int i = pair.s; i < pair.e; i++) {
                if(!board[i]){
                    board[i] = true;
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }

    static void init() throws IOException {


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.add(new Pair(end - start, start * 2, end * 2));

        }
    }

    static class Pair {
        int num;
        int s;
        int e;

        public Pair(int num, int s, int e) {
            this.s = s;
            this.e = e;
            this.num = num;
        }
    }
}
