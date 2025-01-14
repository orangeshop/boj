

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static long answer;
    static ArrayList<Integer> ls = new ArrayList<>();
    static ArrayDeque<Pair> S = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(answer);
    }

    private static void solution() {
        /*
         * 2 4 1 2 2 5 1
         *
         * 2 4 *
         *
         * 4 1
         * 4 2
         * 4 2
         * 4 5 *
         *
         * 1 2 *
         *
         * 2 2
         * 2 5 *
         *
         * 2 5 *
         *
         * 5 1 *
         *
         * 자기보다 큰 수를 만나면 끝
         * */

        for (Integer l : ls) {

            int t = 0;
            while (!S.isEmpty() && S.getLast().h < l) {
                answer += S.removeLast().y;
            }

            if (!S.isEmpty() && S.getLast().h == l) {
                t = S.removeLast().y;
                answer += t;
            }

            if (!S.isEmpty()) {
                answer++;
            }

            S.addLast(new Pair(l, t + 1));

        }


    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ls.add(Integer.parseInt(st.nextToken()));
        }
    }

    static class Pair {
        int h, y;

        public Pair(int h, int y) {
            this.h = h;
            this.y = y;
        }
    }
}
