import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static ArrayDeque<Pair> q = new ArrayDeque<>();

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n = 0, w = 0, L = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        input();

        int weight = 0;
        int cur = 0;
        int time = 0;

        q.add(new Pair(arr[cur], time));
        weight += arr[cur];
        cur++;
        time++;

        while (!q.isEmpty()) {
            Pair pair = q.peek();

//            System.out.println(pair.x + " " + pair.y);
//            System.out.println(weight + " " + cur + " " + time);

            if(pair.y <= time - w){
                Pair cccc = q.removeFirst();
                weight -= cccc.x;

//                continue;
            }

            if(cur < n) {
                if (weight + arr[cur] <= L) {
                    q.add(new Pair(arr[cur], time));
                    weight += arr[cur];
                    cur++;
                }
            }
            time++;

        }

        System.out.println(time);

    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

    }
}
