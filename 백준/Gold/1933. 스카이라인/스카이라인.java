
import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;

    static PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> {
        if (o1.x == o2.x) {
            return o2.y - o1.y;
        }
        return o1.x - o2.x;
    });

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void solution() throws IOException {
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());

        int maxX = 0;
        int maxH = 0;
        map.put(0, 1);

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            if (pair.y > 0) {
                map.put(pair.y, map.getOrDefault(pair.y, 0) + 1);
            } else {
                int val = map.get(-pair.y);
                if (val == 1) {
                    map.remove(-pair.y);
                } else {
                    map.replace(-pair.y, val - 1);
                }
            }

            int height = map.firstKey();
            if (maxX != pair.x && maxH != height) {
                sb.append(pair.x + " " + height + " ");
                maxX = pair.x;
                maxH = height;
            }
        }

        bw.write(sb.toString().trim());
        bw.close();
        br.close();
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            pq.offer(new Pair(l, h));
            pq.offer(new Pair(r, -h));
        }
    }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}