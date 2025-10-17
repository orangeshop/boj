import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;

    static class Pair implements Comparable<Pair> {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            if (o.y == this.y) {
                return x - o.x;
            }
            return y - o.y;
        }
    }

    // 문제 번호, 난이도
    static TreeSet<Pair> set = new TreeSet<>();
    static HashMap<Integer, Integer> map = new HashMap<>();


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            set.add(new Pair(a, b));
            map.put(a, b);

        }

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if (s.equals("add")) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                set.add(new Pair(a, b));
                map.put(a, b);
            } else if (s.equals("recommend")) {
                int a = Integer.parseInt(st.nextToken());

                if (a == 1) {
                    sb.append(set.last().x).append("\n");

                } else {

                    sb.append(set.first().x).append("\n");
                }

            } else {
                int a = Integer.parseInt(st.nextToken());
                int b = map.get(a);
                set.remove(new Pair(a, b));
                map.remove(a);

            }
        }


        System.out.println(sb.toString());

    }

}
