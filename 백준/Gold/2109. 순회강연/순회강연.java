
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int T = 0;

    static int ans;

    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    static class Pair implements Comparable<Pair> {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Pair o) {
            return this.b - o.b;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        List<Pair> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.add(new Pair(a, b));
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            pq.add(list.get(i).a);
            if(pq.size() > list.get(i).b) {
                pq.poll();
            }
        }
        
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }

        System.out.println(ans);

    }
}
