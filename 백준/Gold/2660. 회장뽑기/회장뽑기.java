import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static List<Integer>[] adj;

    static int[] arr;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
        arr = new int[N+1];

        for(int i =1; i<=N; i++) {
            ArrayDeque<Integer> Q = new ArrayDeque<>();
            boolean[] vis = new boolean[N+1];

            Q.add(i);
            vis[i] = true;
            int[] cnt = new int[N+1];
            while (!Q.isEmpty()) {
                int cur = Q.removeFirst();

                for(int nxt : adj[cur]) {
                    if(!vis[nxt]) {
                        Q.add(nxt);
                        vis[nxt] = true;
                        cnt[nxt] = cnt[cur] + 1;
                    }
                }
            }

//            System.out.println(i + " "+ Arrays.toString(cnt));
            arr[i] = Arrays.stream(cnt).max().getAsInt();
        }

        int minValue = Arrays.stream(arr).filter(value -> value > 0).min().getAsInt();

        List<Integer> ls = new ArrayList<>();

        for (int i =1; i <= N; i++) {
            if(arr[i] == minValue) {
                ls.add(i);
            }
        }

        System.out.println(minValue + " " + ls.size());
        for (Integer l : ls) {
            System.out.print(l + " ");
        }
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];

        for(int i =0; i < N+1; i++){
            adj[i] = new ArrayList<>();
        }

        while (true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1) break;

            adj[a].add(b);
            adj[b].add(a);
        }

    }
}
