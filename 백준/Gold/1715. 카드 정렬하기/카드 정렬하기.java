import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int answer;
    public static void main(String[] args) throws IOException {
        init();
        solution();
        System.out.println(answer);
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());


        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(Integer.parseInt(st.nextToken()));
        }

    }

    private static void solution() {



        while (true) {
            if(pq.size() == 1) break;
            int cur1 = pq.poll();
            int cur2 = pq.poll();

//            System.out.println(cur1 + " " + cur2);
            pq.add(cur1 + cur2);
            answer += cur1 + cur2;
        }

//        answer += pq.poll();
    }


}
