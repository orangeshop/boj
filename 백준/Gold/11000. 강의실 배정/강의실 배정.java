
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;

    static List<Pair> ls = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    static int answer;

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(pq.size());
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for(int i =  0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ls.add(new Pair(a, b));

        }
    }

    private static void solution() {
        ls.sort((o1, o2) -> {
            if(o1.x == o2.x){
                return o1.y - o2.y;
            }
            return o1.x - o2.x;
        });

        pq.add(0);

        for(int i = 0; i < ls.size(); i++){
            if (pq.peek() <= ls.get(i).x){
                pq.poll();
            }
            pq.add(ls.get(i).y);
        }
    }
}
