import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int K, N;
    static int[] arr = new int[105];
    static boolean[] vis = new boolean[100005];
    static PriorityQueue<Long> pq = new PriorityQueue<>();
    static HashSet<Long> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        int cnt = 0;


        while (!pq.isEmpty()) {
            long cur = pq.poll();

            if(++cnt == N){
                System.out.print(cur);
                break;
            }

            for(int i =0; i<K; i++) {
                long nxt = cur * arr[i];
                if(nxt > Integer.MAX_VALUE || set.contains(nxt)) continue;

                pq.add(nxt);
                set.add(nxt);

                if(cur % arr[i] == 0) break;
            }
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++) {

            int num = Integer.parseInt(st.nextToken());
            if(num > 541) continue;
            arr[i] = num;
            set.add((long) num);
            pq.add((long) num);
        }
    }
}
